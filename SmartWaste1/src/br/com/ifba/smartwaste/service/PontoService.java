/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.dao.PontoDAO;
import br.com.ifba.smartwaste.model.Lixeira;
import br.com.ifba.smartwaste.model.Ponto;

/**
 *
 * @author pc
 */
public class PontoService implements IPontoService{

    private final PontoDAO pontoDAO = new PontoDAO();
    private Ponto ponto;
    
    @Override
    public void cadastrarPonto(String endereco, Lixeira lixeiras) {
        this.ponto.setEndereco(endereco);
        /*ponto.setLixeiras(lixeiras);*/
        pontoDAO.criarPonto(ponto);
    }

    @Override
    public void apagarPonto(String endereco) {
        this.ponto = pontoDAO.findByEndereco(endereco);
        pontoDAO.deletarPonto(ponto);
    }

    @Override
    public void atualizarPonto(String endereco) {
        ponto.setEndereco(endereco);
        pontoDAO.editarPonto(ponto);
    }

    @Override
    public boolean findByEndereco(String endereco) {
        if(!endereco.isEmpty()) {
            pontoDAO.findByEndereco(endereco);
            return true;
        }else{
            return false;
        }
    }
    
}
