/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.model;

/**
 *
 * @author Pedro Augusto
 */
public class Sensor{
    
    private int idSensor;
    private int idLixeira;    
    private int distanciaAtual;

    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
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
