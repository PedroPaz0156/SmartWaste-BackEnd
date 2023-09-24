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

    public boolean cadastrarPontoELixo(String endereco, int tamanhoMet, int tamanhoOrg, int tamanhoPap, int tamanhoPla, int tamanhoVid);
    public boolean cadastrarPontoVazio(String endereco);
    public boolean apagarPonto(int id);
    public boolean atualizarPonto(int id, String endereco);
    public boolean atualizarPontoELixo(int id, String endereco, int tamanhoMet, int tamanhoOrg, int tamanhoPap, int tamanhoPla, int tamanhoVid);
    public Ponto findByEndereco(String endereco);
    public Ponto findById(int id);
    public ArrayList <Ponto> findAll();
}
