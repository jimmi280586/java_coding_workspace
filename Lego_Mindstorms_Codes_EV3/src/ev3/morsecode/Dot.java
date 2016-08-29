package ev3.morsecode;

import lejos.hardware.sensor.EV3ColorSensor;

public class Dot 
{
	EV3ColorSensor light = new EV3ColorSensor(lejos.hardware.port.SensorPort.S1);
	
	
	public void getDot() throws Exception 	
	{
		int count = 0;	
	while (count <= 5)
	{
		light.setFloodlight(true);
		//Thread.sleep(10);
		count++;
	}
		light.setFloodlight(false);
	}
	
	public void getLine() throws Exception
	{
		int count = 0;
		while (count <= 15)
		{
			light.setFloodlight(true);
			//Thread.sleep(10);
			count++;
		}
		light.setFloodlight(false);
	}
	
	public void getLetterPause() throws Exception
	{
		int count = 0;
		while (count <= 5)
		{
			light.setFloodlight(false);
			//Thread.sleep(10);
			count++;
		}
		light.setFloodlight(false);
	}
	
	public void getPause() throws Exception
	{
		int count = 0;
		while (count <= 15)
		{
			light.setFloodlight(false);
			//Thread.sleep(10);
			count++;
		}
		light.setFloodlight(false);
	}
	
	public void getWordPause() throws Exception
	{
		int count = 0;
		while (count <= 35)
		{
			light.setFloodlight(false);
			//Thread.sleep(10);
			count++;
		}
		light.setFloodlight(false);
	}
}
