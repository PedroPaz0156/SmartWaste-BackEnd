/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.controller;

import br.com.ifba.smartwaste.service.PontoService;
import br.com.ifba.smartwaste.view.TelaCadastroPonto;
import br.com.ifba.smartwaste.view.TelaEditarPonto;
import br.com.ifba.smartwaste.view.TelaPrincipal;
import br.com.ifba.smartwaste.view.TelaRemoverPonto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pedro Paz
 */
public class PrincipalController implements ActionListener{
    private final TelaCadastroPonto telaCadPonto;
    private final TelaEditarPonto telaEdiPonto;
    private final TelaRemoverPonto telaRemPonto;
    
    
    private final TelaPrincipal telaPrincipal;
    private final PontoService pontoService;
    
    public PrincipalController() {
        this.telaPrincipal = new TelaPrincipal();
        this.pontoService = new PontoService();
        this.telaCadPonto = new TelaCadastroPonto(telaPrincipal, true);
        this.telaEdiPonto = new TelaEditarPonto(telaPrincipal, true);
        this.telaRemPonto = new TelaRemoverPonto(telaPrincipal, true);
        addListeners();
        this.telaPrincipal.setVisible(true);
    }

    private void addListeners() {
        this.telaPrincipal.getBtnNovo().addActionListener(this);
        this.telaPrincipal.getBtnAlterar().addActionListener(this);
        this.telaPrincipal.getBtnRemover().addActionListener(this);
        this.telaPrincipal.getBtnSair().addActionListener(this);
        this.telaCadPonto.getBtnCriar().addActionListener(this);
        this.telaCadPonto.getBtnFechar().addActionListener(this);
        this.telaEdiPonto.getBtnSalvar().addActionListener(this);
        this.telaEdiPonto.getBtnFechar().addActionListener(this);
        this.telaRemPonto.getBtnRemover().addActionListener(this);
        this.telaRemPonto.getBtnFechar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.telaPrincipal.getBtnNovo())) {
            this.telaCadPonto.setVisible(true);
        }else if(e.getSource().equals(this.telaPrincipal.getBtnAlterar())) {
            this.telaEdiPonto.setVisible(true);
        }else if(e.getSource().equals(this.telaPrincipal.getBtnRemover())) {
            this.telaRemPonto.setVisible(true);
        }else if(e.getSource().equals(this.telaPrincipal.getBtnSair())){
            LoginController loginController = new LoginController();
            this.telaPrincipal.dispose();
        }else if(e.getSource().equals(this.telaCadPonto.getBtnCriar())) {
            pontoService.cadastrarPonto(this.telaCadPonto.getTxtEndereco().getText(), (int) this.telaCadPonto.getSpnLixeiras().getValue());
        }else if(e.getSource().equals(this.telaCadPonto.getBtnFechar())) {
            this.telaCadPonto.setVisible(false);
        }else if(e.getSource().equals(this.telaEdiPonto.getBtnSalvar())) {
            pontoService.atualizarPonto(this.telaEdiPonto.getTxtEndereco().getText());
        }else if(e.getSource().equals(this.telaEdiPonto.getBtnFechar())) {
            this.telaEdiPonto.setVisible(false);
        }else if(e.getSource().equals(this.telaRemPonto.getBtnRemover())) {
            pontoService.apagarPonto(this.telaRemPonto.getTxtEndereco().getText());
        }else if(e.getSource().equals(this.telaRemPonto.getBtnFechar())) {
            this.telaRemPonto.setVisible(false);
        }
    }
    
    
}
