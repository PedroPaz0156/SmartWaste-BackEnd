/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.dao.PontoDAO;
import br.com.ifba.smartwaste.model.Lixeira;
import br.com.ifba.smartwaste.model.Ponto;
import br.com.ifba.smartwaste.view.TelaListaPonto2;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class PontoService implements IPontoService{

    private final PontoDAO pontoDAO = new PontoDAO();
    private Ponto ponto = new Ponto();
    private final LixeiraService lixeiraService = new LixeiraService();
    
    @Override
    public void cadastrarPonto(Ponto ponto) {
        ArrayList <Ponto> p = pontoDAO.findAll();
        int i = 0;
        boolean existe = true;        
        while(existe){
            i++;
            existe = false;
            for (int j = 0; j < p.size(); j++){
                if (i == p.get(j).getIdPonto()){
                   existe = true;
                }
            }
        }
        ponto.setIdPonto(i);
        pontoDAO.criarPonto(ponto);
        lixeiraService.cadastrarLixeira(this.ponto.getMetal());
        lixeiraService.cadastrarLixeira(this.ponto.getOrganico());
        lixeiraService.cadastrarLixeira(this.ponto.getPapel());
        lixeiraService.cadastrarLixeira(this.ponto.getPlastico());
        lixeiraService.cadastrarLixeira(this.ponto.getVidro());
    }

    @Override
    public void apagarPontoByEndereco(String endereco) {
        this.ponto = pontoDAO.findByEndereco(endereco);
        apagarPonto(ponto);
    }
    
    @Override
    public void apagarPontoById(int id){
        this.ponto = pontoDAO.procurarPonto(id);
        apagarPonto(ponto);
    }
    
    @Override
    public void apagarPonto(Ponto p){
        lixeiraService.apagarLixeira(p.getMetal().getIdLixeira());
        lixeiraService.apagarLixeira(p.getOrganico().getIdLixeira());
        lixeiraService.apagarLixeira(p.getPapel().getIdLixeira());
        lixeiraService.apagarLixeira(p.getPlastico().getIdLixeira());
        lixeiraService.apagarLixeira(p.getVidro().getIdLixeira());
        pontoDAO.deletarPonto(p);
    }

    @Override
    public void atualizarPonto(Ponto ponto) {
        pontoDAO.editarPonto(ponto);
    }

    @Override
    public Ponto findByEndereco(String endereco) {
        if(!endereco.isEmpty()) {
            Ponto p = pontoDAO.findByEndereco(endereco);
            ArrayList<Lixeira> lista;
            lista = lixeiraService.findByIdPonto(p.getIdPonto());
            p.setMetal(lista.get(0));
            p.setOrganico(lista.get(1));
            p.setPapel(lista.get(2));
            p.setPlastico(lista.get(3));
            p.setVidro(lista.get(4));
            return p;
        }else{
            return null;
        }
    }
    
    @Override
    public Ponto findById(int id) {
        if(id!=0) {
            Ponto p = pontoDAO.procurarPonto(id);
            ArrayList<Lixeira> lista;
            lista = lixeiraService.findByIdPonto(p.getIdPonto());
            for(int i = 0; i < lista.size(); i++){
                switch (lista.get(i).getTipo()){
                    case "metal":
                        p.setMetal(lista.get(i));
                    case "organico":
                        p.setOrganico(lista.get(i));
                    case "papel":
                        p.setPapel(lista.get(i));
                    case "plastico":
                        p.setPlastico(lista.get(i));
                    case "vidro":
                        p.setVidro(lista.get(i));
                }
            }
            return p;
        }else{
            return null;
        }
    }
    
    @Override
    public ArrayList <Ponto> findAll() {
        
        ArrayList <Ponto> listaPontos = pontoDAO.findAll();
        ArrayList<Lixeira> listaLixo;
        
        for (int i = 0; i < listaPontos.size(); i++){
            listaLixo = lixeiraService.findByIdPonto(listaPontos.get(i).getIdPonto());
            for(int j = 0; j < listaLixo.size(); j++){
                switch (listaLixo.get(j).getTipo()){
                    case "metal":
                        listaPontos.get(i).setMetal(listaLixo.get(j));
                    case "organico":
                        listaPontos.get(i).setOrganico(listaLixo.get(j));
                    case "papel":
                        listaPontos.get(i).setPapel(listaLixo.get(j));
                    case "plastico":
                        listaPontos.get(i).setPlastico(listaLixo.get(j));
                    case "vidro":
                        listaPontos.get(i).setVidro(listaLixo.get(j));
                }
            }
        }
        return listaPontos;
    }
    
    @Override
    public void gerarLista(ArrayList <Ponto> lista, TelaListaPonto2 tlp){
        tlp.limpaTabela();
        for(int i=0;i<lista.size();i++){
            tlp.adicionaItem
                           (lista.get(i).getIdPonto(),
                           lista.get(i).getEndereco(),
                           lista.get(i).getOcupacaoMedia());
        }
    }
    
    @Override
    public void listarPonto(TelaListaPonto2 tlp){
        gerarLista(findAll(), tlp);
    }
    
}
