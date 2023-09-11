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
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Augusto
 */
public class AdminService implements IAdminService{

    public AdminService(TelaCadastroAdmin telaCadastro, TelaLogin telaLogin) {
        this.telaCadastro = telaCadastro;
        this.telaLogin = telaLogin;
        this.admin = new Administrador();
    }

    private final AdminDAO adminDAO = new AdminDAO();
    private Administrador admin;
    
    private final TelaCadastroAdmin telaCadastro;
    private final TelaLogin telaLogin;
    
    @Override
    public Administrador cadastrarAdministrador() {
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
        admin.setNome(nome);
        admin.setEmail(email);
        admin.setCpf(cpf);
        admin.setSenha(senha);
        adminDAO.alterarAdmin(admin);
    }

    @Override
    public void acessarAdmin() {
        admin = adminDAO.acesso(telaLogin.getTxtNome().getText(), telaLogin.getTxtSenha().getText());

        if(!telaLogin.getTxtNome().getText().isEmpty()) {
            Session.setUserName(admin.getNome());
            this.telaLogin.dispose();
            PrincipalController pc = new PrincipalController();
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
        telaCadastro.setVisible(true);
    }

    @Override
    public void voltar() {
        telaCadastro.setVisible(false);
        telaLogin.setVisible(true);
    }
    
}
