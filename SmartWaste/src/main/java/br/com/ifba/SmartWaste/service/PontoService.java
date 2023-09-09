/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.SmartWaste.service;

import br.com.ifba.SmartWaste.model.PontoDeColeta;
import br.com.ifba.SmartWaste.repository.PontoRepository;
import br.com.ifba.SmartWaste.util.ReplyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Heber
 */

@Service
public class PontoService {
    
    @Autowired
    private PontoRepository PontoRepository;
    
    @Autowired
    private ReplyUtil ru;
    
    //Método de listagem de todas as instâncias de Pontos de coleta
    public Iterable<PontoDeColeta> listar() {
        return PontoRepository.findAll();
    }
    
    //Método de cadastro
    public PontoDeColeta cadastrar(PontoDeColeta Ponto) {
        return PontoRepository.save(Ponto);
    }
    
    //Método de deleção
    public void deletar(String endereco) {
        PontoDeColeta Ponto;
        Ponto = PontoRepository.findByEndereco(endereco);
        PontoRepository.delete(Ponto);
    }
}
