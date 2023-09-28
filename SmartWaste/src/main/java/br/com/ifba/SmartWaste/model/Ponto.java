package br.com.ifba.SmartWaste.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "ponto")
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPonto;

    private String endereco;
    private Date ultimaColeta;
    private float ocupacaoMedia;
    /*private Lixeira metal;
    private Lixeira organico;
    private Lixeira papel;
    private Lixeira plastico;
    private Lixeira vidro; */
    
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
       /*if (!this.getMetal().isReal()){
            numero +=this.getMetal().getOcupacao();
            total++;
        }
        if (!this.getOrganico().isReal()){
            numero +=this.getOrganico().getOcupacao();
            total++;
        }
        if (!this.getPapel().isReal()){
            numero +=this.getPapel().getOcupacao();
            total++;
        }
        if (!this.getPlastico().isReal()){
            numero +=this.getPlastico().getOcupacao();
            total++;
        }
        if (!this.getVidro().isReal()){
            numero +=this.getVidro().getOcupacao();
            total++;
        } */
        this.ocupacaoMedia = (total/numero);
    }

    /*public Lixeira getMetal() {
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
    }*/

    public Ponto(Ponto idPonto, String endereco, Date ultimaColeta, float ocupacaoMedia, float tamanhoMet, float tamanhoOrg, float tamanhoPap, float tamanhoPla, float tamanhoVid) {
        this.endereco = endereco;
        this.ultimaColeta = ultimaColeta;
        this.ocupacaoMedia = ocupacaoMedia;
        /*this.metal = new Lixeira(tamanhoMet, "metal");
        this.organico = new Lixeira(tamanhoOrg, "organico");
        this.papel = new Lixeira(tamanhoPap, "papel");
        this.plastico = new Lixeira(tamanhoPla, "plastico");
        this.vidro = new Lixeira(tamanhoVid, "vidro");*/
    }
    
    public Ponto(){
        /*this.metal = new Lixeira();
        this.organico = new Lixeira();
        this.papel = new Lixeira();
        this.plastico = new Lixeira();
        this.vidro = new Lixeira();
        this.metal.setTipo("metal");
        this.organico.setTipo("organico");
        this.papel.setTipo("papel");
        this.plastico.setTipo("plastico");
        this.vidro.setTipo("vidro");*/
    }
}
