#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

const char* ssid = "SUA_REDE_WIFI"; // SSID da sua rede Wi-Fi
const char* password = "SUA_SENHA_WIFI"; // Senha da sua rede Wi-Fi

const char* serverAddress = "SEU_SERVIDOR"; // Endereço do servidor onde está o banco de dados
const int serverPort = 80; // Porta do servidor (geralmente 80 para HTTP)

const int trigPin = 9; // Pino TRIG do sensor ultrassônico
const int echoPin = 10; // Pino ECHO do sensor ultrassônico

void setup() {
  Serial.begin(115200);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Conectando ao WiFi...");
  }

  Serial.println("Conectado ao WiFi");

}

void loop() {
  long duration, distance;
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  
  duration = pulseIn(echoPin, HIGH);
  distance = (duration / 2) / 29.1;

  Serial.print("Distância: ");
  Serial.println(distance);

  if (WiFi.status() == WL_CONNECTED) {
    HTTPClient http;
    String data = "distancia=" + String(distance); // Dados a serem enviados ao servidor

    http.begin("http://" + String(serverAddress) + ":" + String(serverPort) + "/enviar_dados"); // Substitua "enviar_dados" pelo endpoint do seu servidor
    http.addHeader("Content-Type", "application/x-www-form-urlencoded");
    
    int httpResponseCode = http.POST(data);

    if (httpResponseCode > 0) {
      Serial.print("Resposta do servidor: ");
      Serial.println(httpResponseCode);
    } else {
      Serial.print("Erro ao se conectar ao servidor. Código de erro: ");
      Serial.println(httpResponseCode);
    }

    http.end();
  }

  delay(5000); // Espera 5 segundos antes de ler novamente
}
