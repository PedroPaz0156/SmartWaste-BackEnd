/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.IBaseDao;
import br.com.ifba.usuario.model.PontoDeColeta;
import java.util.List;

/**
 *
 * @author Pedro Augusto
 */
public interface IPontoDAO extends IBaseDao<PontoDeColeta>{
    
    public String gerarRelatorio(String parametros);
    public List<PontoDeColeta> findByEndereco(String endereco);
    
}
