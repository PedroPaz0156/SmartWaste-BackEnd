/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.SmartWaste.repository;

import br.com.ifba.SmartWaste.model.PontoDeColeta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 *
 * @author Pedro Augusto
 */
@Repository
public interface PontoRepository extends CrudRepository<PontoDeColeta, Integer>{
    
    //listar todos
    @Override
    public List<PontoDeColeta> findAll();

    //buscar por colunas
    public PontoDeColeta findByIdPonto(int id);
    public PontoDeColeta findByEndereco(String endereco);
    public PontoDeColeta findByUltimaColeta(String ultimaColeta);
    public PontoDeColeta findByOcupacaoMedia(String ocupacaoMedia);
    

    //deletar
    @Override
    void delete(PontoDeColeta ponto);
    
    //salvar
    @Override
    <Ponto extends PontoDeColeta> Ponto save(Ponto ponto);
}
