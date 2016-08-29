package nxt;

public class HelloWorld
{

   public static void main(String[] args) throws InterruptedException
   {
      MotorPort.A.controlMotor(80, 1);
      MotorPort.B.controlMotor(81, 1);
      Thread.sleep(1000);
      MotorPort.A.controlMotor(70, 3);
      MotorPort.B.controlMotor(80, 1);
      Thread.sleep(850);

      MotorPort.A.controlMotor(80, 1);
      MotorPort.B.controlMotor(81, 1);
      Thread.sleep(1000);
      MotorPort.A.controlMotor(70, 3);
      MotorPort.B.controlMotor(80, 1);
      Thread.sleep(800);

      MotorPort.A.controlMotor(80, 1);
      MotorPort.B.controlMotor(81, 1);
      Thread.sleep(1000);
      MotorPort.A.controlMotor(70, 3);
      MotorPort.B.controlMotor(80, 1);
      Thread.sleep(850);

      MotorPort.A.controlMotor(80, 1);
      MotorPort.B.controlMotor(81, 1);
      Thread.sleep(1000);

   }

}
