/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.model.Ponto;

/**
 *
 * @author Pedro Paz
 */
public interface IPontoService {
    
    public void cadastrarPonto(Ponto ponto);
    public void apagarPonto(String endereco);
    public void atualizarPonto(Ponto ponto);
    public Ponto findByEndereco(String endereco);
}
