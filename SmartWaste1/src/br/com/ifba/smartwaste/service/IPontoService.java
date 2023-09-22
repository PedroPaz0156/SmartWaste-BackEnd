/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.model.Ponto;
import java.util.ArrayList;

/**
 *
 * @author Pedro Paz
 */
public interface IPontoService {
    
    public void cadastrarPonto(Ponto ponto);
    public void apagarPontoByEndereco(String endereco);
    public void apagarPontoById(int id);
    public void apagarPonto(Ponto ponto);
    public void atualizarPonto(Ponto ponto);
    public Ponto findByEndereco(String endereco);
    public Ponto findById(int id);
    public ArrayList <Ponto> findAll();
    public void gerarLista(ArrayList <Ponto> lista);
    public void listarPonto();
}
