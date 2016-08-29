package ev3.standardMethodes;

import lejos.hardware.motor.Motor;

public class Turn 
{
	Input data = new Input(0, null, 0, 0);
	
	public void smoth()
	{
		int power = data.getPower();
		int dis = data.getDistance();
		String way = data.getWay();
		
		int tacho = 0;
		
		Motor.A.resetTachoCount();
		Motor.A.resetTachoCount();
		
	while (tacho <= (dis * 64.4))
	{
		
		if(way.equals("right"))
		{
			Motor.A.setSpeed(power / 2);
			Motor.B.setSpeed(power);
			Motor.A.backward();
			Motor.B.backward();
		}
		
		if(way.equals("left"))
		{
			Motor.A.setSpeed(power);
			Motor.B.setSpeed(power / 2);
			Motor.A.backward();
			Motor.B.backward();
		}
				
		
		Motor.A.getTachoCount();
	}
	
	}	
	
	public void sharp()
	{
		
		int power = data.getPower();
		int dis = data.getDistance();
		String way = data.getWay();
		
		int tacho = 0;
		
		Motor.A.resetTachoCount();
		Motor.A.resetTachoCount();
		
	while (tacho <= (dis * 64.4))
	{
		
		if(way.equals("right"))
		{
			Motor.A.setSpeed(power / 2);
			Motor.B.setSpeed(power);
			Motor.A.stop();
			Motor.B.backward();
		}
		
		if(way.equals("left"))
		{
			Motor.A.setSpeed(power);
			Motor.B.setSpeed(power / 2);
			Motor.A.backward();
			Motor.B.stop();
		}
				
		
		Motor.A.getTachoCount();
	}
		
	}
	
	public void calculate()
	{
		int turn = data.getDegree();
		
		int number = (360 / turn);
		int wherl = 15;
		double cir = Math.PI * (wherl * 2);
		double dis = cir / number;
		int tacho = 0;
		String way = data.getWay();
		int power = data.getPower();
		
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount(); 
		
		while (tacho <= (dis * 64.4))
		{
			if (way.equals("right"))
			{
				Motor.A.setSpeed(power);
				Motor.B.setSpeed(power);
				
				Motor.A.stop();
				Motor.B.backward();
			}
			
			if (way.equals("left"))
			{
				Motor.A.setSpeed(power);
				Motor.B.setSpeed(power);
				
				Motor.A.backward();
				Motor.B.stop();
			}
		}
		
		
		
	}
	
	
}
