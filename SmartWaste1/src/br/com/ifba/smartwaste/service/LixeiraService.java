/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.dao.LixeiraDAO;
import br.com.ifba.smartwaste.model.Lixeira;
import java.util.ArrayList;

/**
 *
 * @author Heber
 */
public class LixeiraService implements ILixeiraService {
    
    private final LixeiraDAO lixeiraDAO = new LixeiraDAO();
    private Lixeira lixeira;
    
    @Override
    public boolean cadastrarLixeira(float tamanho, String tipo, int pontoId) {
        Lixeira l = new Lixeira(tamanho, tipo, pontoId);
        return lixeiraDAO.criarLixeira(l);
    }

    @Override
    public boolean cadastrarLixeira(Lixeira lixeira) {
        return lixeiraDAO.criarLixeira(lixeira);
    }
    
    @Override
    public boolean apagarLixeira(int id) {
        this.lixeira = lixeiraDAO.pesquisarLixo(id);
        return lixeiraDAO.deletarLixeira(lixeira);
    }

    @Override
    public boolean atualizarLixeira(int id, float tamanho, String tipo, int pontoId) {
        Lixeira l = new Lixeira(tamanho, tipo, pontoId);
        return lixeiraDAO.atualizarLixeira(l);
    }

    @Override
    public boolean atualizarLixeira(Lixeira l) {
        return lixeiraDAO.atualizarLixeira(l);
    }

    @Override
    public Lixeira findByIdLixeira(int idLixeira) {
        return lixeiraDAO.pesquisarLixo(idLixeira);
    }
    
    
    @Override
    public ArrayList<Lixeira> findByIdPonto(int idPonto){
        return lixeiraDAO.findByIdPonto(idPonto);
    }
    
}
