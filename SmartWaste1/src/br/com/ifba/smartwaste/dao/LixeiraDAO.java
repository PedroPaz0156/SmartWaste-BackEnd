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
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class LixeiraDAO implements ILixeiraDAO{

    @Override
    public boolean criarLixeira(Lixeira lixeira) {
        String sql = "INSERT INTO lixeira (tipo, tamanho, existe, idponto) VALUES (?, ?, ?, ?)";
        
        PreparedStatement pst;
        ResultSet st;
        int lastId = 0;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, lixeira.getTipo());
            pst.setFloat(2, lixeira.getTamanho());
            pst.setBoolean(3, lixeira.isReal());
            pst.setInt(4, lixeira.getIdPonto());
            pst.execute();
            st = pst.getGeneratedKeys();
            
            if(st.next()) {
               lastId = st.getInt("idlixeira"); 
            }
            pst.close();
            st.close();
            
            return true;
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public boolean atualizarLixeira(Lixeira lixeira) {
        String sql = "UPDATE lixeira SET tipo = ?, ocupacao = ?, existe = ?, idponto WHERE idlixeira = ?";
        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, lixeira.getTipo());
            pst.setFloat(2, lixeira.getOcupacao());
            pst.setBoolean(3, lixeira.isReal());
            pst.setInt(4, lixeira.getIdPonto());
            pst.setInt(5, lixeira.getIdLixeira());
            pst.execute();
            pst.close();
            
            return true;
        }catch(SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public boolean deletarLixeira(Lixeira lixeira) {
        String sql = "DELETE FROM lixeira WHERE idlixeira = ?";
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, lixeira.getIdLixeira());
            pst.execute();
            pst.close();
            
            return true;
        }catch(SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public Lixeira pesquisarLixo(int id) {
        String sql = "SELECT * FROM lixeira WHERE idlixeira = ?";
        
        Lixeira lixeira = new Lixeira();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            if(rs.next()){
                lixeira.setIdLixeira(rs.getInt("idlixeira"));
                lixeira.setTipo(rs.getString("tipo"));
                lixeira.setOcupacao(rs.getFloat("ocupacao")); 
                lixeira.setExiste(rs.getBoolean("existe"));
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lixeira;
    }
    
    @Override
    public ArrayList<Lixeira> findByIdPonto(int idPonto) {
        String sql = "SELECT * FROM lixeira WHERE idponto LIKE ? ORDER BY idponto,tipo";
        
        ArrayList<Lixeira> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, "%" + idPonto + "%");
            rs = pst.executeQuery();
            
            while(rs.next()){
                Lixeira lixo = new Lixeira();
                lixo.setIdPonto(Integer.parseInt(rs.getString("idponto")));
                lixo.setIdLixeira(Integer.parseInt(rs.getString("idlixeira")));
                lixo.setMedida(Float.parseFloat(rs.getString("medida")));
                lixo.setOcupacao(Float.parseFloat(rs.getString("ocupacao")));
                lixo.setTamanho(Float.parseFloat(rs.getString("tamanho")));
                lixo.setTipo(rs.getString("tipo"));
                lixo.setExiste(Boolean.parseBoolean(rs.getString("existe")));
                lista.add(lixo);
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return lista;
    }
}
