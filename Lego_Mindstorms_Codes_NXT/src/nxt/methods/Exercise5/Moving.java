package nxt.methods.Exercise5;

import lejos.nxt.Button;

public class Moving
{
	Display Screen = new Display();

	public int SetSpeed() throws Exception
	{
		boolean enterPressed = false; // sets all to false
		int count = 0; // count starts at 0
		int sleep = 500; // sleep starts at 500

		Screen.askquestion("enter the power");

		Screen.askquestion("press and hold"); // imports the screen class i have made

		while (enterPressed == false) // makes a loop
		{
			Screen.drawNumber(count); // imports the number methods in screen class


			if (Button.ENTER.isDown())
			{
				enterPressed = true; // terminates the loop
			}

			if (Button.LEFT.isDown() && count >= 0)
			{
				count--; // decrements the count
			}

			if (Button.RIGHT.isDown() && count <= 100)
			{
				count++; // increments the count
			}
			Thread.sleep(sleep);

			while (count < 0 || count > 100)
			{
				Screen.askquestion("invalid number");

				if (count < 65)
				{
					Screen.askquestion("insufisiant power");
				}

			}


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

			Screen.drawNumber(count);
		}

		return count;


	}

	public int SetAngle() throws Exception
	{
		boolean enterPressed = false; // sets all to false
		int count = 0; // count starts at 0
		int sleep = 500; // sleep starts at 500

		Screen.askquestion("enter the angle");

		Screen.askquestion("press and hold"); // imports the screen class i have made

		while (enterPressed == false) // makes a loop
		{
			Screen.drawNumber(count); // imports the number methods in screen class


			if (Button.ENTER.isDown())
			{
				enterPressed = true; // terminates the loop
			}

			if (Button.LEFT.isDown() && count >= -180)
			{
				count--; // decrements the count
			}

			if (Button.RIGHT.isDown() && count <= 180)
			{
				count++; // increments the count
			}
			Thread.sleep(sleep);

			while (count < -180 || count < 180)
			{
				Screen.askquestion("invalid number");


			}


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
			Screen.drawNumber(count);
		}

		return count;

	}

	public int SetDistance() throws Exception
	{
		boolean enterPressed = false; // sets all to false
		int count = 0; // count starts at 0
		int sleep = 500; // sleep starts at 500

		Screen.askquestion("enter the distance in cm");

		Screen.askquestion("press and hold"); // imports the screen class i have made

		while (enterPressed == false) // makes a loop
		{
			Screen.drawNumber(count); // imports the number methods in screen class


			if (Button.ENTER.isDown())
			{
				enterPressed = true; // terminates the loop
			}

			if (Button.LEFT.isDown() && count >= 0)
			{
				count--; // decrements the count
			}

			if (Button.RIGHT.isDown() && count <= 100)
			{
				count++; // increments the count
			}
			Thread.sleep(sleep);

			while (count > 0 || count < 100)
			{
				Screen.askquestion("invalid number");

				if (count < 10)
				{
					Screen.askquestion("insufisiant distance");
				}

			}


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

			Screen.drawNumber(count);
		}
		return count;

	}

	 public boolean confirm()
	 {
	 int buttonPressed = Button.waitForAnyPress();
	 if ( buttonPressed == Button.ID_ENTER )
	 {
	 return true;
	 }
	 else if (buttonPressed == Button.ID_ESCAPE)
	 {
	 return false;
	 }
	 else
	 {
	 return confirm();
	 }
	 }

	}

}
