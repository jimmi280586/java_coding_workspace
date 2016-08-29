package nxt.methods;

public class MotorTest
{

   // moves the arm for 2 seconds
   public static void moveArm() throws InterruptedException
   {
      LCD.drawString("moving the arm", 0, 0);
      MotorPort.C.controlMotor(100,1);
      Thread.sleep(2000);
      MotorPort.C.controlMotor(100,3);
   }

   public static void runleft() throws InterruptedException
   {
      LCD.drawString("running left motor", 0, 0);
      MotorPort.A.controlMotor(100, 1);
      Thread.sleep(2000);
      MotorPort.A.controlMotor(100,3);
   }

   public static void runright() throws InterruptedException
   {
      LCD.drawString("running right motor", 0, 0);
      MotorPort.B.controlMotor(100, 1);
      Thread.sleep(2000);
      MotorPort.B.controlMotor(100,3);
   }

   public static void testmicsensor() throws InterruptedException
   {
   SoundSensor mic = new SoundSensor(SensorPort.S2);

   int count = 0;
   while(count < 5)
   {
      int decibel = mic.readValue();

      LCD.drawString("Decibels: " + decibel, 0, 0);

      Thread.sleep(2000);
      count++;
   }
   }

   public static void light() throws InterruptedException
   {

      LightSensor light = new LightSensor(SensorPort.S1);

      int count = 0;
      while (count < 5)
      {
         int brightness = light.getLightValue();

         LCD.drawString("running light sensor", 0, 0);
         LCD.clearDisplay();
         LCD.drawString("Brightness: " + brightness, 0, 0);
          Thread.sleep(1000);

          count++;
      }

   }

   public static void ultra() throws InterruptedException
   {
      UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S4);

      int count = 0;

      while (count < 5)
      {
         int distance = ultra.getDistance();

         LCD.drawString("distance: " + distance, 0, 0);

         Thread.sleep(1000);

         count++;
      }

   }

   public static void touch() throws InterruptedException
   {
      // Make a new touch sensor object
      TouchSensor touch = new TouchSensor(SensorPort.S3);
      // Declare and set a boolean variable touched
      boolean touched = false;
      // Start a loop
      // Watch for ten seconds
      int count = 0;
      while(count < 20)
      {
      // Draw status to the screen
      LCD.clearDisplay();
      LCD.drawString("Touched: " + touched, 0, 0);
      // When the sensor is pressed, switch touched to true
      if(touch.isPressed())
      {
      touched = true;
      }
      // Wait a half second
      Thread.sleep(500);
      // Increment counter
      count++;

   }
}
}
