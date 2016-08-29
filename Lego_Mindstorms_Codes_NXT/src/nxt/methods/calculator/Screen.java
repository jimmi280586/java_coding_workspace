package nxt.methods.calculator;

public class Screen
{


	public void askquestion(String q)
	{
		LCD.clearDisplay();//clears the display

		LCD.drawString(q, 0, 0);// draws the question you ask in your class wher you use it
	}


	public void drawNumber(int count)
	{
		LCD.drawString("     ", 2, 3); // makes a space before the next line i printed

		LCD.drawInt(count, 5, 3); // prints the count on screen

	}

	public void drawOperator(String operator)
	{
		LCD.drawString(operator, 5, 3); // prints the operator in the calculator class
	}

	public void display(String result) throws InterruptedException
	{
		LCD.clearDisplay();//clears the display

		LCD.drawString("result is ", 0, 0); //prints result is on the screen

		LCD.drawString(result, 2, 2); //prints the result from the calculator class

		Thread.sleep(10000); // make the data stay on the screen

	}
}
