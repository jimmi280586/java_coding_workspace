package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

class CmdThreadPipe implements Runnable
{
	private final OutputStream outputStream_;
	private final InputStream inputStream_;
public CmdThreadPipe(InputStream inputstream, OutputStream outputStream)
{
      inputStream_ = inputstream;
      outputStream_ = outputStream;
  }

public void run()
  {
      try
      {
          final byte[] buffer = new byte[1024];
          for (int length = 0; (length = inputStream_.read(buffer)) != -1; )
          {
              outputStream_.write(buffer, 0, length);
          }
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
  }



public static void main(String[] args) throws InterruptedException, IOException 
{
	 String[] command =
		    {
		        "cmd",
		    };
		    Process process = Runtime.getRuntime().exec(command);
		    new Thread(new CmdThreadPipe(process.getErrorStream(), System.err)).start();
		    new Thread(new CmdThreadPipe(process.getInputStream(), System.out)).start();
		    PrintWriter print = new PrintWriter(process.getOutputStream());
		    print.println("shutdown -a");
		    //for comments displayed in the cmd use single qutations like "shutdown -s -c 'shuttingdown your computer'"
		    // write any other commands you want here
		    print.close();
		    int returnCode = process.waitFor();
		    System.out.println("Return code = " + returnCode);
}
}