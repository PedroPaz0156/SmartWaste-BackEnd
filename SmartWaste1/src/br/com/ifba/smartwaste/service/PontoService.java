/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.dao.PontoDAO;
import br.com.ifba.smartwaste.model.Lixeira;
import br.com.ifba.smartwaste.model.Ponto;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class PontoService implements IPontoService{

    private final PontoDAO pontoDAO = new PontoDAO();
    private Ponto ponto;
    
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
    public void apagarPonto(String endereco) {
        this.ponto = pontoDAO.findByEndereco(endereco);
        lixeiraService.apagarLixeira(this.ponto.getMetal().getIdLixeira());
        lixeiraService.apagarLixeira(this.ponto.getOrganico().getIdLixeira());
        lixeiraService.apagarLixeira(this.ponto.getPapel().getIdLixeira());
        lixeiraService.apagarLixeira(this.ponto.getPlastico().getIdLixeira());
        lixeiraService.apagarLixeira(this.ponto.getVidro().getIdLixeira());
        pontoDAO.deletarPonto(ponto);
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
    
}
