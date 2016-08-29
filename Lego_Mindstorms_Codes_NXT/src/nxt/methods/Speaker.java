package nxt.methods;

/**
 * Provides simple methods for making sound from the robot
 *
 */
public class Speaker
{

	/**
	 * Makes a beeping sound for a desired period of time.
	 * If you want to make no sound for a period of time, pass 0 in as the volume.
	 *
	 * @param volume how loud the sound is played. Valid values are from 0-100.
	 * @param durationInMilliseconds the duration of time to make the sound
	 */
	public void makeSound(int volume, int durationInMilliseconds)
	{
		Sound.setVolume(volume); // Set the volume

		double endTime = Utility.getCurrentTime() + durationInMilliseconds; // Set the end time to the current time plus the duration given in the argument

		while(Utility.getCurrentTime() < endTime) // While the current time is less than the end time
		{
			Sound.beep(); // Keep beeping
		}
	}

}
