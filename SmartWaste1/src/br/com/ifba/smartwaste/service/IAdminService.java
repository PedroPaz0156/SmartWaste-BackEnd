/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.service;


/**
 *
 * @author Pedro Augusto Martins da Paz Souza
 */
public interface IAdminService {
    
    public void cadastrarAdministrador();
    public void apagarAdministrador(String nome);
    public void atualizarAdministrador(String nome, String email, String cpf, String senha);
    public boolean acessarAdmin(String nome, String senha);
    public boolean findByName(String name);
    public boolean findByEmail(String email);
}
