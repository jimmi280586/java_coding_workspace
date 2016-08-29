package nxt.methods;


import java.util.ArrayList;

/**
 * Holds a series of blinks of light.
 *
 */
public class Sequence
{
	/**
	 * Holds all of the blinks in the sequence.
	 */
	private ArrayList<Blink> listOfBlinks;


	public Sequence()
	{
		this.listOfBlinks = new ArrayList<Blink>();
	}

	public void addBlink(Blink blink)
	{
		this.listOfBlinks.add(blink);
	}

	/**
	 * Find the largest blink in the sequence.
	 * @return the largest blink in the sequence.
	 */
	public Blink getLargestBlink()
	{
		Blink largestBlink = this.listOfBlinks.get(0); // Start with the first blink
		for(int i = 0; i < this.listOfBlinks.size(); i++) // Go through the sequence
		{
			if(listOfBlinks.get(i).getDuration() > largestBlink.getDuration()) // If the current blink is larger than the largest
			{
				largestBlink = listOfBlinks.get(i); // Set the current blink as the new largest
			}
		}
		return largestBlink; // Return the largest blink
	}

	/**
	 * Find the second largest blink in the sequence.
	 * @return the second largest blink in the sequence.
	 */
	public Blink getSecondLargestBlink()
	{

		int longestBlinkDuration = this.getLargestBlink().getDuration(); // Get the duration of the largest blink
		for (int i = 0; i < this.listOfBlinks.size(); i++) // Go through the sequence
		{
			int currentDuration = this.listOfBlinks.get(i).getDuration(); // Get the duration of the blink at the current index
			if(currentDuration >= longestBlinkDuration - 50 && currentDuration <= longestBlinkDuration + 50) // If the current blink duration is basically the same as the largest
			{
				this.listOfBlinks.remove(i); // Remove it from the sequence
			}
		}
		// Now find the largest remaining blink
		Blink secondLargestBlink = this.listOfBlinks.get(0); // Start with the first blink
		for(int i = 0; i < this.listOfBlinks.size(); i++) // Go through the sequence
		{
			if(listOfBlinks.get(i).getDuration() > secondLargestBlink.getDuration()) // If the current blink is larger than the largest
			{
				secondLargestBlink = listOfBlinks.get(i); // Set the current blink as the new largest
			}
		}
		return secondLargestBlink; // Return the largest blink
	}


	/**
	 * @return the number of blinks in the sequence.
	 */
	public int getNumberOfBlinks()
	{
		return this.listOfBlinks.size();
	}
}
