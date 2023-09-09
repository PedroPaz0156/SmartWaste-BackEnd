/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.model.Lixeira;
import br.com.ifba.smartwaste.model.Ponto;

/**
 *
 * @author Pedro Paz
 */
public interface IPontoService {
    
    public void cadastrarPonto(String endereco, Lixeira lixeiras);
    public void apagarPonto(String endereco);
    public void atualizarPonto(String endereco);
    public boolean findByEndereco(String endereco);
}
