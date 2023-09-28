/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.smartwaste.service;

import br.com.ifba.smartwaste.model.Lixeira;
import java.util.ArrayList;

/**
 *
 * @author Heber
 */
public interface ILixeiraService {
    public void cadastrarLixeira(Lixeira lixeira);
    public void apagarLixeira(int idLixeira);
    public void atualizarLixeira(Lixeira lixeira);
    public Lixeira findByIdLixeira(int idLixeira);
    public ArrayList<Lixeira> findByIdPonto(int idPonto);
}
