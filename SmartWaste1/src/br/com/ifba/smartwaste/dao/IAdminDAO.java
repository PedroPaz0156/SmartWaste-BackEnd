/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.dao;

import br.com.ifba.smartwaste.model.Administrador;
import java.util.ArrayList;

/**
 *
 * @author Pedro Augusto
 */
public interface IAdminDAO {
    
    public Administrador cadastrarAdmin(Administrador admin);
    public boolean deletarAdmin(Administrador admin);
    public void alterarAdmin(Administrador admin);
    public void alterarSenha(Administrador admin);
    public Administrador procurarAdm(String nome);
    public Administrador acesso(String nome, String password);
    public ArrayList<Administrador> findByEmail(String email);
    
}
