package nxt.methods;


/**
 * this is the blink object used for storing the duration of one blink
 * A Blink represents a single, uninterrupted transmission of light.
 *
 */
public class Blink
{
	/**
	 * How long the blink lasted, in milliseconds
	 */
	private int duration;

	public Blink(int duration)
	{
		this.duration = duration;
	}

	public int getDuration()
	{
		return this.duration;
	}

}
