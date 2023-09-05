/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pontoDeColeta.service;

import br.com.ifba.pontoDeColeta.service.IPontoService;
import br.com.ifba.pontoDeColeta.dao.IPontoDAO;
import br.com.ifba.pontoDeColeta.dao.PontoDAO;
import br.com.ifba.pontoDeColeta.model.PontoDeColeta;
import java.util.List;

/**
 *
 * @author Pedro Augusto
 */
public class PontoService implements IPontoService{
    
    private IPontoDAO pontoDAO = new PontoDAO();

    @Override
    public PontoDeColeta savePonto(PontoDeColeta ponto) {
        return pontoDAO.save(ponto);
    }

    @Override
    public void deletePonto(PontoDeColeta ponto) {
        pontoDAO.delete(ponto);
    }

    @Override
    public PontoDeColeta updatePonto(PontoDeColeta ponto) {
        return pontoDAO.update(ponto);
    }

    @Override
    public List<PontoDeColeta> findAllPonto() {
        return pontoDAO.findAll();
    }

    @Override
    public List<PontoDeColeta> findByEndereco(String endereco) {
        return pontoDAO.findByEndereco(endereco);
    }
    
}
