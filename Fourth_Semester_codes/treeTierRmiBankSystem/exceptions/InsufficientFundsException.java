package exceptions;


//Defines a simple Insufficent Funds exception for the
//Banking interface.

public class InsufficientFundsException extends BankingException
{
  public InsufficientFundsException()
  {
  }

  public InsufficientFundsException(String problem)
  {
       super(problem);
  }
}
