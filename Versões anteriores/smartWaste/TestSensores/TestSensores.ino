// Inclua a biblioteca Ultrasonic
#include <Ultrasonic.h>

// Defina os pinos para o Trigger e o Echo do sensor
#define TRIGGER_PIN 2
#define ECHO_PIN 3

// Crie um objeto Ultrasonic
Ultrasonic ultrasonic(TRIGGER_PIN, ECHO_PIN);

void setup() {
  Serial.begin(9600);
}

void loop() {
  // Chame a função read() para medir a distância
  float distancia = ultrasonic.read();

  // Exiba a distância medida no Monitor Serial
  Serial.print("Distancia: ");
  Serial.print(distancia);
  Serial.println(" cm");

  // Aguarde um curto período de tempo antes de realizar a próxima medição
  delay(1000);
}