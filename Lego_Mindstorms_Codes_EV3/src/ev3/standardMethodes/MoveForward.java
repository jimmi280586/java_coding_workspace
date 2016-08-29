package ev3.standardMethodes;

import lejos.hardware.motor.Motor;



public class MoveForward 
{
	
	
	public void forward(int p, String w, int d, int deg)
	{
		Input data = new Input(p, w, d, deg);
		
		int power = data.getPower();
		int dis = data.getDistance();
		String way = data.getWay();
		int tacho = 0;
		
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
		
		while(tacho <= (dis * 64.4))
		{
		
		Motor.A.setSpeed(power);
		Motor.B.setSpeed(power);
		
		if(way.equals("backward"))
		{
			Motor.A.backward();
			Motor.B.backward();
		}
		
		if(way.equals("forward"))
		{
			Motor.A.forward();
			Motor.B.forward();
		}
		Motor.A.getTachoCount();
		}
		
	}
	
	
	
}
