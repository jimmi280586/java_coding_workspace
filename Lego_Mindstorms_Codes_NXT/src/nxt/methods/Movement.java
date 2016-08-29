package nxt.methods;

/**
 * Provides easy-to-use methods for rotating and moving the robot.
 *
 */
public class Movement
{
	// Constants for the wheel ports
	private final MotorPort RIGHT_WHEEL = MotorPort.A;
	private final MotorPort LEFT_WHEEL = MotorPort.B;

	// Constants for the wheel diameter and wheel base
	private final double WHEEL_DIAMETER = 4.32;
	private final double WHEEL_BASE = 10.75;

	// Constant for the ideal motor speed
	private final int MOTOR_POWER = 75;
	private final int MOTOR_POWER_OFFSET = 2; // How much one wheel needs to be turned down so that the robot drives straight

	/**
	 * Rotates the robot for a given number of degrees.
	 * @param angle how many degrees the robot should rotate. Negative values rotate counter-clockwise.
	 */
	public void rotate(double angle)
	{
		// Wheelbase is the radius of the circle
		// So circumference is 2 * wheelbase * pi
		// The distance in one degree is circumference divided by 360
		// Multiply that by the number of degrees needed (the angle)
		double targetDistance = ((2 * this.WHEEL_BASE * Math.PI) / 360) * angle;

		this.resetBothTachoCounts(); // Reset both of the tacho counts

		if (angle < 0) // If given a negative value (turn counter-clockwise)
		{
			this.turnSingleWheelOn("right", 1); // Turn on the right wheel
			while (this.getDistanceRotated("right") <= targetDistance) // While the distance rotated is less than the target distance
			{
				// Just keep turning...
			}
		}
		if (angle >= 0) // If given a positive value (turn clockwise)
		{
			this.turnSingleWheelOn("left", 1); // Turn on the left wheel
			while (this.getDistanceRotated("left") <= targetDistance) // While the distance rotated is less than the target distance
			{
				// Just keep turning...
			}
		}
		this.turnWheelsOff(); // Turn both wheels off
	}


	/**
	 * Moves the robot forward endlessly.
	 */
	public void move()
	{
		this.turnBothWheelsOn(1);
	}

	/**
	 * Stops the robot
	 */
	public void stop()
	{
		this.turnWheelsOff();
	}

	/**
	 * Moves the robot a given distance.
	 * @param targetDistance how far the robot should move (negative values will move robot in reverse).
	 */
	public void move(double targetDistance)
	{

		this.resetBothTachoCounts(); // Reset the tacho counts

		if (targetDistance < 0) // If target distance is negative, go in reverse
		{
			this.turnBothWheelsOn(2); // Start moving in reverse
			while(this.getDistanceRotated() > targetDistance) // Until distance traveled is less than target distance
			{
				// Just keep moving...
			}
		}
		else // If target distance is not negative, go forward
		{
			this.turnBothWheelsOn(1); // Start moving forward
			while(this.getDistanceRotated() < targetDistance) // Until distance traveled is greater than target distance
			{
				// Just keep moving...
			}
		}
		this.turnWheelsOff(); // Turn off the wheels
	}




	/*
	 * HELPER METHODS - for internal use only (these mostly deal with the LEJOS API.)
	 */

	/**
	 * Gets the current distance rotated.
	 * @return the distance in degrees that the wheels have turned.
	 */
	private double getDistanceRotated()
	{
		// circumference = pi * diameter
		// Circumference is same as the distance traveled in each rotation
		double distanceInEachRotation = this.WHEEL_DIAMETER * Math.PI;

		// Get the current tacho count
		double currentTachoCount = this.LEFT_WHEEL.getTachoCount();

		/* MATH */
		// distanceInEachRotation is one full rotation, which is 360 tachos
		// So the distance traveled in one tacho is distanceInEachRotation/360
		// So totalDistance = distanceInEachRotation/360 * getTachoCount;

		// Return the distance rotated to the distance traveled per degree of rotation
		// multiplied by the number of degrees currently traveled (tachos)
		return (distanceInEachRotation / 360) * currentTachoCount;
	}

	/**
	 *  Gets the total distance rotated on a single wheel.
	 * @param wheel the wheel to measure on.
	 * @return the distance traveled in degrees.
	 */
	private double getDistanceRotated(String wheel)
	{
		double distanceInEachRotation = this.WHEEL_DIAMETER * Math.PI; // Distance in each rotation is equal to the circumference of the wheel

		double currentTachoCount = 0; // Set a default value for the new tacho count

		if (wheel.toLowerCase().equals("right")) // If told to check the right wheel
		{
			currentTachoCount = this.RIGHT_WHEEL.getTachoCount(); // Use the tacho count on the right wheel
		}
		if (wheel.toLowerCase().equals("left")) // If told to check the left wheel
		{
			currentTachoCount = this.LEFT_WHEEL.getTachoCount(); // Use the tacho count on the left wheel
		}
		return (distanceInEachRotation / 360) * currentTachoCount; // Return the distance traveled in tachos
	}

	/**
	 * Turns both wheels on.
	 * @param direction the direction to spin the wheel (1-3).
	 */
	private void turnBothWheelsOn(int direction)
	{
		this.LEFT_WHEEL.controlMotor(this.MOTOR_POWER, direction);
		this.RIGHT_WHEEL.controlMotor(this.MOTOR_POWER - this.MOTOR_POWER_OFFSET, direction);
	}

	/**
	 *  Turns a single wheel on
	 * @param wheel the wheel to turn
	 * @param direction the direction to spin the wheel (1-3)
	 */
	private void turnSingleWheelOn(String wheel, int direction)
	{
		if (wheel.toLowerCase().equals("left"))
		{
			this.LEFT_WHEEL.controlMotor(this.MOTOR_POWER, direction);
		}
		if (wheel.toLowerCase().equals("right"))
		{
			this.RIGHT_WHEEL.controlMotor(this.MOTOR_POWER, direction);
		}
	}

	/**
	 * Turns both wheels off.
	 */
	private void turnWheelsOff()
	{
		this.LEFT_WHEEL.controlMotor(this.MOTOR_POWER, 3);
		this.RIGHT_WHEEL.controlMotor(this.MOTOR_POWER, 3);
	}

	/**
	 * Resets both tacho counts.
	 */
	private void resetBothTachoCounts()
	{
		this.LEFT_WHEEL.resetTachoCount();
		this.RIGHT_WHEEL.resetTachoCount();
	}


}
