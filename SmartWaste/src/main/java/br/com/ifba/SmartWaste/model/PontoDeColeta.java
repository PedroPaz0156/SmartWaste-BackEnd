/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.SmartWaste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author Pedro Augusto
 */
@Entity
@Table(name = "Ponto_de_coleta")
public class PontoDeColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPonto;
    
    private String endereco;
    private Date ultimaColeta;
    private float ocupacaoMedia;
    
    @OneToMany
    @PrimaryKeyJoinColumn
    public Lixeira lixeiras;

    public int getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(int idPonto) {
        this.idPonto = idPonto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getUltimaColeta() {
        return ultimaColeta;
    }

    public void setUltimaColeta(Date ultimaColeta) {
        this.ultimaColeta = ultimaColeta;
    }

    public float getOcupacaoMedia() {
        return ocupacaoMedia;
    }

    public void setOcupacaoMedia(float ocupacaoMedia) {
        this.ocupacaoMedia = ocupacaoMedia;
    }

    public Lixeira getLixeiras() {
        return lixeiras;
    }

    public void setLixeiras(Lixeira lixeiras) {
        this.lixeiras = lixeiras;
    }
    
    
}
