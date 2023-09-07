/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.SmartWaste.repository;

import br.com.ifba.SmartWaste.model.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pedro Augusto
 */
@Repository
public interface AdminRepository extends CrudRepository<Administrador, Integer>{

    public Administrador findByEmail(String email);

}
