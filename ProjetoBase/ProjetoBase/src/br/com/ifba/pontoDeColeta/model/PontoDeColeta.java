/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pontoDeColeta.model;

import br.com.ifba.lixeira.model.Lixeira;
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
    private Lixeira lixeira[];

    public PontoDeColeta(String endereco, Date ultimaColeta, float ocupacaoMedia, float medida0, float medida1, float medida2, float medida3, float medida4, float tamanho) {
        this.endereco = endereco;
        this.ultimaColeta = ultimaColeta;
        this.ocupacaoMedia = ocupacaoMedia;
        this.lixeira[0] = new Lixeira("organico", medida0, tamanho);
        this.lixeira[1] = new Lixeira("metal", medida1, tamanho);
        this.lixeira[2] = new Lixeira("papel", medida2, tamanho);
        this.lixeira[3] = new Lixeira("plastico", medida3, tamanho);
        this.lixeira[4] = new Lixeira("vidro", medida4, tamanho);
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
