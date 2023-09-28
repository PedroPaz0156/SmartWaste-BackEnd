/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.dao.DicasDAO;
import br.com.ifba.smartwaste.model.Dicas;
import java.util.ArrayList;

/**
 *
 * @author Pedro Paz
 */
public class DicaService implements IServiceDicas{
    private int ultimaDica;
    private int numeroTotal;
    private final DicasDAO dicaDAO = new DicasDAO();
    private Dicas dica = new Dicas();
    
    @Override
    public String sortearDica() {
        ArrayList<Dicas> lista = dicaDAO.listar();
        this.numeroTotal = lista.size();
        int id =(int) (Math.random() % (this.numeroTotal));
        this.dica = dicaDAO.procurar(id);
        return dica.getDica();
    }

    @Override
    public void adicionarDica(String dica) {
        this.dica.setDica(dica);
        dicaDAO.inserir(this.dica);
    }

    @Override
    public void alterarDica(String dica) {
        this.dica.setDica(dica);
        dicaDAO.alterar(this.dica);
    }

    @Override
    public void removerDica(int id) {
        this.dica.setId(id);
        dicaDAO.deletar(this.dica);
    }

    @Override
    public Dicas procurar(int id){
        return dicaDAO.procurar(id);
    }
    @Override
    public ArrayList<Dicas> listar() {
        return dicaDAO.listar();
    }
    
}
