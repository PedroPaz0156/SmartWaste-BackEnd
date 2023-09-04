package br.com.ifba.infrastructure.facade;

import br.com.ifba.usuario.model.Administrador;
import br.com.ifba.usuario.service.AdminService;
import java.util.List;
import br.com.ifba.usuario.service.IAdminService;


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
    private final IAdminService usuarioService = new AdminService();

    
    @Override
    public Administrador saveUsuario(Administrador admin) {
        return usuarioService.saveAdmin(admin);
    }

    @Override
    public void deleteUsuario(Administrador admin) {
        usuarioService.deleteAdmin(admin);
    }

    @Override
    public Administrador updateUsuario(Administrador admin) {
        return usuarioService.updateAdmin(admin);
    }

    @Override
    public List<Administrador> findAllUsuario() {
        return usuarioService.findAllAdmin();
    }

    @Override
    public boolean checkLoginUsuario(String username, String password) {
        return usuarioService.checkLoginAdmin(username, password);
    }

    @Override
    public boolean findByUsernameAdmin(String username) {
        return usuarioService.findByUsername(username);
    }
    
    
}