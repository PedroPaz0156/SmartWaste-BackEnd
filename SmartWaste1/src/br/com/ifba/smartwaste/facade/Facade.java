/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.facade;

import br.com.ifba.smartwaste.service.*;
/**
 *
 * @author Heber
 */
public class Facade implements IFacade{

    private final AdminService adminService = new AdminService();
    private final PontoService pontoService = new PontoService();
    private final LixeiraService lixoService = new LixeiraService();
    private final DicaService dicaService = new DicaService();
    
    
    @Override
    public boolean login(String email, String senha) {
        return this.adminService.acessarAdmin(email, senha);
    }

    @Override
    public boolean cadastrar(String nome, String email, String cpf, String senha) {
        return this.adminService.cadastrarAdministrador(nome, email, cpf, senha);
    }

    @Override
    public boolean editar(String nome, String email, String cpf, String senha) {
        return this.adminService.atualizarAdministrador(nome, email, cpf, senha);
    }

    @Override
    public boolean excluir(String email) {
        return this.adminService.apagarAdministrador(email);
    }    

    @Override
    public Object listarPontos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean criarPonto(String endereco, int tamanhoMet, int tamanhoOrg, int tamanhoPap, int tamanhoPla, int tamanhoVid) {
        return this.pontoService.cadastrarPontoELixo(endereco, tamanhoMet, tamanhoOrg, tamanhoPap, tamanhoPla, tamanhoVid);
    }

    @Override
    public boolean criarPontoVazio(String endereco) {
        return this.pontoService.cadastrarPontoVazio(endereco);
    }

    @Override
    public boolean editPonto(int id, String endereco) {
        return this.pontoService.atualizarPonto(id, endereco);
    }

    @Override
    public boolean editPontoELixo(int id, String endereco, int tamanhoMet, int tamanhoOrg, int tamanhoPap, int tamanhoPla, int tamanhoVid) {
        return this.pontoService.atualizarPontoELixo(id, endereco, tamanhoMet, tamanhoOrg, tamanhoPap, tamanhoPla, tamanhoVid);
    }
    
    @Override
    public boolean deletPonto(int id) {
        return this.pontoService.apagarPonto(id);
    }

    @Override
    public boolean criarLixeira(float tamanho, String tipo, int pontoId) {
        return this.lixoService.cadastrarLixeira(tamanho, tipo, pontoId);
    }

    @Override
    public boolean editLixeira(int id, float tamanho, String tipo, int pontoId) {
        return this.lixoService.atualizarLixeira(id, tamanho, tipo, pontoId);
    }

    @Override
    public boolean deleteLixeira(int id) {
        return this.lixoService.apagarLixeira(id);
    }

    @Override
    public boolean criarSensor(int lixoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean editSensor(int id, int lixoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteSensor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String buscarDica() {
        return this.dicaService.sortearDica();
    }
    //implementar chamada para todas as funções que o front vai usar do service aqui
    
}
