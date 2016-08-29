package nxt.methods;


import java.awt.Button;
import java.util.ArrayList;

/**
 * Represents the actual Lego Robot.
 * Combines all the components together to make a single working system, and runs the two main methods in the program.
 *
 */
public class Robot
{
	// All of the components that make up our robot.
	// These can just be declared and initialized here as fields.
	private Movement movement = new Movement();
	private DistanceSensor distance = new DistanceSensor();
	private Screen screen = new Screen();
	private LightReader lightReader = new LightReader();
	private Speaker speaker = new Speaker();

	// Our robot will use this to hold the sequence of morse code letters
	private ArrayList<MorseCharacter> morseSequence = new ArrayList<MorseCharacter>();

	public Robot()
	{
		this.lightReader.turnOffLight(); // Turn off the floodlight
	}


	/**
	 * Executes the first part of the program.
	 */
	public void runFirstStage()
	{
		while(!this.lightReader.lightSequenceHasBegun()) // Until the light sequence has begun
		{
			// Wait...
			screen.write("Waiting", 100);
		}

		Sequence sequence = this.lightReader.createSequence(); // Create a sequence of blinks and add it to the list of sequences using the method from lightreader

		double largestBlinkDuration = sequence.getLargestBlink().getDuration(); // Get the largest blink duration and cast it as a double
		double secondLargestBlinkDuration = sequence.getSecondLargestBlink().getDuration(); // Get the second largest blink duration and cast it as a double

		this.speaker.makeSound(100, 500); // When the sequence is finished, beep loudly for half a second to tell that the sequence is done

		this.screen.write("1: " + largestBlinkDuration, 5000);// prints larest blink for 5 sec
		this.screen.write("2: " + secondLargestBlinkDuration, 5000); //prints the second largest for 5 sec

		this.movement.rotate(largestBlinkDuration / 10); // Rotate based on the largest blink
		// we use 10 becuse millisecond to sec you divide by 1000 and then we need to multyply by 100 to get the corect number we need that is the same as divideing by 10

		this.movement.move(secondLargestBlinkDuration / 10); // Move based on the second largest blink value
	}


	/**
	 * Executes the second part of the program.
	 */
	public void runSecondStage()
	{
		// Step 1: Find the other transmitter and go to it

		int brightestLightSourceAngle = this.lightReader.findBrightestLightSourceAngle(); // Find the brightest light source

		this.movement.rotate(brightestLightSourceAngle); // Rotate towards the brightest light source

		this.movement.move(); // Move to the light source

		while(!this.distance.isWithinTargetDistance()) // Stop 10cm in front of the light source
		{
			// Keep going...
		}
		this.movement.stop(); // Stop moving


		// Step 2: Read morse code, process it, and repeat it back
		Utility.waitForInput("Morse Start"); // Wait to start the next step (so that robot can be placed in front of brick manually)

		while(!this.lightReader.lightSequenceHasBegun()) // Wait until the morse code sequence begins
		{
			screen.write("Waiting", 100);
		}

		while(!this.morseSequenceIsFinished(this.morseSequence) && Button.ENTER.isUp()) // Until the sequence has ended enter is for if it trows an exeption press enter
			// and the method will continue
		{
			String pattern = this.lightReader.createMorsePattern(); // Get a pattern from the light reader
			//trims the patern so that if the patern is ".-- " it removes the space at the end like this ".--"
			MorseCharacter morseCharacterTrimmed = new MorseCharacter(pattern.trim());
			this.screen.write(morseCharacterTrimmed.getLetter());//prints the letter to screen
			this.morseSequence.add(morseCharacterTrimmed); // Add the pattern with any trailing space removed to the arraylist

			if(pattern.length() > 0)
			{
				if(pattern.substring((pattern.length() - 1), pattern.length()).equals(" ")) // If the pattern had a space (" ") on the end, it's a space between words
				{
					this.morseSequence.add(new MorseCharacter(" ")); // Add another pattern that's just a space
				}
			}
		}

		this.movement.move(-50); // Move back 50cm


		// Beep the morse code while printing it to the screen
		String morseCodeMessage = "";
		//a for each loop
		/*
		 * the for each lopp works like this
		 * for each morsecarecter in the morsesequence arraylist what is in the {}
		 */
		for(MorseCharacter morseCharacter : this.morseSequence) // For each character of morse code in the sequence
		{
			morseCodeMessage += morseCharacter.getLetter();// adds the letter to the message string
			this.screen.writeMessage(morseCodeMessage); // Build the message out on the screen
			morseCharacter.playBeepPattern(); // Play the beep pattern
		}
		Utility.wait(20000); //wait for 20 seconds
	}

	/**
	 * Checks whether the morse code sequence has finished.
	 * @param morseSequence the morse code sequence to check.
	 * @return whether the morse code sequence has finished.
	 */
	public boolean morseSequenceIsFinished(ArrayList<MorseCharacter> morseSequence) // Needs to be public so we can test
	{
		String message = ""; // Start with an empty string for the message
		//a for each loop
				/*
				 * the for each lopp works like this
				 * for each morsecarecter in the morsesequence arraylist what is in the {}
				 */
		for(MorseCharacter morseCharacter : morseSequence) // "For each character in the sequence"
		{
			message += morseCharacter.getLetter(); // Add each character's letter to the message string
		}
		// Return whether the last 7 letters in the message equal "goodbye"
		if(message.length() >= 7) // Don't look unless the message is at least 7 letters long
		{
			return message
					.substring(message.length() - 7, message.length()) // If the last 7 letters in the message
					.equalsIgnoreCase("goodbye"); // Are equal to "goodbye" ignore small and big letters
		}
		return false;
	}
}
