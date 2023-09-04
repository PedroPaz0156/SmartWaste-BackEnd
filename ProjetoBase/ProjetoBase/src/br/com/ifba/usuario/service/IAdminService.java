package br.com.ifba.usuario.service;

import br.com.ifba.usuario.model.Administrador;
import java.util.List;

public interface IAdminService {
    
    
    public Administrador saveAdmin(Administrador admin);
    public void deleteAdmin(Administrador admin);
    public Administrador updateAdmin(Administrador admin);
    public List<Administrador> findAllAdmin();
    public boolean checkLoginAdmin(String username, String password);
    public boolean findByUsername(String username);
    
}
