package exceptions;


//Defines a generic banking exception for the banking interface.

public class BankingException extends Exception
{
  public BankingException()
  {
  }

  public BankingException(String problem)
  {
       super(problem);
  }
}
