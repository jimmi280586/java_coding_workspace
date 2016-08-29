package ev3.standardMethodes;

public class Input 
{
	int power;
	String way;
	int distance;
	int degree;
	
	public Input(int power, String way, int distance, int degree) {
		super();
		this.power = power;
		this.way = way;
		this.distance = distance;
		this.degree = degree;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
	
	
	
}
