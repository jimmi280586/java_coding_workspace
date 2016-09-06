package system;

import java.rmi.Naming;

import interfaces.Banking;

// This program tries out some of the methods in the BankingImpl
// remote object.

public class BankingClient
{

     public static void main(String args[])
     {

// Always set up a security manager when running RMI
          System.setSecurityManager(new SecurityManager());

// Create an Account object for the account we are going to access.

          Account myAccount = new Account(
               "AA1234", "1017", Account.CHECKING);

          try {

// Get a stub for the BankingImpl object (the stub implements the
// Banking interface).

               Banking bank = (Banking)Naming.lookup("NetBank");

// Check the initial balance
               System.out.println("My balance is: "+
                    bank.getBalance(myAccount));

// Deposit some money
               bank.deposit(myAccount, 50000);

// Check the balance again
               System.out.println("Deposited $500.00, balance is: "+
                    bank.getBalance(myAccount));

// Withdraw some money
               bank.withdraw(myAccount, 25000);

// Check the balance again
               System.out.println("Withdrew $250.00, balance is: "+
                    bank.getBalance(myAccount));

          } catch (Exception e) {
               System.out.println("Got exception: "+e);
               e.printStackTrace();
          }
     }
}
