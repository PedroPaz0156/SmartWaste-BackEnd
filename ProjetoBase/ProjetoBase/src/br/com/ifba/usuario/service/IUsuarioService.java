package br.com.ifba.usuario.service;

import br.com.ifba.usuario.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    
    
    public Usuario saveUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
    public Usuario updateUsuario(Usuario usuario);
    public List<Usuario> findAllUsuario();
    public boolean checkLoginUsuario(String username, String password);
    public boolean findByUsername(String username);
    
}
