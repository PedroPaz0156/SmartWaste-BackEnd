package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.IBaseDao;
import br.com.ifba.usuario.model.Administrador;


public interface IAdminDAO extends IBaseDao<Administrador>{
    
    public boolean checkLogin(String username, String password);
    public boolean findByUsername(String username);
    
}
