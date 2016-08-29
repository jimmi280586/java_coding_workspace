package nxt;

public class Touch
{

   public static void main(String[] args) throws InterruptedException
   {

      TouchSensor a = new TouchSensor(SensorPort.S3);

      boolean stop = false;

      while (!stop)
      {
         MotorPort.A.controlMotor(100, 1);
         MotorPort.B.controlMotor(96, 1);

         if (a.isPressed())
         {
            stop = true;

         }
      }

      int Tacho = 0;
      MotorPort.A.controlMotor(100, 3);
      MotorPort.B.controlMotor(96, 3);
      Thread.sleep(1000);

      MotorPort.A.resetTachoCount();

      while (Tacho > -513)
      {

         MotorPort.A.controlMotor(100, 2);
         MotorPort.B.controlMotor(96, 2);
         Tacho = MotorPort.A.getTachoCount();
         LCD.drawInt(Tacho, 0, 0);
      }
      MotorPort.A.controlMotor(100, 3);
      MotorPort.B.controlMotor(96, 3);

      MotorPort.A.resetTachoCount();
      int tacho = 0;

      while (tacho < 231)
      MotorPort.A.controlMotor(100, 3);
      MotorPort.B.controlMotor(96, 3);
      tacho = MotorPort.A.getTachoCount();
      LCD.drawInt(tacho, 0, 0);

   }
}
