/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.pontoDeColeta.service;

import br.com.ifba.pontoDeColeta.model.PontoDeColeta;
import java.util.List;

/**
 *
 * @author pc
 */
public interface IPontoService {
    
    public PontoDeColeta savePonto(PontoDeColeta ponto);
    public void deletePonto(PontoDeColeta ponto);
    public PontoDeColeta updatePonto(PontoDeColeta ponto);
    public List<PontoDeColeta> findAllPonto();
    public List<PontoDeColeta> findByEndereco(String endereco);
    
}
