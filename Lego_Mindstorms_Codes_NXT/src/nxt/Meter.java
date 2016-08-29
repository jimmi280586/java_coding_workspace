package nxt;

public class Meter
{

   public static void main(String[] args) throws InterruptedException
   {



      int Tacho1 = 0;

      while (Tacho1 < 2050)
      {
         MotorPort.A.controlMotor(100,1);
         MotorPort.B.controlMotor(96,1);

        Tacho1 = MotorPort.A.getTachoCount();
      }

      int Tacho2 = 0;

      while (Tacho2 < 6440)
      {
         MotorPort.A.controlMotor(100,1);
         MotorPort.B.controlMotor(85,1);

        Tacho2 = MotorPort.A.getTachoCount();
      }
   }

}
