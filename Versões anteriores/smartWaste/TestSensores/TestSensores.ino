#include <HCSR04.h>
/*#include <Ultrasonic.h>
  #define pino_trigger_1 2
  #define pino_echo_1 3
  
  #define pino_trigger_2 4
  #define pino_echo_2 5
  
  Ultrasonic ultrasonic1(pino_trigger_1, pino_echo_1);
  Ultrasonic ultrasonic2(pino_trigger_2, pino_echo_2);
 */

byte triggerPin1 = 2;
byte echoPin1 = 3;
byte triggerPin2 = 4;
byte echoPin2 = 5;

void setup() {
  // put your setup code here, to run once:
  
  Serial.begin(9600);
  
  HCSR04.begin(triggerPin1, echoPin1);
}

void loop() {
  // put your main code here, to run repeatedly:
  /*
    float cmMsec1;
    long microsec1 = ultrasonic1.Timing();
    cmMsec1 = ultrasonic1.Ranging(1);
    float cmMsec2;
    long microsec2 = ultrasonic2.Timing();
    cmMsec2 = ultrasonic2.Ranging(1);
    Serial.print("lendo valores... /n");
    Serial.print("/n sensor 1:");
    Serial.print(cmMsec1);
    Serial.print("/n sensor 2:");
    Serial.print(cmMsec2);
   */
  
  double* dist = HCSR04.measureDistanceCm();
  Serial.print("/n");
  Serial.print('%f', dist);
}
