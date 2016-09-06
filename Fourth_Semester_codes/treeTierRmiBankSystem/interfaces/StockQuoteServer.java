package interfaces;

import exceptions.StockQuoteException;

//Defines a remote interface for a stock quoting system.
//Stock quotes are delivered to remote objects through the
//StockQuoteClient interface.

public interface StockQuoteServer extends java.rmi.Remote
{

//addWatch tells the server that the client wants quotes for
//a certain stock.

  public void addWatch(StockQuoteClient client, String stock)
       throws java.rmi.RemoteException, StockQuoteException;

//removeWatch tells the server that the client no longer wants
//to watch a certain stock.

  public void removeWatch(StockQuoteClient client, String stock)
       throws java.rmi.RemoteException, StockQuoteException;

//removeClient tells the server that the client no longer wants
//to watch any stocks.

  public void removeClient(StockQuoteClient client)
       throws java.rmi.RemoteException, StockQuoteException;

//getStockList returns an array of all the stocks that can be watched

  public String[] getStockList()
       throws java.rmi.RemoteException;
}
