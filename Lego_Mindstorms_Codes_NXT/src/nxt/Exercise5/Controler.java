package nxt.Exercise5;

import java.util.ArrayList;

public class Controler {
	ArrayList<DataSet> List = new ArrayList<DataSet>();

	Display screen = new Display();

	Motors mot = new Motors();

	Moving mov = new Moving();



	public static void main(String[] args)
	{
		Controler con = new Controler();
		con.run();
	}




	private void run()
	{
	while()
	{
		int angle, speed, distance;

		speed = mov.SetSpeed();

		angle = mov.SetAngle();

		distance = mov.SetDistance();


	}

	public void storeDataSet(int angle, int speed, int distance)
	{
		DataSet data = new DataSet(angle, speed, distance);

		data.setAngle(angle);
		data.setSpeed(speed);
		data.setDistance(distance);

		DataSet.add(data);
	}





	}

}
