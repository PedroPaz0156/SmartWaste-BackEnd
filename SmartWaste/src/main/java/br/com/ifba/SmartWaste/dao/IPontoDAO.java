package br.com.ifba.SmartWaste.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.SmartWaste.model.Ponto;

public interface IPontoDAO extends JpaRepository<Ponto, Integer>{
    
}
