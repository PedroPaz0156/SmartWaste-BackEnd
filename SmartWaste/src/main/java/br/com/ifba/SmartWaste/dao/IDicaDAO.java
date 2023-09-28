package br.com.ifba.SmartWaste.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.SmartWaste.model.Dicas;

public interface IDicaDAO extends JpaRepository<Dicas, Integer> {

}