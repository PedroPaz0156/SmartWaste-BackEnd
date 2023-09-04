package br.com.ifba.infrastructure.facade;

import br.com.ifba.usuario.model.Administrador;
import java.util.List;


public interface IFacade {
    
    //PESSOA
//    public Pessoa savePessoa(Pessoa pessoa);
//    public void deletePessoa(Pessoa pessoa);
//    public Pessoa updatePessoa(Pessoa pessoa);
//    public List<Pessoa> findAllPessoa();
//    public List<Pessoa> findByNamePessoa(String name);
    
    //USUARIO
    public Administrador saveUsuario(Administrador admin);
    public void deleteUsuario(Administrador admin);
    public Administrador updateUsuario(Administrador admin);
    public List<Administrador> findAllUsuario();
    public boolean checkLoginUsuario(String username, String password);
    public boolean findByUsernameAdmin(String username);
    
}