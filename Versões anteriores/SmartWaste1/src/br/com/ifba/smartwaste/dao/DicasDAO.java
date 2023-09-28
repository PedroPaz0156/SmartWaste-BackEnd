/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.dao;

import br.com.ifba.smartwaste.model.Conexao;
import br.com.ifba.smartwaste.model.Dicas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DicasDAO implements IDicaDAO{

    @Override
    public void inserir(Dicas dica) {
        String sql = "INSERT INTO dicas (dica) VALUES (?);";
        
        PreparedStatement pst;
        ResultSet st;
        int lastId = 0;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, dica.getDica());
            pst.execute();
            st = pst.getGeneratedKeys();
            
            if(st.next()) {
               lastId = st.getInt("id"); 
            }
            pst.close();
            st.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void alterar(Dicas dica) {
        String sql = "UPDATE dicas SET dica = ? WHERE id = ?;";
        
        PreparedStatement pst;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, dica.getDica());
            pst.setInt(2, dica.getId());
            pst.execute();
            pst.close();

        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deletar(Dicas dica) {
        String sql = "DELETE * FROM dicas WHERE id = ?;";
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, dica.getId());
            pst.execute();
            pst.close();
        }catch(SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Dicas procurar(int id) {
        String sql = "SELECT * FROM dicas WHERE id = ?;";
        
        Dicas dica = new Dicas();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            if(rs.next()){
                dica.setId(rs.getInt("id"));
                dica.setDica(rs.getString("dica"));
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return dica;
    }

    @Override
    public ArrayList<Dicas> listar() {
        String sql = "SELECT * FROM dicas ORDER BY id, dica;";
        
        ArrayList<Dicas> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Dicas dica = new Dicas();
                dica.setId(rs.getInt("id"));
                dica.setDica(rs.getString("dica"));
                lista.add(dica);
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return lista;  
    }
    
}
