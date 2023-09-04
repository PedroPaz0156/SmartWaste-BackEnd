package br.com.ifba.usuario.service;

import br.com.ifba.usuario.dao.IUsuarioDAO;
import br.com.ifba.usuario.dao.UsuarioDAO;
import br.com.ifba.usuario.model.Usuario;
import java.util.List;

public class UsuarioService implements IUsuarioService{
    
    private final IUsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioDAO.update(usuario);
    }

    @Override
    public List<Usuario> findAllUsuario() {
        return usuarioDAO.findAll();
    }

    @Override
    public boolean checkLoginUsuario(String username, String password) {
        return usuarioDAO.checkLogin(username, password);
    }

    @Override
    public boolean findByUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }


    

}
