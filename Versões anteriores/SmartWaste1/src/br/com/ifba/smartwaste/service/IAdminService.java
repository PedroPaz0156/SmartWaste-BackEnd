/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.model.Administrador;
import java.util.ArrayList;

/**
 *
 * @author Pedro Augusto Martins da Paz Souza
 */
public interface IAdminService {
    
    public boolean cadastrarAdministrador();
    public void apagarAdministrador(String nome);
    public void atualizarAdministrador(String nome, String email, String cpf, String senha);
    public ArrayList <Administrador> findAll();
    public void acessarAdmin();
    public boolean findByName(String name);
    public boolean findByEmail(String email);
    public void abrirTelaCadastro();
    public void voltar();
}
