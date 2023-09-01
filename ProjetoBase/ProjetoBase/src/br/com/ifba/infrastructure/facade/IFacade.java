package br.com.ifba.infrastructure.facade;

import br.com.ifba.usuario.model.Usuario;
import java.util.List;


public interface IFacade {
    
    //PESSOA
//    public Pessoa savePessoa(Pessoa pessoa);
//    public void deletePessoa(Pessoa pessoa);
//    public Pessoa updatePessoa(Pessoa pessoa);
//    public List<Pessoa> findAllPessoa();
//    public List<Pessoa> findByNamePessoa(String name);
    
    //USUARIO
    public Usuario saveUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
    public Usuario updateUsuario(Usuario usuario);
    public List<Usuario> findAllUsuario();
    public boolean checkLoginUsuario(String username, String password);
    public boolean findByUsernameUsuario(String username);
    
}