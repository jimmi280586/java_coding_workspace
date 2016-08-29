package nxt.methods;

/**
 * Simplifies the use of the ultrasonic sensor, for measuring distances.
 *
 */
public class DistanceSensor
{
	// calls the ultrasonic sensor from port 1
	private UltrasonicSensor ultrasonicSensor = new UltrasonicSensor(SensorPort.S1); // Get an ultrasonic sensor object

	// sets target distance to a constant of 20
	private final int TARGET_DISTANCE = 20; // Our target distance is 10 centimeters, but the robot needs a higher value so that it can stop in time.

	public int getDistance()
	{
		return this.ultrasonicSensor.getDistance();
	}

	/**
	 * @return whether the sensor reports being within the target distance from another object
	 */
	public boolean isWithinTargetDistance()
	{
		//returns true if the distance to an object is less then target distance
		return this.getDistance() <= TARGET_DISTANCE;
	}

}
