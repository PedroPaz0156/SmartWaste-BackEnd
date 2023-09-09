/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.dao;

import br.com.ifba.smartwaste.model.Lixeira;

/**
 *
 * @author pc
 */
public interface ILixeiraDAO {
    
    public int criarLixeira(Lixeira lixeira);
    public void atualizarLixeira(Lixeira lixeira);
    public void deletarLixeira(Lixeira lixeira);
    public void pesquisarLixo(int id);
}
