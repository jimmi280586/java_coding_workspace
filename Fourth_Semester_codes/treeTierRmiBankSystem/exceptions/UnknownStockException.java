package exceptions;

//Defines an exception for an unknown stock.

public class UnknownStockException extends StockQuoteException
{
  public UnknownStockException()
  {
  }

  public UnknownStockException(String str)
  {
       super(str);
  }
}
