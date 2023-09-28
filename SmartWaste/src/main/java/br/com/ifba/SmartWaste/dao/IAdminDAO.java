package br.com.ifba.SmartWaste.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ifba.SmartWaste.model.Administrador;

public interface IAdminDAO extends JpaRepository<Administrador, String>{
    @Query(value = "SELECT * FROM administrador WHERE cpf = :cpf AND senha = :senha", nativeQuery = true)
    public Administrador checkLogin(String cpf, String senha);
    @Query(value = "SELECT * FROM administrador WHERE email LIKE :email ORDER BY email,nome", nativeQuery = true)
    public Administrador findByEmail(String email);
    @Query(value = "UPDATE administrador SET senha = :senha WHERE email LIKE :email", nativeQuery = true)
    public Administrador alterarSenha(String senha);
}
