package br.com.ifba.usuario.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Usuario")
public class Usuario extends PersistenceEntity{
    
    String login;
    String senha;
    String email;

    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha, String email) {
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
    
    

}
