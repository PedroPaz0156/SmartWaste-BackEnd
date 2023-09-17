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
public class ServiceDica implements IServiceDicas{
    private int ultimaDica;
    private int numeroTotal;
    private final DicasDAO dicaDAO = new DicasDAO();
    
    
    
    @Override
    public String sortearDica(int ultimaDica) {
        ArrayList<Dicas> lista = dicaDAO.listar();
        this.numeroTotal = lista.size();
        int id = (int) (Math.random() * (this.numeroTotal - 0 + 1));
        Dicas dica = dicaDAO.procurar(id);
        return dica.getDica();
    }
    
}
