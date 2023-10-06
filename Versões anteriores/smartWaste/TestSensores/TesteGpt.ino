#include <SPI.h>
#include <Ethernet.h>
#include <ArduinoJson.h>

byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };  // Substitua isso com o seu endereço MAC
IPAddress ip(192, 168, 0, 177);  // Substitua isso com o endereço IP desejado
EthernetServer server(80);

const int trigPin = 2;
const int echoPin = 3;

void setup() {
  Ethernet.begin(mac, ip);
  server.begin();

  Serial.begin(9600);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
}

void loop() {
  EthernetClient client = server.available();

  if (client) {
    while (client.connected()) {
      long duration, distance;
      digitalWrite(trigPin, LOW);
      delayMicroseconds(2);
      digitalWrite(trigPin, HIGH);
      delayMicroseconds(10);
      digitalWrite(trigPin, LOW);

      duration = pulseIn(echoPin, HIGH);
      distance = (duration / 2) / 29.1;

      StaticJsonDocument<200> doc;
      doc["distance"] = distance;

      String json;
      serializeJson(doc, json);

      client.println("HTTP/1.1 200 OK");
      client.println("Content-Type: application/json");
      client.println("Connection: close");
      client.println();
      client.println(json);

      delay(1000);  // Intervalo de leitura do sensor
      break;
    }
    client.stop();
  }
}
