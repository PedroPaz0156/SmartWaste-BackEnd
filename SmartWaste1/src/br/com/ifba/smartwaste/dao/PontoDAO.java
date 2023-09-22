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
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class PontoDAO implements IPontoDAO{

    @Override
    public void criarPonto(Ponto ponto) {
        String sql = "INSERT INTO ponto (endereco, ultimacoleta, ocupacaomedia, id) VALUES (?, ?, ?, ?)";
        PreparedStatement pst;
        ResultSet st;
        int lastId = 0;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, ponto.getEndereco());
            pst.setDate(2, (Date) ponto.getUltimaColeta());
            pst.setFloat(3, ponto.getOcupacaoMedia());
            pst.setInt(4, ponto.getIdPonto());
            //NÂO DEVERIA SER ASSIM MAS DEVE FUNCIONAR
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
    public void editarPonto(Ponto ponto) {
        String sql = "UPDATE ponto SET endereco = ?, ultimacoleta = ?, ocupacaomedia = ? WHERE id = ?";
        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, ponto.getEndereco());
            pst.setDate(2, (Date) ponto.getUltimaColeta());
            pst.setFloat(3, ponto.getOcupacaoMedia());
            pst.setInt(4, ponto.getIdPonto());
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

    @Override
    public ArrayList <Ponto> findAll() {
        String sql = "SELECT * FROM ponto";
        
        ArrayList <Ponto> lista = new ArrayList();        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Ponto ponto = new Ponto();
                ponto.setIdPonto(rs.getInt("id"));
                ponto.setEndereco(rs.getString("Endereco"));
                ponto.setOcupacaoMedia(rs.getFloat("ocupacaomedia"));                
                ponto.setUltimaColeta(rs.getDate("ultimacoleta"));
                lista.add(ponto);
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return lista;
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
