package ev3.standardMethodes;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.port.TachoMotorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.internal.ev3.EV3MotorPort;
import lejos.robotics.SampleProvider;

public class Robot {

	public static void main(String[] args)
	{
	
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
		int tacho = 0;
		while(tacho <= (10 * 64)){
			
			Motor.A.forward();
			Motor.B.forward();
			Motor.A.setSpeed(750);
			Motor.B.setSpeed(750);
			tacho = Motor.A.getTachoCount();
		}
		
		Motor.A.stop();
		Motor.B.stop();
		tacho = 0;
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
		while(tacho <= (5 * 64)){
			
			Motor.A.stop();
			Motor.B.forward();
			Motor.A.setSpeed(750);
			Motor.B.setSpeed(750);
			tacho = Motor.A.getTachoCount();
		}
		Motor.A.stop();
		Motor.B.stop();
		tacho = 0;
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
	while(tacho <= (8 * 64)){
			
			Motor.B.stop();
			Motor.A.backward();
			Motor.A.setSpeed(750);
			Motor.B.setSpeed(750);
			tacho = Motor.A.getTachoCount();
		}
	
	Motor.A.stop();
	Motor.B.stop();
		
	}

}
