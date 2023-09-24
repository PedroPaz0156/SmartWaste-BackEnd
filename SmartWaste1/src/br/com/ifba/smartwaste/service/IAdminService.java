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
    
    public boolean cadastrarAdministrador(String nome, String email, String cpf, String senha);
    public boolean apagarAdministrador(String email);
    public boolean atualizarAdministrador(String nome, String email, String cpf, String senha);
    public ArrayList <Administrador> findAll();
    public boolean acessarAdmin(String email, String senha);
    public Administrador findByName(String name);
    public Administrador findByEmail(String email);
}
