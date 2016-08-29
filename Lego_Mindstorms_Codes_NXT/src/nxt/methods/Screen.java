package nxt.methods;

/**
 * Controls writing things to the NXT display.
 *
 */
public class Screen
{

	/**
	 * Far top of screen
	 */
	private final int SCREEN_TOP = 2;
	/**
	 * Far left of screen
	 */
	private final int SCREEN_LEFT = 1;

	/**
	 * Writes a String to the display.
	 * @param message the message to display.
	 */
	public void write(String message)
	{
		this.clearDisplay();
		LCD.drawString(message, SCREEN_LEFT, SCREEN_TOP);
	}

	/**
	 * Writes a number to the display.
	 * @param number the number to display.
	 */
	public void write(double number)
	{
		this.clearDisplay();
		LCD.drawString("" + number, SCREEN_LEFT, SCREEN_TOP);
	}

	/**
	 * Writes a message to the screen, wrapping to the next lime as necessary.
	 * @param message the message to write.
	 */
	public void writeMessage(String message)
	{
		int column; // column to write the letter on (x)
		int row; // row to write the letter on (y)
		String letter; // Letter to write at each iteration

		// Loop through the message
		for (int i = 0; i < message.length(); i++)
		{
			letter = "" + message.charAt(i); // Set the letter to the character at the current index
			row = i / 16; // Integer division - will give a quotient of 1, 2, 3, etc. for indexes of < 16, < 32, < 48, etc.
			column = i % 16; // Modulus - what number is left over when i is divided by 16
			LCD.drawString(letter, column, row); // Now write everything to the screen
		}
	}


	/**
	 * Writes a String to the display for a given period of time.
	 * @param message the message to display.
	 * @param durationInMilliseconds the number of milliseconds to display on the screen.
	 */
	public void write(String message, int durationInMilliseconds)
	{
		LCD.drawString(message, SCREEN_LEFT, SCREEN_TOP);
		Utility.wait(durationInMilliseconds);
		this.clearDisplay();
	}

	/**
	 * Writes a number to the display for a given period of time.
	 * @param number the number to display.
	 * @param durationInSeconds the number of seconds to display on the screen.
	 */
	public void write(double number, int durationInMilliseconds)
	{
		LCD.drawString("" + number, SCREEN_LEFT, SCREEN_TOP);
		Utility.wait(durationInMilliseconds);
		this.clearDisplay();
	}


	/**
	 * Clears the display.
	 */
	private void clearDisplay()
	{
		LCD.clearDisplay();
	}
}
