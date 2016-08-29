package ev3;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;



public class Meter
{

   public static void main(String[] args) throws InterruptedException
   {
     //how to get motor to run
      
      // forward = backward
      Motor.A.setSpeed(720);// 2 RPM
      Motor.B.setSpeed(720);
      Motor.A.backward();
      Motor.B.backward();
      Thread.sleep (5000);
      //this code stops the motor
      Motor.A.stop();
      Motor.B.stop();
      
      // this rotates the motor to position 360 degree and the rotates 
      //720 the other way
      //Motor.A.rotateTo( 360);
      //Motor.A.rotate(-720,true);
     
int Tacho1 = 0;
int Tacho2 = 0;      
Motor.A.resetTachoCount();
Motor.B.resetTachoCount();
Tacho1 = Motor.A.getTachoCount();
Tacho2 = Motor.A.getTachoCount();

LCD.drawInt(Tacho1 + Tacho2, 0, 4);
Delay.msDelay(5000);   


while (Tacho1 < 2050)
      {
         Motor.A.setSpeed(720);// 2 RPM
         Motor.B.setSpeed(720);
         Motor.A.backward();
         Motor.B.backward();
         
        Tacho1 = Motor.A.getTachoCount();
      
      }
           
      while (Tacho2 < 6440)
      {
         Motor.A.setSpeed(720);// 2 RPM
         Motor.B.setSpeed(600);
         Motor.A.backward();
         Motor.B.backward();
         
        Tacho2 = Motor.A.getTachoCount();
   }
   }
}
