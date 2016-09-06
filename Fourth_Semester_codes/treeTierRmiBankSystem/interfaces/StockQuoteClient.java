package interfaces;

import system.StockQuote;

//Defines a callback interface for the StockQuoteServer so
//it can notify its clients of new stock quotes.

public interface StockQuoteClient extends java.rmi.Remote
{
  public void quote(StockQuote quote)
  throws java.rmi.RemoteException;
}
