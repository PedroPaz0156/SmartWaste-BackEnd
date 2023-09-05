/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.sensor.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author PedroPaz
 */
@Entity
@Table(name = "Sensor")
public class Sensor extends PersistenceEntity{
   
    private float distanciaAtual;
    private int id;

    public Sensor(float distanciaAtual, int id) {
        this.distanciaAtual = distanciaAtual;
    }
    
    public float getDistanciaAtual() {
        return distanciaAtual;
    }

    //tem um erro aqui ó
    //public int getId() {
    //    return id;
    //}

    public void setId(int id) {
        this.id = id;
    }

    
    public void setDistanciaAtual(float distanciaAtual) {
        this.distanciaAtual = distanciaAtual;
    }
    
    
    
    
    
}
