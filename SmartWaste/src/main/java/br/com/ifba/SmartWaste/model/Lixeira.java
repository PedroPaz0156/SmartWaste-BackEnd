/*package br.com.ifba.SmartWaste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lixeira")
public class Lixeira {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLixeira;

    private float medida;
    private float ocupacao;
    private float tamanho;
    private String tipo;
    private boolean existe;
    
    public Lixeira(){
    
    }

    public Lixeira(float tamanho, String tipo) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        existe = false;
    }
    
    public float getMedida() {
        return medida;
    }
    
    public void setMedida(float medida) {
        this.medida = medida;
    }
    
    public boolean isReal() {
        return existe;
    }
    
    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public float getTamanho() {
        return tamanho;
    }
    
    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }
    
    public float getOcupacao() {
        return ocupacao;
    }
    
    public void setOcupacao(float ocupacao) {
        this.ocupacao = ocupacao;
    }
}*/