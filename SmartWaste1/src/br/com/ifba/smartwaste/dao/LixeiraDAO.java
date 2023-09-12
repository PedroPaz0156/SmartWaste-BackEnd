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
    public void criarLixeira(Lixeira lixeira) {
        String sql = "INSERT * INTO lixeira (tipo, ocupacao, idsensor, idponto) VALUES (?, ?, ?, ?)";
        
        PreparedStatement pst;
        ResultSet st;
        int lastId = 0;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, lixeira.getTipo());
            pst.setFloat(2, lixeira.getOcupacao());
            pst.setInt(3, lixeira.getIdSensor());
            pst.setInt(4, lixeira.getIdPonto());
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
    public void atualizarLixeira(Lixeira lixeira) {
        String sql = "UPDATE ponto SET tipo = ?, ocupacao = ?, idsensor = ?, idponto WHERE id = ?";
        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, lixeira.getTipo());
            pst.setFloat(2, lixeira.getOcupacao());
            pst.setInt(3, lixeira.getIdSensor());
            pst.setInt(4, lixeira.getIdPonto());
            pst.setInt(5, lixeira.getIdLixeira());
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
    
    @Override
    public ArrayList<Lixeira> findByIdPonto(int idPonto) {
        String sql = "SELECT * FROM lixeira WHERE idPonto LIKE ? ORDER BY idPonto,tipo";
        
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
                lixo.setIdSensor(Integer.parseInt(rs.getString("idsensor")));
                lixo.setMedida(Integer.parseInt(rs.getString("medida")));
                lixo.setOcupacao(Float.parseFloat(rs.getString("ocupacao")));
                lixo.setTamanho(Float.parseFloat(rs.getString("tamanho")));
                lixo.setTipo(rs.getString("tipo"));
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
