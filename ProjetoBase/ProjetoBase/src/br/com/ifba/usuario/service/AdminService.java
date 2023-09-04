package br.com.ifba.usuario.service;

import br.com.ifba.usuario.dao.IAdminDAO;
import br.com.ifba.usuario.dao.AdministradorDAO;
import br.com.ifba.usuario.model.Administrador;
import java.util.List;

public class AdminService implements IAdminService{
    
    private final IAdminDAO adminDAO = new AdministradorDAO();

    @Override
    public Administrador saveAdmin(Administrador admin) {
        return adminDAO.save(admin);
    }

    @Override
    public void deleteAdmin(Administrador admin) {
        adminDAO.delete(admin);
    }

    @Override
    public Administrador updateAdmin(Administrador admin) {
        return adminDAO.update(admin);
    }

    @Override
    public List<Administrador> findAllAdmin() {
        return adminDAO.findAll();
    }

    @Override
    public boolean checkLoginAdmin(String username, String password) {
        return adminDAO.checkLogin(username, password);
    }

    @Override
    public boolean findByUsername(String username) {
        return adminDAO.findByUsername(username);
    }


    

}
