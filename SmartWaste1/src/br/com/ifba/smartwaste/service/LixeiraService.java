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
    public void cadastrarLixeira(Lixeira lixeira) {
        lixeiraDAO.criarLixeira(lixeira);
    }

    @Override
    public void apagarLixeira(int idLixeira) {
        this.lixeira = lixeiraDAO.pesquisarLixo(idLixeira);
        lixeiraDAO.deletarLixeira(lixeira);
    }

    @Override
    public void atualizarLixeira(Lixeira lixeira) {
        lixeiraDAO.atualizarLixeira(lixeira);
    }

    @Override
    public Lixeira findByIdLixeira(int idLixeira) {
        if(!(idLixeira==0)) {
            return lixeiraDAO.pesquisarLixo(idLixeira);
        }else{
            return null;
        }
    }
    
    
    @Override
    public ArrayList<Lixeira> findByIdPonto(int idPonto){
        return lixeiraDAO.findByIdPonto(idPonto);
    }
    
}
