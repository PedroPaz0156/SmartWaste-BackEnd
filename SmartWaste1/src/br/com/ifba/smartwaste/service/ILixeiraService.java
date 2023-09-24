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
    public boolean cadastrarLixeira(float tamanho, String tipo, int pontoId);
    public boolean cadastrarLixeira(Lixeira l);
    public boolean apagarLixeira(int id);
    public boolean atualizarLixeira(int id, float tamanho, String tipo, int pontoId);
    public boolean atualizarLixeira(Lixeira l);
    public Lixeira findByIdLixeira(int idLixeira);
    public ArrayList<Lixeira> findByIdPonto(int idPonto);
}
