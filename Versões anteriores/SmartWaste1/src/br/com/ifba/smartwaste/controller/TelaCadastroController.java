/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.controller;

import br.com.ifba.smartwaste.service.AdminService;
import br.com.ifba.smartwaste.view.TelaCadastroAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pedro Augusto
 */
public class TelaCadastroController implements ActionListener{
    
    private final TelaCadastroAdmin telaCadastro;
    private final AdminService adminService;

    public TelaCadastroController() {
        this.telaCadastro = new TelaCadastroAdmin();
        this.adminService = new AdminService(telaCadastro);
        addListeners();
        this.telaCadastro.setVisible(true);
    }
    
    private void addListeners() {
        this.telaCadastro.getBtnCadastras().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.telaCadastro.getBtnCadastras())) {
            this.adminService.cadastrarAdministrador();
        }
    }
    
}
