/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.model;


/**
 *
 * @author Pedro Augusto
 */
public class Lixeira{
    
    private int idLixeira;
    private float medida;
    private float ocupacao;
    private float tamanho;
    private String tipo;
    private int idSensor;
    private int idPonto;

    public int getIdLixeira() {
        return idLixeira;
    }

    public void setIdLixeira(int idLixeira) {
        this.idLixeira = idLixeira;
    }

    public float getMedida() {
        return medida;
    }

    public void setMedida(float medida) {
        this.medida = medida;
    }

    public float getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(float ocupacao) {
        this.ocupacao = ocupacao;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }

    public int getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(int idPonto) {
        this.idPonto = idPonto;
    }
    
    //retorna um valor igual a porcentagem de espaço ocupado
    public float calcOcupacao(float tamanho, float medida) {
        return 100*(tamanho-medida)/tamanho;
    }

    public Lixeira(float tamanho, String tipo, int idSensor, int idPonto) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.idSensor = idSensor;
        this.idPonto = idPonto;
    }
    
    public Lixeira(){
    
    }
    
}
