package nxt.methods.calculator;


import java.awt.Button;


public class Calculator
{

	public int number(String order) throws InterruptedException
	{
	Screen display = new Screen();

	boolean enterPressed = false; // sets all to false
	int count = 0; // count starts at 0
	int sleep = 500; // sleep starts at 500

	display.askquestion("enter the " + order + " number");

	display.askquestion("press and hold"); // imports the screen class i have made

	while(Button.ENTER.isDown()){}

	while (enterPressed == false) // makes a loop
	{
		display.drawNumber(count); // imports the number methods in screen class


		if (Button.ENTER.isDown())
		{
			enterPressed = true; // terminates the loop
		}

		if (Button.LEFT.isDown())
		{
			count--; // decrements the count
		}

		if (Button.RIGHT.isDown())
		{
			count++; // increments the count
		}
		Thread.sleep(sleep);

		 // makes the program to go faster as long as you hold down the button
		if (Button.RIGHT.isDown() || Button.LEFT.isDown())
		{
			sleep = sleep/2;
			if (sleep < 50)
			{
				sleep = 50;
			}
		}
		else // makes sleep return to 500 when you release button
			sleep=500;
	}
	return count;


	}

	private String setOperator()
	{
		Screen display = new Screen(); // calls the screen class

		String[] op = {"+", "-", "*", "/"}; // makes a string array with the operators

		int i = 0;

		boolean enterPressed = false; // sets enter button to false

		display.askquestion("operator"); // askes a question on the screen

		while (enterPressed == false) // uses a while loop as long as enter is not pressed
		{
			display.drawOperator(op[i]); // displays the curent operator

			int b = Button.waitForAnyPress(); // waits for press of button

			if ( b == Button.ID_ENTER) // tells that if enter is pressed cange to true and that will end the while loop
			{
				enterPressed = true;
			}

			if (b == Button.ID_LEFT) // if left button is pressed
			{
				if (i == 0) // if the index is at 0
				{
					continue; // starts the loop at line 75 again
				}

				else
				{
					i--; // decrement the index
				}

			}

			if (b == Button.ID_RIGHT) // if right button is pressed
			{
				if (i == 3) // if the index is at position 3
				{
					continue; // starts the loop at line 75 again
				}

				else
				{
					i++; // increment the index
				}

			}
		}

		return op[i]; //return the operator in the index position chosen

	}

	public void calculate() throws InterruptedException
	{
		Screen display = new Screen();

		int first; // holds the first number you input
		int second; // holds the second number you input
		String operator; // hold the operator you chose

		double result = 0; // holds the result

		first = number("first"); // sets the first number
		operator = setOperator(); // sets the operator
		second = number("second"); // sets the second number

		if (operator.equals("+")) // makes the calculation and the
			//.equals checks that the operator is equal to the one in the parentesses
		{
			result = first + second;
		}

		if (operator.equals("-"))
		{
			result = first - second;
		}

		if (operator.equals("*"))
		{
			result = first * second;
		}

		if (operator.equals("/"))
		{
			result = (double) first / second;
		}

		display.display("" + result); // send the result to the screen



	}
}
