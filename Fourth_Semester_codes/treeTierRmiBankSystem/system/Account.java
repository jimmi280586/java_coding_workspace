package system;

//This class contains the information that defines
//a banking account.

public class Account extends Object
{
//Flags to indicate whether the account is savings or checking
  public static final int CHECKING = 1;
  public static final int SAVINGS = 2;

  public String id;     // Account id, or account number
  public String password;     // password for ATM transactions
  public int which;     // is this checking or savings

  public Account()
  {
  }

  public Account(String id, String password, int which)
  {
       this.id = id;
       this.password = password;
       this.which = which;
  }

  public String toString()
  {
       return "Account { "+id+","+password+","+which+" }";
  }

//Tests equality between accounts.
  public boolean equals(Object ob)
  {
       if (!(ob instanceof Account)) return false;
       Account other = (Account) ob;

       return id.equals(other.id) &&
            password.equals(other.password) &&
            (which == other.which);
  }

//Returns a hash code for this object

  public int hashCode()
  {
       return id.hashCode()+password.hashCode()+which;
  }

}
