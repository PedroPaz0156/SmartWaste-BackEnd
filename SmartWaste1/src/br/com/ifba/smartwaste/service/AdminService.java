/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.infrastructure.util.Session;
import br.com.ifba.smartwaste.dao.AdminDAO;
import br.com.ifba.smartwaste.model.Administrador;
import br.com.ifba.smartwaste.view.TelaCadastro;

/**
 *
 * @author Pedro Augusto
 */
public class AdminService implements IAdminService{

    public AdminService(TelaCadastro telaCadastro) {
        this.telaCadastro = telaCadastro;
    }

    private final AdminDAO adminDAO = new AdminDAO();
    private Administrador admin;
    
    private final TelaCadastro telaCadastro;
    
    @Override
    public Administrador cadastrarAdministrador() {
        this.admin = new Administrador();
        this.admin.setNome(this.telaCadastro.getTxtNome().getText());
        this.admin.setEmail(this.telaCadastro.getTxtEmail().getText());
        this.admin.setCpf(this.telaCadastro.getTxtCPF().getText());
        this.admin.setSenha(this.telaCadastro.getTxtSenha().getText());
        return adminDAO.cadastrarAdmin(admin);
    }

    @Override
    public void apagarAdministrador(String nome) {
        this.admin = new Administrador();
        admin = adminDAO.procurarAdm(nome);
        adminDAO.deletarAdmin(admin);
    }

    @Override
    public void atualizarAdministrador(String nome, String email, String cpf, String senha) {
        this.admin = new Administrador();
        admin.setNome(nome);
        admin.setEmail(email);
        admin.setCpf(cpf);
        admin.setSenha(senha);
        adminDAO.alterarAdmin(admin);
    }

    @Override
    public boolean acessarAdmin(String nome, String senha) {
        if(!nome.isEmpty()) {
            if(!senha.isEmpty()) {
                adminDAO.acesso(nome, senha);
                Session.setUserName(nome);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean findByName(String name) {
        if(!name.isEmpty()) {
                adminDAO.procurarAdm(name);
                return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean findByEmail(String email) {
        if(!email.isEmpty()) {
                adminDAO.findByEmail(email);
                return true;
        }else{
            return false;
        }
    }
    
}
