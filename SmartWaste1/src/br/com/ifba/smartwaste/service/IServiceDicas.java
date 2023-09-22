/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.model.Dicas;
import java.util.ArrayList;

/**
 *
 * @author Pedro Augusto
 */
public interface IServiceDicas {
    public void adicionarDica(String dica);
    public void alterarDica(String dica);
    public void removerDica(int id);
    public Dicas procurar(int id);
    public ArrayList<Dicas> listar();
    public String sortearDica();
    
}
