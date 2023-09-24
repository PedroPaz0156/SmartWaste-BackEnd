/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.dao.PontoDAO;
import br.com.ifba.smartwaste.model.Lixeira;
import br.com.ifba.smartwaste.model.Ponto;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pc
 */
public class PontoService implements IPontoService{

    private final PontoDAO pontoDAO = new PontoDAO();
    private final LixeiraService lixeiraService = new LixeiraService();
    
    @Override
    public boolean cadastrarPontoELixo(String endereco, int tamanhoMet, int tamanhoOrg, int tamanhoPap, int tamanhoPla, int tamanhoVid){
        Date ultimaColeta = new Date();
        Ponto p = new Ponto(0, endereco, ultimaColeta, 0, tamanhoMet, tamanhoOrg, tamanhoPap, tamanhoPla, tamanhoVid);
        boolean r = pontoDAO.criarPonto(p);
        lixeiraService.cadastrarLixeira(p.getMetal());
        lixeiraService.cadastrarLixeira(p.getOrganico());
        lixeiraService.cadastrarLixeira(p.getPapel());
        lixeiraService.cadastrarLixeira(p.getPlastico());
        lixeiraService.cadastrarLixeira(p.getVidro());
        return r;
    }
    
    @Override
    public boolean cadastrarPontoVazio(String endereco) {
        Ponto p = new Ponto();
        p.setEndereco(endereco);
        return pontoDAO.criarPonto(p);
    }
    
    
    @Override
    public boolean apagarPonto(int id){
        Ponto p = pontoDAO.procurarPonto(id);
        lixeiraService.apagarLixeira(p.getMetal().getIdLixeira());
        lixeiraService.apagarLixeira(p.getOrganico().getIdLixeira());
        lixeiraService.apagarLixeira(p.getPapel().getIdLixeira());
        lixeiraService.apagarLixeira(p.getPlastico().getIdLixeira());
        lixeiraService.apagarLixeira(p.getVidro().getIdLixeira());
        return pontoDAO.deletarPonto(p);
    }

    @Override
    public boolean atualizarPonto(int id, String endereco) {
        Ponto p = findById(id);
        p.setEndereco(endereco);
        return pontoDAO.editarPonto(p);
    }
    
    @Override
    public boolean atualizarPontoELixo(int id, String endereco, int tamanhoMet, int tamanhoOrg, int tamanhoPap, int tamanhoPla, int tamanhoVid) {
        Ponto p = findById(id);
        p.setEndereco(endereco);
        p.getMetal().setTamanho(tamanhoMet);
        p.getOrganico().setTamanho(tamanhoOrg);
        p.getPapel().setTamanho(tamanhoPap);
        p.getPlastico().setTamanho(tamanhoPla);
        p.getVidro().setTamanho(tamanhoVid);
            
        boolean r = pontoDAO.editarPonto(p);
        lixeiraService.atualizarLixeira(p.getMetal());
        lixeiraService.atualizarLixeira(p.getOrganico());
        lixeiraService.atualizarLixeira(p.getPapel());
        lixeiraService.atualizarLixeira(p.getPlastico());
        lixeiraService.atualizarLixeira(p.getVidro());
        return r;
    }

    @Override
    public Ponto findByEndereco(String endereco) {
        if(!endereco.isEmpty()) {
            Ponto p = pontoDAO.findByEndereco(endereco);
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
    
}
