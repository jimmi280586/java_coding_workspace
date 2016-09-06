package interfaces;

import exceptions.BankingException;
import system.Account;

// This interface represents a set of remote methods for a
	// banking service. All money amounts are given in cents, so
	// one dollar is represented as 100.

	public interface Banking extends java.rmi.Remote
	{

	// getBalance returns the current balance in the account
	     public int getBalance(Account account)
	          throws java.rmi.RemoteException, BankingException;

	// withdraw subtracts an amount from an account
	     public void withdraw(Account account, int amount)
	          throws java.rmi.RemoteException, BankingException;

	// deposit adds an amount to the account
	     public void deposit(Account account, int amount)
	          throws java.rmi.RemoteException, BankingException;

	// transfer subtracts an amount from one account and
	// adds it to another.
	     public void transfer(Account fromAccount, Account toAccount,
	          int amount)
	          throws java.rmi.RemoteException, BankingException;
}
