package br.com.ifba.administrador.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Administrador")
public class Administrador extends PersistenceEntity{
    
    String login;
    String senha;
    String email;
    String cpf;

    public Administrador
() {
    }

    public Administrador
(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Administrador
(String login, String senha, String email) {
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

}
