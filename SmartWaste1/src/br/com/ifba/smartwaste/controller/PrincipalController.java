/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.controller;

import br.com.ifba.smartwaste.model.Ponto;
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
            Ponto ponto = new Ponto();
            ponto.setEndereco(this.telaCadPonto.getTxtEndereco().getText());
            if(!this.telaCadPonto.getjCheckNAddMetal().isSelected()){
                ponto.getMetal().setIdSensor(Integer.parseInt(this.telaCadPonto.getTxtSensorMetal().getText()));
                ponto.getMetal().setTamanho((float) (Integer.parseInt(this.telaCadPonto.getTxtTamanhoMetal().getText())));
            } else{
                ponto.setMetal(null);
            }
            if(!this.telaCadPonto.getjCheckNAddOrganico().isSelected()){
                ponto.getOrganico().setIdSensor(Integer.parseInt(this.telaCadPonto.getTxtSensorOrganico().getText()));
                ponto.getOrganico().setTamanho((float) (Integer.parseInt(this.telaCadPonto.getTxtTamanhoOrganico().getText())));
            } else{
                ponto.setOrganico(null);
            }
            if(!this.telaCadPonto.getjCheckNAddPapel().isSelected()){
                ponto.getPapel().setIdSensor(Integer.parseInt(this.telaCadPonto.getTxtSensorPapel().getText()));
                ponto.getPapel().setTamanho((float) (Integer.parseInt(this.telaCadPonto.getTxtTamanhoPapel().getText())));
            } else{
                ponto.setPapel(null);
            }
            if(!this.telaCadPonto.getjCheckNAddPlastico().isSelected()){
                ponto.getPlastico().setIdSensor(Integer.parseInt(this.telaCadPonto.getTxtSensorPlastico().getText()));
                ponto.getPlastico().setTamanho((float) (Integer.parseInt(this.telaCadPonto.getTxtTamanhoPlastico().getText())));
            } else{
                ponto.setPlastico(null);
            }
            if(!this.telaCadPonto.getjCheckNAddVidro().isSelected()){
                ponto.getVidro().setIdSensor(Integer.parseInt(this.telaCadPonto.getTxtSensorVidro().getText()));
                ponto.getVidro().setTamanho((float) (Integer.parseInt(this.telaCadPonto.getTxtTamanhoVidro().getText())));
            } else{
                ponto.setVidro(null);
            }
            pontoService.cadastrarPonto(ponto);
            
        }else if(e.getSource().equals(this.telaCadPonto.getBtnFechar())) {
            this.telaCadPonto.setVisible(false);
        }else if(e.getSource().equals(this.telaEdiPonto.getBtnSalvar())) {
            Ponto ponto = new Ponto();
            ponto.setEndereco(this.telaEdiPonto.getTxtEndereco().getText());
            
            pontoService.atualizarPonto(ponto);
        }else if(e.getSource().equals(this.telaEdiPonto.getBtnFechar())) {
            this.telaEdiPonto.setVisible(false);
        }else if(e.getSource().equals(this.telaRemPonto.getBtnRemover())) {
            pontoService.apagarPonto(this.telaRemPonto.getTxtEndereco().getText());
        }else if(e.getSource().equals(this.telaRemPonto.getBtnFechar())) {
            this.telaRemPonto.setVisible(false);
        }
    }
    
    
}
