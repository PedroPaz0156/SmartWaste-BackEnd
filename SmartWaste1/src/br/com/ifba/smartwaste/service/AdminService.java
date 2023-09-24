/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.infrastructure.util.Session;
import br.com.ifba.smartwaste.dao.AdminDAO;
import br.com.ifba.smartwaste.model.Administrador;
import java.util.ArrayList;

/**
 *
 * @author Pedro Augusto
 */
public class AdminService implements IAdminService{
   
    private final AdminDAO adminDAO = new AdminDAO();
    private Administrador admin;

    public AdminService() {
    }
    
    @Override
    public boolean cadastrarAdministrador(String nome, String email, String cpf, String senha) {
        this.admin = new Administrador();
        this.admin.setNome(nome);
        this.admin.setEmail(email);
        this.admin.setCpf(cpf);
        this.admin.setSenha(senha);
        return adminDAO.cadastrarAdmin(admin);
    }

    @Override
    public boolean apagarAdministrador(String email) {
        this.admin = new Administrador();
        admin = adminDAO.findByEmail(email);
        return adminDAO.deletarAdmin(admin);
    }

    @Override
    public boolean atualizarAdministrador(String nome, String email, String cpf, String senha) {
        this.admin = new Administrador();
        admin.setNome(nome);
        admin.setEmail(email);
        admin.setCpf(cpf);
        admin.setSenha(senha);
        return adminDAO.alterarAdmin(admin);
    }

    @Override
    public boolean acessarAdmin(String email, String senha) {
    admin = adminDAO.acesso(email, senha);
        if (!admin.getNome().equals("")){
            Session.setUserName(admin.getNome());
            return true;
        } else{
            return false;
        }
    }

    @Override
    public Administrador findByName(String name) {
        return adminDAO.procurarAdm(name);
    }

    @Override
    public Administrador findByEmail(String email) {
        return adminDAO.findByEmail(email);

    }
    
    @Override
    public ArrayList <Administrador> findAll() {
        return adminDAO.findAll();
    }
    
}