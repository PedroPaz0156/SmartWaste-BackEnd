/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.controller;

import br.com.ifba.smartwaste.service.AdminService;
import br.com.ifba.smartwaste.view.TelaCadastroAdmin;
import br.com.ifba.smartwaste.view.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pedro Augusto
 */
public class LoginController implements ActionListener{
    
    private final TelaCadastroAdmin telaCadastro;
    private final TelaLogin telaLogin;
    private final AdminService adminService;

    public LoginController() {
        this.telaCadastro = new TelaCadastroAdmin();
        this.telaLogin = new TelaLogin();
        this.adminService = new AdminService(telaCadastro, telaLogin);
        addListeners();
        this.telaLogin.setVisible(true);
        
    }
    
    private void addListeners() {
        this.telaCadastro.getBtnCadastras().addActionListener(this);
        this.telaCadastro.getBtnVoltar().addActionListener(this);
        this.telaLogin.getBtnCadastrar().addActionListener(this);
        this.telaLogin.getBtnEntrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.telaCadastro.getBtnCadastras())) {
            this.adminService.cadastrarAdministrador();
        }else if(e.getSource().equals(this.telaCadastro.getBtnVoltar())){
            this.adminService.voltar();
        } else if(e.getSource().equals(this.telaLogin.getBtnCadastrar())){
            this.adminService.abrirTelaCadastro();
        } else if(e.getSource().equals(this.telaLogin.getBtnEntrar())){
            this.adminService.acessarAdmin();
        }
    }

}