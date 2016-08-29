package nxt.methods.Exercise5;

public class Motors {
	Moving mov = new Moving();


	private void motor() throws Exception {
		int speed = mov.SetSpeed();
		int cm = mov.SetDistance();
		int angle = mov.SetAngle();
		int Tacho = 0;

		MotorPort.A.resetTachoCount();
		MotorPort.B.resetTachoCount();
		while (Tacho <= (cm * 64.4))
			MotorPort.A.controlMotor(speed, 1);
		MotorPort.B.controlMotor((speed - 4), 1);
		Tacho = MotorPort.A.getTachoCount();

	}

}
