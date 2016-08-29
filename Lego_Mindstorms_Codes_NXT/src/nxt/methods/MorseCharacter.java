package nxt.methods;


/**
 * morse caracter object handles the translation and the beep patern for the speaker system
 * A single piece of morse code, represented by both a letter and the sequence of dots and dashes that represent it.
 */
public class MorseCharacter
{
	private String pattern; // The sequence of dashes and/or dots in the character

	public MorseCharacter(String pattern)
	{
		this.pattern = pattern;
	}

	public String getPattern()
	{
		return this.pattern;
	}

	/**
	 * Translate the pattern into a letter (or a space).
	 * @return the letter represented by the pattern.
	 */
	public String getLetter()
	{
		// char is a single character
		char letter = 0; // Start with a char, set to a junk value
		if (this.pattern.equals(" ")) // If the pattern is a space
		{
			return this.pattern; // Simply return it
		}
		// Array with all the morse code characters in alphabetic order
		String[] alphabet = {
				".-", // A (65)
				"-...", // B
				"-.-.", // C
				"-..", // D
				".", // E
				"..-.", // F (70)
				"--.", // G
				"....", // H
				"..", // I
				".---", // J
				"-.-", // K (75)
				".-..", // L
				"--", // M
				"-.", // N
				"---", // O
				".--.", // P
				"--.-", // Q
				".-.", // R
				"...", // S
				"-", // T
				"..-", // U
				"...-", // V
				".--", // W
				"-..-", // X
				"-.--", // Y
				"--.." // Z
		};
		// Loop through the alphabet array
		for (int index = 0; index < alphabet.length; index++)
		{
			if(this.pattern.equals(alphabet[index])) // If the pattern matches the sequence at the current index of the alphabet
			{
				letter = (char) (index + 65); // Complicated: set our char letter to the unicode value of the desired letter meaning that the unicode for A is 65
				return "" + letter; // Return the letter as a String
			}
		}
		return "?"; // If for whatever reason the pattern didn't match anything, just return a question mark (for diagnostics)
	}

	/**
	 * Plays a pattern of beeps that correspond to the morse code pattern.
	 */
	public void playBeepPattern()
	{
		Speaker speaker = new Speaker(); // Get a speaker object
		final int VOLUME = 20; // Setting for the volume of a beep constant value

		if(this.pattern.equals(" ")) // If the pattern is just a space
		{
			speaker.makeSound(0, 350); // Make no sound for 350ms (a pause between words)
		}
		else
		{
			// Loop through the String (a substring is kind of like an index)
			for(int index = 0; index < this.pattern.length(); index++)
			{
				// sets a string to the character between the current index and the next index eksample patern ".--" index0 = . and index1 = - this means use
				//index 0 = .
				String currentCharacter = this.pattern.substring(index, index + 1); // Start at the current substring and go to the next

				if(currentCharacter.equals(".")) // If the current character is a dot
				{
					speaker.makeSound(VOLUME, 50); // Make a sound for 50ms
				}
				if(currentCharacter.equals("-")) // If the current character is a dash
				{
					speaker.makeSound(VOLUME, 150); // Make a sound for 150ms
				}
				speaker.makeSound(0, 50); // Now make no sound for 50ms (pause after each character)
			}
		}
	}

}
