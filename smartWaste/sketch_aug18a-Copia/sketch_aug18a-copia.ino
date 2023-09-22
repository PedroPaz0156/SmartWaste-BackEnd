#define echoPin1 2
#define triggPin1 3
#define echoPin2 4
#define triggPin2 5

long duracao1;
long duracao2;
int distancia1;
int distancia2;

void setup() {
    Serial.begin(9600);  // Corrigido para a velocidade padrão de 9600
    pinMode(triggPin1, OUTPUT);
    pinMode(echoPin1, INPUT);
    pinMode(triggPin2, OUTPUT);
    pinMode(echoPin2, INPUT);
}

void loop() {
    triggerPulse();
    duracao1 = pulseIn(echoPin1, HIGH);
    duracao2 = pulseIn(echoPin2, HIGH);
    distancia1 = calculateDistance(duracao1);
    distancia2 = calculateDistance(duracao2);
}

void triggerPulse() {
    digitalWrite(triggPin1, LOW);
    digitalWrite(triggPin2, LOW);
    delayMicroseconds(2);
    digitalWrite(triggPin1, HIGH);
    digitalWrite(triggPin2, HIGH);
    delayMicroseconds(10);
    digitalWrite(triggPin1, LOW);
    digitalWrite(triggPin2, LOW);
}

int calculateDistance(long duration) {
    return duration * 0.034 / 2;
}

void exibirDistancias(){
    Serial.print("distancia 1: ");
    Serial.println(distancia1);
    Serial.print("distancia 2: ");
    Serial.println(distancia2);
}
