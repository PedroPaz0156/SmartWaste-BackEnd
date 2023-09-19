/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.infrastructure.util.Session;
import br.com.ifba.smartwaste.controller.PrincipalController;
import br.com.ifba.smartwaste.dao.AdminDAO;
import br.com.ifba.smartwaste.model.Administrador;
import br.com.ifba.smartwaste.view.TelaCadastroAdmin;
import br.com.ifba.smartwaste.view.TelaLogin;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Augusto
 */
public class AdminService implements IAdminService{

    private TelaCadastroAdmin telaCadastroAdmin;
    private TelaLogin telaLogin;

    public AdminService(TelaCadastroAdmin telaCadastroAdmin, TelaLogin telaLogin) {
        this.telaCadastroAdmin = telaCadastroAdmin;
        this.telaLogin = telaLogin;
        this.admin = new Administrador();
    }
    

    private final AdminDAO adminDAO = new AdminDAO();
    private Administrador admin;
    

        
    public AdminService(TelaCadastroAdmin telaCadastroAdmin) {
        this.telaCadastroAdmin = telaCadastroAdmin;
    }
    
    @Override
    public boolean cadastrarAdministrador() {
        this.admin = new Administrador();
        this.admin.setNome(this.telaCadastroAdmin.getTxtNome().getText());
        this.admin.setEmail(this.telaCadastroAdmin.getTxtEmail().getText());
        this.admin.setCpf(this.telaCadastroAdmin.getTxtCPF().getText());
        this.admin.setSenha(this.telaCadastroAdmin.getTxtSenha().getText());
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
    public void acessarAdmin() {
        admin = adminDAO.acesso(telaLogin.getTxtEmail().getText(), telaLogin.getTxtSenha().getText());

        if(!telaLogin.getTxtEmail().getText().isEmpty()) {
            Session.setUserName(admin.getNome());
            Administrador adm = adminDAO.findByEmail(telaLogin.getTxtEmail().getText());
            if(adm.getSenha().equals(telaLogin.getTxtSenha().getText())){
                this.telaLogin.dispose();
                PrincipalController pc = new PrincipalController();
            } else {
                JOptionPane.showMessageDialog(telaLogin, "Usuário e/ou senha incorreto(s)","Acesso Negado", 0);
            }
        }else{
            JOptionPane.showMessageDialog(telaLogin, "Usuário e/ou senha incorreto(s)","Acesso Negado", 0);
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
    
    @Override
    public void abrirTelaCadastro() {
        telaLogin.setVisible(false);
        telaCadastroAdmin.setVisible(true);
    }

    @Override
    public void voltar() {
        telaCadastroAdmin.setVisible(false);
        telaLogin.setVisible(true);
    }
    
}
