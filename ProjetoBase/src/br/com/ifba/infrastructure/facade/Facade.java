package br.com.ifba.infrastructure.facade;

import br.com.ifba.usuario.model.Usuario;
import br.com.ifba.usuario.service.IUsuarioService;
import br.com.ifba.usuario.service.UsuarioService;
import java.util.List;


public class Facade implements IFacade {
    
    //PESSOA
//    private final IPessoaService pessoaService = new PessoaService();
//
//    @Override
//    public Pessoa savePessoa(Pessoa pessoa) {
//        return pessoaService.savePessoa(pessoa);
//    }
//
//    @Override
//    public void deletePessoa(Pessoa pessoa) {
//        pessoaService.deletePessoa(pessoa);
//    }
//
//    @Override
//    public Pessoa updatePessoa(Pessoa pessoa) {
//        return pessoaService.updatePessoa(pessoa);
//    }
//
//    @Override
//    public List<Pessoa> findAllPessoa() {
//        return pessoaService.findAllPessoa();
//    }
//
//    @Override
//    public List<Pessoa> findByNamePessoa(String name) {
//        return pessoaService.findByNamePessoa(name);
//    }

    
    //USUARIO
    private final IUsuarioService usuarioService = new UsuarioService();

    
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioService.deleteUsuario(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioService.updateUsuario(usuario);
    }

    @Override
    public List<Usuario> findAllUsuario() {
        return usuarioService.findAllUsuario();
    }

    @Override
    public boolean checkLoginUsuario(String username, String password) {
        return usuarioService.checkLoginUsuario(username, password);
    }

    @Override
    public boolean findByUsernameUsuario(String username) {
        return usuarioService.findByUsername(username);
    }
    
    
}