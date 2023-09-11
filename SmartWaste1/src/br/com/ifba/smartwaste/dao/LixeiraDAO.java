/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.smartwaste.dao;

import br.com.ifba.smartwaste.model.Conexao;
import br.com.ifba.smartwaste.model.Lixeira;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class LixeiraDAO implements ILixeiraDAO{

    @Override
    public int criarLixeira(Lixeira lixeira) {
        String sql = "INSERT * INTO lixeira (tipo, ocupacao, idsensor) VALUES (?, ?, ?)";
        
        PreparedStatement pst;
        ResultSet st;
        int lastId = 0;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, lixeira.getTipo());
            pst.setFloat(2, lixeira.getOcupacao());
            pst.setInt(3, lixeira.getIdSensor());
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
    public void atualizarLixeira(Lixeira lixeira) {
        String sql = "UPDATE ponto SET tipo = ?, ocupacao = ?, idsensor = ? WHERE id = ?";
        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, lixeira.getTipo());
            pst.setFloat(2, lixeira.getOcupacao());
            pst.setInt(3, lixeira.getIdSensor());
            pst.setInt(4, lixeira.getIdLixeira());
            pst.execute();
            pst.close();
            
        }catch(SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deletarLixeira(Lixeira lixeira) {
        String sql = "DELETE FROM lixeira WHERE id = ?";
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, lixeira.getIdLixeira());
            pst.execute();
            pst.close();
        }catch(SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Lixeira pesquisarLixo(int id) {
        String sql = "SELECT * FROM lixeira WHERE id = ?";
        
        Lixeira lixeira = new Lixeira();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            if(rs.next()){
                lixeira.setIdLixeira(rs.getInt("id"));
                lixeira.setTipo(rs.getString("tipo"));
                lixeira.setOcupacao(rs.getFloat("ocupacao"));                
                lixeira.setIdSensor(rs.getInt("idsensor"));
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lixeira;
    }
    
}
