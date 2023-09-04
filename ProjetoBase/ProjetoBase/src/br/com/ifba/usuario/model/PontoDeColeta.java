/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
/**
 *
 * @author Pedro Augusto
 */
@Entity
@Table(name = "Ponto de Coleta")
public class PontoDeColeta extends PersistenceEntity{
    
    private String endereco;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ultimaColeta;
    private float ocupacaoMedia;
    public Lixeira lixeiras[5];

    public PontoDeColeta(String endereco, Date ultimaColeta, float ocupacaoMedia) {
        this.endereco = endereco;
        this.ultimaColeta = ultimaColeta;
        this.ocupacaoMedia = ocupacaoMedia;
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
    
    
}
