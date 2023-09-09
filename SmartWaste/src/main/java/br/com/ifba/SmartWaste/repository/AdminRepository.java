/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.SmartWaste.repository;

import br.com.ifba.SmartWaste.model.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author Pedro Augusto
 */
@Repository
public interface AdminRepository extends CrudRepository<Administrador, Integer>{

    //listar todos
    @Override
    public List<Administrador> findAll();
    
    //buscar por colunas
    public Administrador findByIdAdmin(int id);
    public Administrador findByEmail(String email);
    public Administrador findByCpf(String cpf);
    public Administrador findByNome(String nome);
    
    //deletar
    @Override
    void delete(Administrador adm);
    
    //salvar
    @Override
    <Adm extends Administrador> Adm save(Adm adm);
    
}
