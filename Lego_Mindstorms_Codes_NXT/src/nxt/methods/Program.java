package nxt.methods;


public class Program
{

	public static void main(String[] args)
	{
		// MAIN PROGRAM

		Robot robot = new Robot();

		Utility.waitForInput("Stage One Start"); // Pause until "Enter" is pressed

		robot.runFirstStage(); // Run the first part of the program

		Utility.waitForInput("Stage Two Start"); // Pause until "Enter" is pressed

		robot.runSecondStage(); // Run the second part of the program
	}
}
