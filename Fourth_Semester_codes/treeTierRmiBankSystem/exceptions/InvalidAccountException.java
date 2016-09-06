package exceptions;

import system.Account;

//Defines an exception for an invalid account and indicates
//which account was invalid. Also allows an error string.

public class InvalidAccountException extends BankingException
{
public Account account;
//which account was invalid

public InvalidAccountException()
{
}

public InvalidAccountException(String str)
{
super(str);
}

public InvalidAccountException(Account account)
{
this.account = account;
}

public InvalidAccountException(Account account, String str)
{
super(str);
this.account = account;
}
}
