package nxt.methods;

public class LightReader
{
// field for leightsensor and target light value
	private LightSensor lightSensor;
	final int TARGET_LIGHT_VALUE = 40;

	public LightReader()
	{
		// calls the light sensor from port 4
		this.lightSensor = new LightSensor(SensorPort.S4);
	}

	/**
	 * Simply reads the current light value, using the light sensor.
	 * @return the current light value (0-100).
	 */
	public int readLightValue()
	{
		return this.lightSensor.getLightValue();
	}

	/**
	 * Makes a sequence of blinks of light.
	 * @return a sequence of blinks of light.
	 */
	public Sequence createSequence()
	{
		// calls the screen class
		Screen screen = new Screen(); // Bring in a screen object (for diagnostics)

		// cals the sequence class
		Sequence sequence = new Sequence(); // Make a new sequence
		//blink object
		Blink currentBlink; // The blink being created in each loop


		// Variables for timestamps and durations needs to be long becuse of the large number
		long startTime;
		long endTime;
		int duration;

		// checks to se if the number of blinks is under or equal to 15
		while(sequence.getNumberOfBlinks() <= 15)
		{
			startTime = Utility.getCurrentTime(); // Make a timestamp for when the light begins using the utility class
			while (this.readLightValue() >= this.TARGET_LIGHT_VALUE) // While the light is shining
			{
				// Do nothing
				screen.write(this.readLightValue(), 100); // Print the light value to the screen (for diagnostics)
			}
			endTime = Utility.getCurrentTime(); // Make a timestamp for when the light ends

			duration = (int) (endTime - startTime); // Store the duration as an int (will certainly be a small enough number)

			currentBlink = new Blink(duration); // Make a new blink with the duration

			sequence.addBlink(currentBlink); // Add the blink to the sequence arraylist

			while(this.readLightValue() < this.TARGET_LIGHT_VALUE) // While the light is not shining
			{
				// Do nothing
				screen.write(this.readLightValue(), 100); // Print the light value to the screen (for diagnostics)
			}
		}
		return sequence; // Return the sequence arraylist when the loop has ended
	}

	/**
	 * Finds out whether a new light sequence has begun. Checks for 5 milliseconds.
	 * @return whether the light sequence has started.
	 */
	public boolean lightSequenceHasBegun()
	{
		final int STARTING_LIGHT_STRENGTH = this.readLightValue(); // The light strength measured when the method starts final = constant can not be changed
		final long END_TIME = Utility.getCurrentTime() + 5; // The time at which to stop checking

		if(STARTING_LIGHT_STRENGTH > this.TARGET_LIGHT_VALUE) // If the starting light strength is already bright enough to be a light
		{
			return true; // Report that the sequence has begun
		}

		while(Utility.getCurrentTime() < END_TIME) // As long as the current time is less than the end time
		{
			if(this.readLightValue() > (STARTING_LIGHT_STRENGTH) * 1.5 ) // If the current light strength is much brighter than the starting
			{
				return true; // Report that the sequence has begun
			}
		}
		return false; // If the light strength has not changed very much, report that no sequence has begun
	}

	/**
	 * turns the robot 360 degree while it reads and stores the light values
	 * it then stores the angle wher it read the largest light value
	 * Finds the angle at which the brightest light source is recorded.
	 * @return the angle og the largest light value
	 */
	public int findBrightestLightSourceAngle()
	{
		Movement movement = new Movement(); // calls the movement class

		int brightestLight = 0; // Holds the highest light value
		int brightestLightSourceAngle = 0; // Holds the angle at which the highest light value is recorded

		for(int i = 0; i < 360; i++) // For one full rotation (360 degrees)
		{
			movement.rotate(1); // Rotate one degree clockwise using method from movement class

			if(this.readLightValue() > brightestLight) // If current light value is higher than the brightest recorded so far
			{
				brightestLight = this.readLightValue(); // Set a new highest light value
				brightestLightSourceAngle = i; // Record the current angle of the current position
			}
		}
		return brightestLightSourceAngle; // Return the angle with the highest light value
	}

	/**
	 * reads light and translates them to morse code paterns and then returns those paterns for use
	 * Reads in blinks of morse code and turns them into a pattern of dots and dashes.
	 * @return the pattern of dots and dashes (morse code).
	 */
	public String createMorsePattern()
	{
		// Make an empty string to hold the new pattern
		String pattern = "";

		// Variables to hold the times and durations
		long lightStartTime;
		long lightEndTime;
		long lightDuration;
		long noLightEndTime;
		long noLightDuration;

		while(true) // Go forever (until a return is hit) infinety loop
		{
			lightStartTime = Utility.getCurrentTime(); // Make a timestamp when the light starts
			while (this.readLightValue() >= this.TARGET_LIGHT_VALUE) // While the light is shining
			{
				// Do nothing
				Utility.wait(10); // Pause before sampling again. Seems to improve accuracy slightly. waiting for 10 milliseconds
			}
			lightEndTime = Utility.getCurrentTime(); // Make a timestamp when the light ends

			lightDuration = lightEndTime - lightStartTime; // Calculate the duration of the blink of light

			if (lightDuration >= 35 && lightDuration <= 65 ) // If duration is around 50ms needed to have a large margin for error
			{
				pattern += "."; // Add a dot to the string pattern
			}

			if (lightDuration >= 100 && lightDuration <= 200  ) // If duration is around 150ms
			{
				pattern += "-"; // Add a dash to the string pattern
			}

			while(this.readLightValue() < this.TARGET_LIGHT_VALUE) // While the light is not shining
			{
				// Do nothing
			}
			noLightEndTime = Utility.getCurrentTime(); // Make a timestamp when the light starts shining again

			noLightDuration = noLightEndTime - lightEndTime; // Calculate the duration when the light was not shining

			if(noLightDuration >= 100 && noLightDuration <= 200) // If duration is around 150ms
			{
				return pattern; // The pattern is now finished and it returns it
			}

			if(noLightDuration >= 300) // If duration is at least 350ms
			{
				pattern += " "; // Add a space (a space between words) to the pattern like this ".-- " we take care of the space later
				return pattern; // The pattern is now finished
			}
		}
	}
/**
 * turns of the light sensors floodlight for more acurate reading
 */
	public void turnOffLight()
	{
		this.lightSensor.setFloodlight(false);
	}

}
