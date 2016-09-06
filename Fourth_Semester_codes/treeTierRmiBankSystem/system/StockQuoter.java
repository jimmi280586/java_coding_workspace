package system;

import interfaces.StockQuoteClient;
import interfaces.StockQuoteServer;

import java.rmi.server.UnicastRemoteObject;

// This class is a client of the StockQuoteServer. It acts as a
// server too, since the StockQuoteServer invokes the update method
// in this object.

public class StockQuoter extends UnicastRemoteObject
implements StockQuoteClient
{
     public StockQuoter()
     throws java.rmi.RemoteException
     {
     }

// When we receive a stock quote, just print out the information

     public void quote(StockQuote stockQuote)
     throws java.rmi.RemoteException
     {
          System.out.println(stockQuote.stock+": "+stockQuote.amount+
               "("+stockQuote.change+")");
     }

     public static void main(String[] args)
     {
// Always use a security manager for RMI.
          System.setSecurityManager(new SecurityManager());

          try {

// Get a stub to the stock quoting system
               StockQuoteServer server = (StockQuoteServer)
                    java.rmi.Naming.lookup("StockQuotes");

// Create an instance of this object to receive the incoming stock quotes
               StockQuoter quoter = new StockQuoter();

// Get a list of all the stock we can watch
               String[] stocks = server.getStockList();

// Subscribe to each stock
               for (int i=0; i < stocks.length; i++) {
                    server.addWatch(quoter, stocks[i]);
               }

          } catch (Exception e) {
               System.out.println("Got exception: "+e);
               e.printStackTrace();
          }
     }
}
