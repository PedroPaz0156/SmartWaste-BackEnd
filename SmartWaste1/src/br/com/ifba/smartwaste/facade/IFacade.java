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
    
    public Object login(String email, String senha);
    public boolean cadastrar(String nome, String email, String cpf, String senha);
    public boolean mudarSenha(String email, String senha);
    
    public Object listarPontos();
    public boolean criarPonto(String endereco);
    public boolean editPonto(int id, String endereco);
    public boolean deletPonto(int id);
    
    public boolean criarLixeira(String tamanho, String tipo, int pontoId);
    public boolean editLixeira(int id, String tamanho, String tipo, int pontoId);
    public boolean deleteLixeira(int id);
    
    public boolean criarSensor(int lixoId);
    public boolean editSensor(int lixoId);
    public boolean deleteSensor(int id);
    
    public Object buscarDica();
    
}
