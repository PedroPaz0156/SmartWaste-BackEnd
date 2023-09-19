/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.dao;

import br.com.ifba.infrastructure.util.Session;
import br.com.ifba.smartwaste.model.Administrador;
import br.com.ifba.smartwaste.model.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pedro Augusto
 */
public class AdminDAO implements IAdminDAO{

    @Override
    public boolean cadastrarAdmin(Administrador admin) {
        String sql = "INSERT INTO administrador (nome,email,cpf,senha) VALUES (?,?,?,?)";
        
            PreparedStatement pst;
            ResultSet rs;
            
            try {                
                pst = Conexao.getConexao().prepareStatement(sql);
                pst.setString(1, admin.getNome());
                pst.setString(2, admin.getEmail());
                pst.setString(3, admin.getCpf());
                pst.setString(4, admin.getSenha());
                pst.execute();
                pst.close();
                
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
                
                return false;
            } 
    }

    @Override
    public void deletarAdmin(Administrador admin) {
        String sql = "DELETE FROM administrador WHERE cpf = ?";
        
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, admin.getCpf());
            pst.execute();
            pst.close();                
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void alterarAdmin(Administrador admin) {
        String sql = "UPDATE administrador SET nome = ? , email = ?, cpf = ?, senha = ?";
        
        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, admin.getNome());
            pst.setString(2, admin.getEmail());
            pst.setString(3, admin.getCpf());
            pst.setString(4, admin.getSenha());
            pst.execute();
            pst.close();                
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Administrador procurarAdm(String nome) {
        String sql = "SELECT * FROM administrador WHERE nome LIKE ? ORDER BY nome,cpf";
        
        ArrayList<Administrador> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet rs;
        
        Administrador admin = new Administrador();
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                admin.setNome(rs.getString("nome"));
                admin.setCpf(rs.getString("cpf"));
                admin.setEmail(rs.getString("email"));
                admin.setSenha(rs.getString("senha"));
                lista.add(admin);
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return admin;
    }

    @Override
    public Administrador acesso(String email, String password) {
        String sql = "SELECT * FROM administrador WHERE email = ? AND senha = md5(?)";
        Administrador admin = new Administrador();
        
        PreparedStatement pst;
        ResultSet st;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            st = pst.executeQuery();
            
            while (st.next()) {
                admin.setCpf(st.getString("cpf"));
                admin.setNome(st.getString("nome"));
                admin.setEmail(st.getString("email"));
                admin.setSenha(st.getString("senha"));
            }
            
            st.close();
            pst.close();
            
        }catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return admin;
    }

    @Override
    public Administrador findByEmail(String email) {
        String sql = "SELECT * FROM administrador WHERE email LIKE ? ORDER BY email,nome";
        
        Administrador adm = new Administrador();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, "%" + email + "%");
            rs = pst.executeQuery();
            
            while(rs.next()){
                adm.setEmail(rs.getString("email"));
                adm.setNome(rs.getString("nome"));
                adm.setCpf(rs.getString("cpf"));
                adm.setSenha(rs.getString("senha"));
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return adm;
    }

    @Override
    public void alterarSenha(Administrador admin) {
        String sql = "UPDATE administrador SET senha = md5(?) WHERE email LIKE ?";
        
        PreparedStatement pst;
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, admin.getSenha());
            pst.setString(2, admin.getEmail());
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
}
