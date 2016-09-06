package system;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import exceptions.BankingException;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAccountException;
import interfaces.Banking;

// This class implements a remote banking object. It sets up
// a set of dummy accounts and allows you to manipulate them
// through the Banking interface.
//
// Accounts are identified by the combination of the account id,
// the password and the account type. This is a quick and dirty
// way to work, and not the way a bank would normally do it, since
// the password is not part of the unique identifier of the account.

public class BankingImpl extends UnicastRemoteObject implements Banking
{
     public Hashtable accountTable;

// The constructor creates a table of dummy accounts.

     public BankingImpl()
     throws java.rmi.RemoteException
     {
          accountTable = new Hashtable();

          accountTable.put(
               new Account("AA1234", "1017", Account.CHECKING),
               new Integer(50000));     // $500.00 balance

          accountTable.put(
               new Account("AA1234", "1017", Account.SAVINGS),
               new Integer(148756));     // $1487.56 balance

          accountTable.put(
               new Account("AB5678", "4456", Account.CHECKING),
               new Integer(7742));     // $77.32 balance

          accountTable.put(
               new Account("AB5678", "4456", Account.SAVINGS),
               new Integer(32201));     // $322.01 balance
     }

// getBalance returns the amount of money in the account (in cents).
// If the account is invalid, it throws an InvalidAccountException

     public int getBalance(Account account)
     throws java.rmi.RemoteException, BankingException
     {

// Fetch the account from the table
          Integer balance = (Integer) accountTable.get(account);

// If the account wasn't there, throw an exception
          if (balance == null) {
               throw new InvalidAccountException(account);
          }

// Return the account's balance
          return balance.intValue();
     }

// withdraw subtracts an amount from the account's balance. If
// the account is invalid, it throws InvalidAccountException.
// If the withdrawal amount exceeds the account balance, it
// throws InsufficientFundsException.

     public synchronized void withdraw(Account account, int amount)
     throws java.rmi.RemoteException, BankingException
     {

// Fetch the account
          Integer balance = (Integer) accountTable.get(account);

// If the account wasn't there, throw an exception
          if (balance == null) {
               throw new InvalidAccountException(account);
          }

// If we are trying to withdraw more than is in the account,
// throw an exception

          if (balance.intValue() < amount) {
               throw new InsufficientFundsException();
          }

// Put the new balance in the account

          accountTable.put(account, new Integer(balance.intValue() -
               amount));
     }

// Deposit adds an amount to an account. If the account is invalid
// it throws an InvalidAccountException

     public synchronized void deposit(Account account, int amount)
     throws java.rmi.RemoteException, BankingException
     {

// Fetch the account
          Integer balance = (Integer) accountTable.get(account);

// If the account wasn't there, throw an exception
          if (balance == null) {
               throw new InvalidAccountException(account);
          }

// Update the account with the new balance
          accountTable.put(account, new Integer(balance.intValue() +
               amount));
     }

// Transfer subtracts an amount from fromAccount and adds it to toAccount.
// If either account is invalid it throws InvalidAccountException.
// If there isn't enough money in fromAccount it throws
// InsufficientFundsException.

     public synchronized void transfer(Account fromAccount,
          Account toAccount, int amount)
     throws java.rmi.RemoteException, BankingException
     {

// Fetch the from account
          Integer fromBalance = (Integer) accountTable.get(fromAccount);

// If the from account doesn't exist, throw an exception
          if (fromBalance == null) {
               throw new InvalidAccountException(fromAccount);
          }

// Fetch the to account
          Integer toBalance = (Integer) accountTable.get(toAccount);

// If the to account doesn't exist, throw an exception
          if (toBalance == null) {
               throw new InvalidAccountException(toAccount);
          }

// Make sure the from account contains enough money, otherwise throw
// an InsufficientFundsException.

          if (fromBalance.intValue() < amount) {
               throw new InsufficientFundsException();
          }

          
// Subtract the amount from the fromAccount
          accountTable.put(fromAccount,
               new Integer(fromBalance.intValue() - amount));

// Add the amount to the toAccount
          accountTable.put(toAccount,
               new Integer(toBalance.intValue() + amount));
     }

     public static void main(String args[])
     {

// Need a security manager to prevent malicious stubs
          System.setSecurityManager(new SecurityManager());

          try {
// Create the bank
               BankingImpl bank = new BankingImpl();

// Register the bank with the naming service.
               Naming.rebind("NetBank", bank);

          } catch (Exception e) {
               System.out.println("Got exception: "+e);
               e.printStackTrace();
          }
     }
}
