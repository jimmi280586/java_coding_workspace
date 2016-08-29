package nxt;
import java.awt.Button;


public class Follow
{

   public static void main(String[] args)
   {

      {
         String left = "Turn left ";
         String right= "Turn right";
         LightSensor light = new LightSensor(SensorPort.S3);
         int blackWhiteThreshold = 45;



         // Use the light sensor as a reflection sensor
         light.setFloodlight(true);
         LCD.drawString("Light %: ", 0, 0);

         // Show light percent until LEFT is pressed
         LCD.drawString("Press LEFT", 0, 2);
         LCD.drawString("to start", 0, 3);
         while (! Button.LEFT.isDown())
         { LCD.drawInt(light.readValue(), 3, 9, 0);
         }


   }

}
}