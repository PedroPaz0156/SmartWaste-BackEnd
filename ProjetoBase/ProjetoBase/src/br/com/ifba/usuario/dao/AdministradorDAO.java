package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.BaseDao;
import br.com.ifba.infrastructure.util.Session;
import br.com.ifba.usuario.model.Administrador;
import javax.persistence.Query;

public class AdministradorDAO extends BaseDao<Administrador> implements IAdminDAO{

    @Override
    public boolean checkLogin(String username, String password) {
        String sql = "SELECT u FROM Usuario AS u WHERE u.login = :login AND u.senha = :senha";
        Query query = entityManager.createQuery(sql);
        query.setParameter("login", username);
        query.setParameter("senha", password);
        if(!query.getResultList().isEmpty()){
            Session.setUserName(username);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean findByUsername(String username) {
        String sql = "SELECT u FROM administrador AS u WHERE u.login = :login";
        Query query = entityManager.createQuery(sql);
        query.setParameter("login", username);
        if(!query.getResultList().isEmpty()){
            Session.setUserName(username);
            Session.setUserId(((Administrador)query.getResultList().get(0)).getId());
            return true;
        } else{
            return false;
        }
    }
    


}
