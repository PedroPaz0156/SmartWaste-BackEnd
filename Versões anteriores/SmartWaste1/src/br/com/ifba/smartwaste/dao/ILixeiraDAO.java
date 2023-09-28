/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.dao;

import br.com.ifba.smartwaste.model.Lixeira;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface ILixeiraDAO {
    
    public void criarLixeira(Lixeira lixeira);
    public void atualizarLixeira(Lixeira lixeira);
    public void deletarLixeira(Lixeira lixeira);
    public Lixeira pesquisarLixo(int id);
    public ArrayList<Lixeira> findByIdPonto(int idPonto);
}
