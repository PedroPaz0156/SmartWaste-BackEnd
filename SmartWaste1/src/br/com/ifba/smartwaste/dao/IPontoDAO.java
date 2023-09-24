/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.dao;

import br.com.ifba.smartwaste.model.Ponto;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface IPontoDAO {

    public boolean criarPonto(Ponto ponto);
    public boolean editarPonto(Ponto ponto);
    public boolean deletarPonto(Ponto ponto);
    public Ponto procurarPonto(int id);
    public Ponto findByEndereco(String endereco);
    public ArrayList <Ponto> findAll();
    
}
