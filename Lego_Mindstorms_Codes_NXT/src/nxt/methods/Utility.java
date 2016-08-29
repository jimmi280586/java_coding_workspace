package nxt.methods;


import java.awt.Button;


/**
 * Provides helpful utilities.
 *
 * All the methods here should be static, which means you don't need to make a new object before using them.
 * For example, just write "Utility.sleep()".
 *
 */
public class Utility
{

	/**
	 * Stalls the robot until Enter button is pressed.
	 */
	public static void waitForInput(String message)
	{
		Screen screen = new Screen();
		while(!Button.ENTER.isDown())
		{
			screen.write(message, 100);
		}
	}

	/**
	 * Get the current system time.
	 * @return the current time (in milliseconds).
	 */
	public static long getCurrentTime()
	{
		return System.currentTimeMillis();
	}

	/**
	 * Makes the program wait for the given number of milliseconds.
	 * @param milliseconds the amount of time to wait .
	 */
	public static void wait(int milliseconds)
	{
		Delay.msDelay(milliseconds);// the same as thread.sleep but without exeptions as it can not be interupted
	}

}
