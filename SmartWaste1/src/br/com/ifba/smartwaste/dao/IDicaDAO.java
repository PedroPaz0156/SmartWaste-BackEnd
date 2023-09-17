/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.dao;

import br.com.ifba.smartwaste.model.Dicas;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface IDicaDAO {
    public void inserir(Dicas dica);
    public void alterar(Dicas dica);
    public void deletar(Dicas dica);
    public Dicas procurar(int id);
    public ArrayList<Dicas> listar();
    
}
