package system;

//Defines the information contained in a stock quote for the
//StockQuoteClient interface.

public class StockQuote
{
  public String stock;     // the stock name
  public double amount;     // the last price
  public double change;     // the last change

  public StockQuote()
  {
  }

  public StockQuote(String stock, double amount, double change)
  {
       this.stock = stock;
       this.amount = amount;
       this.change = change;
  }
}
