package br.com.ifba.SmartWaste.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sensor")
public class Sensor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idsensor")
    private int idsensor;

    private int idLixeira;
    @Column(name = "distanciaAtual")
    private int distanciaAtual;

    public int getIdSensor() {
        return idsensor;
    }

    public void setIdSensor(int idSensor) {
        this.idsensor = idSensor;
    }

    public int getIdLixeira() {
        return idLixeira;
    }

    public void setIdLixeira(int idLixeira) {
        this.idLixeira = idLixeira;
    }

    public int getDistanciaAtual() {
        return distanciaAtual;
    }

    public void setDistanciaAtual(int distanciaAtual) {
        this.distanciaAtual = distanciaAtual;
    }

}
