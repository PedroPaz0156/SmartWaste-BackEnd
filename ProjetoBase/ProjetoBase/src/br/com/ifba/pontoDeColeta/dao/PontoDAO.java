/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pontoDeColeta.dao;

import br.com.ifba.pontoDeColeta.dao.IPontoDAO;
import br.com.ifba.infrastructure.dao.BaseDao;
import br.com.ifba.pontoDeColeta.model.PontoDeColeta;
import br.com.ifba.pontoDeColeta.model.PontoDeColeta;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author pc
 */
public class PontoDAO extends BaseDao<PontoDeColeta> implements IPontoDAO{

    @Override
    public String gerarRelatorio(String parametros) {
        String relatorio = null;
        //inserir depois os parametros de filtragem;
        return relatorio;
    }

    @Override
    public List<PontoDeColeta> findByEndereco(String endereco) {
        String busca = "SELECT e FROM PontoDeColeta AS e WHERE e.endereco=:endereco";
        Query query = entityManager.createQuery(busca);
        query.setParameter("endereco", endereco);
        return query.getResultList();
    }
   
}
