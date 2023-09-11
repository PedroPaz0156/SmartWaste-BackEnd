/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.dao;

import br.com.ifba.smartwaste.model.Conexao;
import br.com.ifba.smartwaste.model.Ponto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class PontoDAO implements IPontoDAO{

    @Override
    public int criarPonto(Ponto ponto) {
        String sql = "INSERT * INTO ponto (endereco, ultimacoleta, ocupacaomedia) VALUES (?, ?, ?)";
        
        PreparedStatement pst;
        ResultSet st;
        int lastId = 0;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, ponto.getEndereco());
            pst.setDate(2, (Date) ponto.getUltimaColeta());
            pst.setFloat(3, ponto.getOcupacaoMedia());
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
        return lastId;
    }

    @Override
    public void editarPonto(Ponto ponto) {
        String sql = "UPDATE ponto SET endereco = ?, ultimacoleta = ?, ocupacaomedia = ?, lixeiras = ? WHERE id = ?";
        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, ponto.getEndereco());
            pst.setDate(2, (Date) ponto.getUltimaColeta());
            pst.setFloat(3, ponto.getOcupacaoMedia());
            pst.setInt(5, ponto.getIdPonto());
            pst.execute();
            pst.close();
            
        }catch(SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public boolean deletarPonto(Ponto ponto) {
        String sql = "DELETE FROM ponto WHERE id = ?";
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, ponto.getIdPonto());
            pst.execute();
            pst.close();
        }catch(SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }

    @Override
    public Ponto procurarPonto(int id) {
        String sql = "SELECT * FROM ponto WHERE id = ?";
        
        Ponto ponto = new Ponto();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            if(rs.next()){
                ponto.setIdPonto(rs.getInt("id"));
                ponto.setEndereco(rs.getString("Endereco"));
                ponto.setOcupacaoMedia(rs.getFloat("ocupacaomedia"));                
                ponto.setUltimaColeta(rs.getDate("ultimacoleta"));                
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return ponto;
    }

    @Override
    public Ponto findByEndereco(String endereco) {
        String sql = "SELECT * FROM ponto WHERE endereco = ?";
        
        Ponto ponto = new Ponto();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, endereco);
            rs = pst.executeQuery();
            
            if(rs.next()){
                ponto.setIdPonto(rs.getInt("id"));
                ponto.setEndereco(rs.getString("Endereco"));
                ponto.setOcupacaoMedia(rs.getFloat("ocupacaomedia"));                
                ponto.setUltimaColeta(rs.getDate("ultimacoleta"));
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return ponto;
    }

    public int nextId() {
        String sql = "SELECT AUTO_INCREMENT AS ID FROM INFORMATION_SCHEMA.TABLES " +
                "WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?";
        
        int id = 0;
        PreparedStatement pst;
        ResultSet st;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, "smartwaste");
            pst.setString(2, "ponto");
            st = pst.executeQuery();
            
            if(st.next()) {
                id = st.getInt("ID");
            }
            st.close();
            pst.close();
            
        }catch(SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

}
