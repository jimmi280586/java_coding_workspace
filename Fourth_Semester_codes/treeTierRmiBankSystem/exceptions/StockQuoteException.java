package exceptions;

//Defines a generic exception for the stock quoting system

public class StockQuoteException extends Exception
{
  public StockQuoteException()
  {
  }

  public StockQuoteException(String str)
  {
       super(str);
  }
}
