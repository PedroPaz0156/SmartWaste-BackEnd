/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.model;

import java.util.Date;


/**
 *
 * @author Pedro Augusto
 */
public class Ponto{
    
    private int idPonto;
    private String endereco;
    private Date ultimaColeta;
    private float ocupacaoMedia;
    private Lixeira metal;
    private Lixeira organico;
    private Lixeira papel;
    private Lixeira plastico;
    private Lixeira vidro;

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
    
    public void calcOcupacaoMedia() {
        float total =0;
        int numero = 0;
        Lixeira lixo = new Lixeira();
        lixo.setTipo("metal");
        if (!this.getMetal().equals(lixo)){
            numero +=this.getMetal().getOcupacao();
            total++;
        }
        lixo.setTipo("organico");
        if (!this.getOrganico().equals(lixo)){
            numero +=this.getOrganico().getOcupacao();
            total++;
        }
        lixo.setTipo("papel");
        if (!this.getPapel().equals(lixo)){
            numero +=this.getPapel().getOcupacao();
            total++;
        }
        lixo.setTipo("plastico");
        if (!this.getPlastico().equals(lixo)){
            numero +=this.getPlastico().getOcupacao();
            total++;
        }
        lixo.setTipo("vidro");
        if (!this.getVidro().equals(lixo)){
            numero +=this.getVidro().getOcupacao();
            total++;
        }
        this.ocupacaoMedia = (total/numero);
    }

    public Lixeira getMetal() {
        return metal;
    }

    public void setMetal(Lixeira metal) {
        this.metal = metal;
    }

    public Lixeira getOrganico() {
        return organico;
    }

    public void setOrganico(Lixeira organico) {
        this.organico = organico;
    }

    public Lixeira getPapel() {
        return papel;
    }

    public void setPapel(Lixeira papel) {
        this.papel = papel;
    }

    public Lixeira getPlastico() {
        return plastico;
    }

    public void setPlastico(Lixeira plastico) {
        this.plastico = plastico;
    }

    public Lixeira getVidro() {
        return vidro;
    }

    public void setVidro(Lixeira vidro) {
        this.vidro = vidro;
    }

    public Ponto(int idPonto, String endereco, Date ultimaColeta, float ocupacaoMedia, float tamanhoMet, int idSensorMet, float tamanhoOrg, int idSensorOrg, float tamanhoPap, int idSensorPap, float tamanhoPla, int idSensorPla, float tamanhoVid, int idSensorVid) {
        this.endereco = endereco;
        this.ultimaColeta = ultimaColeta;
        this.ocupacaoMedia = ocupacaoMedia;
        this.metal = new Lixeira(tamanhoMet, "metal", idSensorMet, idPonto);
        this.organico = new Lixeira(tamanhoOrg, "organico", idSensorOrg, idPonto);
        this.papel = new Lixeira(tamanhoPap, "papel", idSensorPap, idPonto);
        this.plastico = new Lixeira(tamanhoPla, "plastico", idSensorPla, idPonto);
        this.vidro = new Lixeira(tamanhoVid, "vidro", idSensorVid, idPonto);
    }
    
    public Ponto(){
        this.metal.setTipo("metal");
        this.organico.setTipo("organico");
        this.papel.setTipo("papel");
        this.plastico.setTipo("plastico");
        this.vidro.setTipo("vidro");
    }
    
    
}