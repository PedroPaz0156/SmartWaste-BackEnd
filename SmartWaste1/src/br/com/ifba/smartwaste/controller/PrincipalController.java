/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.controller;

import br.com.ifba.smartwaste.model.Ponto;
import br.com.ifba.smartwaste.service.DicaService;
import br.com.ifba.smartwaste.service.PontoService;
import br.com.ifba.smartwaste.view.TelaCadastroPonto;
import br.com.ifba.smartwaste.view.TelaEditarPonto;
import br.com.ifba.smartwaste.view.TelaListaPonto;
import br.com.ifba.smartwaste.view.TelaListaPonto2;
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
    private final TelaListaPonto2 telaListPonto;
    
    private final TelaPrincipal telaPrincipal;
    private final PontoService pontoService;
    private final DicaService dicaService;
    
    public PrincipalController() {
        this.telaPrincipal = new TelaPrincipal();
        this.pontoService = new PontoService();
        this.telaCadPonto = new TelaCadastroPonto(telaPrincipal, true);
        this.telaEdiPonto = new TelaEditarPonto(telaPrincipal, true);
        this.telaRemPonto = new TelaRemoverPonto(telaPrincipal, true);
        this.telaListPonto = new TelaListaPonto2(telaPrincipal, true);
        this.dicaService = new DicaService();
        addListeners();
        this.telaPrincipal.setVisible(true);
    }

    private void addListeners() {
        this.telaPrincipal.getBtnNovo().addActionListener(this);
        this.telaPrincipal.getBtnSair().addActionListener(this);
        this.telaPrincipal.getBtnListarPontos().addActionListener(this);
        this.telaPrincipal.getBtnLixinho().addActionListener(this);
        this.telaCadPonto.getBtnCriar().addActionListener(this);
        this.telaCadPonto.getBtnFechar().addActionListener(this);
        this.telaEdiPonto.getBtnSalvar().addActionListener(this);
        this.telaEdiPonto.getBtnFechar().addActionListener(this);
        this.telaRemPonto.getBtnRemover().addActionListener(this);
        this.telaRemPonto.getBtnFechar().addActionListener(this);
        this.telaListPonto.getjButtonVoltar().addActionListener(this);
        this.telaListPonto.getjButtonEditar().addActionListener(this);
        this.telaListPonto.getjButtonExcluir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.telaPrincipal.getBtnNovo())) {
            this.telaCadPonto.setVisible(true);
        }else if(e.getSource().equals(this.telaPrincipal.getBtnSair())){
            LoginController loginController = new LoginController();
            this.telaPrincipal.dispose();
        }else if(e.getSource().equals(this.telaPrincipal.getBtnListarPontos())){
            pontoService.listarPonto(this.telaListPonto);
            this.telaListPonto.setVisible(true);
            
        }else if(e.getSource().equals(this.telaCadPonto.getBtnCriar())) {
            Ponto ponto = new Ponto();
            ponto.setEndereco(this.telaCadPonto.getTxtEndereco().getText());
            if(!this.telaCadPonto.getjCheckNAddMetal().isSelected()){
                ponto.getMetal().setTamanho((float) (Integer.parseInt(this.telaCadPonto.getTxtTamanhoMetal().getText())));
            }
            if(!this.telaCadPonto.getjCheckNAddOrganico().isSelected()){
                ponto.getOrganico().setTamanho((float) (Integer.parseInt(this.telaCadPonto.getTxtTamanhoOrganico().getText())));
            }
            if(!this.telaCadPonto.getjCheckNAddPapel().isSelected()){
                ponto.getPapel().setTamanho((float) (Integer.parseInt(this.telaCadPonto.getTxtTamanhoPapel().getText())));
            }
            if(!this.telaCadPonto.getjCheckNAddPlastico().isSelected()){
                ponto.getPlastico().setTamanho((float) (Integer.parseInt(this.telaCadPonto.getTxtTamanhoPlastico().getText())));
            }
            if(!this.telaCadPonto.getjCheckNAddVidro().isSelected()){
                ponto.getVidro().setTamanho((float) (Integer.parseInt(this.telaCadPonto.getTxtTamanhoVidro().getText())));
            }
            pontoService.cadastrarPonto(ponto);
            
        }else if(e.getSource().equals(this.telaCadPonto.getBtnFechar())) {
            this.telaCadPonto.setVisible(false);
        }else if(e.getSource().equals(this.telaEdiPonto.getBtnSalvar())) {
            Ponto ponto = new Ponto();
            ponto.setEndereco(this.telaEdiPonto.getTxtEndereco().getText());
            if(!this.telaEdiPonto.getjCheckNAddMetal().isSelected()){
                ponto.getMetal().setTamanho(Float.parseFloat(this.telaEdiPonto.getTxtTamanhoMetal().getText()));
            }
            if(!this.telaEdiPonto.getjCheckNAddOrganico().isSelected()){
                ponto.getOrganico().setTamanho(Float.parseFloat(this.telaEdiPonto.getTxtTamanhoOrganico().getText()));
            }
            if(!this.telaEdiPonto.getjCheckNAddPapel().isSelected()){
                ponto.getPapel().setTamanho(Float.parseFloat(this.telaEdiPonto.getTxtTamanhoPapel().getText()));
            }
            if(!this.telaEdiPonto.getjCheckNAddPlastico().isSelected()){
                ponto.getPlastico().setTamanho(Float.parseFloat(this.telaEdiPonto.getTxtTamanhoPlastico().getText()));
            }
            if(!this.telaEdiPonto.getjCheckNAddVidro().isSelected()){
                ponto.getVidro().setTamanho(Float.parseFloat(this.telaEdiPonto.getTxtTamanhoVidro().getText()));
            }
            pontoService.atualizarPonto(ponto);
            
        }else if(e.getSource().equals(this.telaEdiPonto.getBtnFechar())) {
            this.telaEdiPonto.setVisible(false);
        }else if(e.getSource().equals(this.telaPrincipal.getBtnLixinho())) {
            this.telaPrincipal.getLblDica().setText("<html> <p> " + dicaService.sortearDica() + "</p> </html>");
        }else if(e.getSource().equals(this.telaListPonto.getjButtonVoltar())){
            this.telaListPonto.setVisible(false);
        }else if(e.getSource().equals(this.telaListPonto.getjButtonEditar())){            
            int linha = this.telaListPonto.getjTableListaPonto().getSelectedRow();
            Ponto p = pontoService.findById((int) this.telaListPonto.getModelo().getValueAt(linha, 0));
            this.telaEdiPonto.getLblId().setText(Integer.toString(p.getIdPonto()));
            this.telaEdiPonto.getTxtEndereco().setText(p.getEndereco());
            this.telaEdiPonto.getTxtTamanhoMetal().setText(Float.toString(p.getMetal().getTamanho()));
            this.telaEdiPonto.getTxtTamanhoOrganico().setText(Float.toString(p.getOrganico().getTamanho()));
            this.telaEdiPonto.getTxtTamanhoPapel().setText(Float.toString(p.getPapel().getTamanho()));
            this.telaEdiPonto.getTxtTamanhoPlastico().setText(Float.toString(p.getPlastico().getTamanho()));
            this.telaEdiPonto.getTxtTamanhoVidro().setText(Float.toString(p.getVidro().getTamanho()));
            
            this.telaEdiPonto.setVisible(true);
        }else if(e.getSource().equals(this.telaListPonto.getjButtonExcluir())){
            int linha = this.telaListPonto.getjTableListaPonto().getSelectedRow();
            pontoService.apagarPontoById((int) this.telaListPonto.getModelo().getValueAt(linha,0));
        }
    }
    
}
