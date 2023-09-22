#include <Servo.h>

#define echoPin 2
#define triggPin 3
#define servoPin 4

long duracao;
int distancia;
int pos;
Servo motor;

void setup() {
    Serial.begin(9600);  // Corrigido para a velocidade padrão de 9600
    pinMode(triggPin, OUTPUT);
    pinMode(echoPin, INPUT);
    motor.attach(servoPin);
    motor.write(0);
}

void loop() {
    triggerPulse();
    duracao = pulseIn(echoPin, HIGH);
    distancia = calculateDistance(duracao);

    if (distancia <= 20) {
        abrirCancela();
        delay(15000);
        fecharCancela();
        delay(5000);
    }
}

void triggerPulse() {
    digitalWrite(triggPin, LOW);
    delayMicroseconds(2);
    digitalWrite(triggPin, HIGH);
    delayMicroseconds(10);
    digitalWrite(triggPin, LOW);
}

int calculateDistance(long duration) {
    return duration * 0.034 / 2;
}

void abrirCancela() {
    Serial.println("Abre cancela.");
    moveMotor(90, 5, 125);
}

void fecharCancela() {
    Serial.println("Fecha cancela.");
    moveMotor(0, -5, 125);
}

void moveMotor(int targetPos, int stepSize, int delayTime) {
    for (pos = motor.read(); pos != targetPos; pos += stepSize) {
        motor.write(pos);
        delay(delayTime);
    }
    motor.write(targetPos);  // Certifique-se de definir a posição final explicitamente
}
