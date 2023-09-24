/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.facade;

/**
 *
 * @author Heber
 */
public interface IFacade {
    
    public boolean login(String email, String senha);
    public boolean cadastrar(String nome, String email, String cpf, String senha);
    public boolean editar(String nome, String email, String cpf, String senha);
    public boolean excluir(String email);

    public Object listarPontos();
    public boolean criarPonto(String endereco, int tamanhoMet, int tamanhoOrg, int tamanhoPap, int tamanhoPla, int tamanhoVid);
    public boolean criarPontoVazio(String endereco);
    public boolean editPonto(int id, String endereco);
    public boolean editPontoELixo(int id, String endereco, int tamanhoMet, int tamanhoOrg, int tamanhoPap, int tamanhoPla, int tamanhoVid);    
    public boolean deletPonto(int id);
    
    public boolean criarLixeira(float tamanho, String tipo, int pontoId);
    public boolean editLixeira(int id, float tamanho, String tipo, int pontoId);
    public boolean deleteLixeira(int id);
    
    public boolean criarSensor(int lixoId);
    public boolean editSensor(int id, int lixoId);
    public boolean deleteSensor(int id);
    
    public String buscarDica();
    
}
