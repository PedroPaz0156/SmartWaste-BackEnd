/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.dao;

import br.com.ifba.smartwaste.model.Ponto;

/**
 *
 * @author pc
 */
public interface IPontoDAO {
    
    public int criarPonto(Ponto ponto);
    public void editarPonto(Ponto ponto);
    public boolean deletarPonto(Ponto ponto);
    public Ponto procurarPonto(int id);
    public Ponto findByEndereco(String endereco);
    
}
