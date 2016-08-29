package nxt.methods.Exercise5;

public class Display
{
	public void askquestion(String q) throws Exception
	{
		LCD.clearDisplay();

		LCD.drawString(q, 0, 0);

		Thread.sleep(3000);
	}

	public void drawNumber(int count) throws Exception
	{
		LCD.drawString("     ", 2, 3);

		LCD.drawInt(count, 5, 3);

		Thread.sleep(2000);
	}

	public void display(String result) throws InterruptedException
	{
		LCD.clearDisplay();

		LCD.drawString("result is ", 0, 0);

		LCD.drawString(result, 2, 2);

		Thread.sleep(10000);

	}
}
