/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 *
 * @author Pedro Paz
 */
public class Lixeira extends PersistenceEntity{
    
    private String tipo;
    private float ocupacao;
    private float medida;
    private float tamanho;
    private Sensor sensor;

    public Lixeira(String tipo, float medida, float tamanho) {
        this.tipo = tipo;
        this.medida = medida;
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(float ocupacao) {
        this.ocupacao = ocupacao;
    }

    public float getMedida() {
        return medida;
    }

    public void setMedida(float medida) {
        this.medida = medida;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
    
    public float calcOcupacao(float tamanho, float medida) {
        
        return ocupacao;
    }
    
}
