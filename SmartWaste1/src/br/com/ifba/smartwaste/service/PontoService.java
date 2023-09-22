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
    private Ponto ponto;
    private TelaListaPonto2 telaListaPonto;
    private final LixeiraService lixeiraService = new LixeiraService();
    
    @Override
    public void cadastrarPonto(Ponto ponto) {
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
    public ArrayList <Ponto> findAll() {
        
        ArrayList <Ponto> listaPontos = pontoDAO.findAll();
        ArrayList<Lixeira> listaLixo;
        for (int i = 0; i < listaPontos.size(); i++){
            listaLixo = lixeiraService.findByIdPonto(listaPontos.get(i).getIdPonto());
            listaPontos.get(i).setMetal(listaLixo.get(0));
            listaPontos.get(i).setOrganico(listaLixo.get(1));
            listaPontos.get(i).setPapel(listaLixo.get(2));
            listaPontos.get(i).setPlastico(listaLixo.get(3));
            listaPontos.get(i).setVidro(listaLixo.get(4));
        }
        return listaPontos;
    }
    
    @Override
    public void gerarLista(ArrayList <Ponto> lista){
        telaListaPonto.limpaTabela();
        for(int i=0;i<lista.size();i++){
            telaListaPonto.adicionaItem
                           (lista.get(i).getIdPonto(),
                           lista.get(i).getEndereco(),
                           lista.get(i).getOcupacaoMedia());
        }
    }
    
    @Override
    public void listarPonto(){
        gerarLista(findAll());
    }
    
}
