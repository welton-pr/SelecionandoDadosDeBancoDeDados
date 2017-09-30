/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.persistencia.Conexao;
import br.com.vo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laryssa
 */
public class ClienteDAO {
    
    public int insert(Cliente c){
        PreparedStatement pst = null;
        int resultado = 0;
        try{
            Connection con = Conexao.conectar();
            String sql = " insert into cliente (codigo, nome, email, nascimento) "
                    + " values (?,?,?,?)";
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, c.getCodigo());
            pst.setString(2, c.getNome());
            pst.setString(3, c.getEmail());
            pst.setTimestamp(4, c.getNascimento());
            resultado = pst.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexao.desconectaPst(pst);
            Conexao.desconectar();
        }
        return resultado;
    }

 
    public int update(Cliente c){
        PreparedStatement pst = null;
        int resultado = 0;
        try{
            Connection con = Conexao.conectar();
            String sql = " update cliente set nome = ?, email = ?, nascimento = ? "
                    + " where codigo = ?";
            
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getEmail());
            pst.setTimestamp(3, c.getNascimento());
            pst.setInt(4, c.getCodigo());
            resultado = pst.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexao.desconectaPst(pst);
            Conexao.desconectar();
        }
        return resultado;
    }
    
    
    public Cliente selecionarCliente(int codigo){
        Statement s = null;
        ResultSet rs = null;
        Cliente c = null;
        try{
            Connection con = Conexao.conectar();
            String sql = " select * from cliente where codigo = "+codigo;
            
            s = con.createStatement();
            rs = s.executeQuery(sql);
            if(rs.next()){
                c = new Cliente();
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setNascimento(rs.getTimestamp("nascimento"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexao.desconectaResult(rs);
            Conexao.desconectaSt(s);
            Conexao.desconectar();
        }
        return c;
    }
    
    public List<Cliente> selecionarTodosCliente(int codigo){
        Statement s = null;
        ResultSet rs = null;
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        try{
            Connection con = Conexao.conectar();
            String sql = " select * from cliente";
            
            s = con.createStatement();
            rs = s.executeQuery(sql);
            while(rs.next()){
                Cliente c = new Cliente();
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setNascimento(rs.getTimestamp("nascimento"));
                listaCliente.add(c);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexao.desconectaResult(rs);
            Conexao.desconectaSt(s);
            Conexao.desconectar();
        }
        return listaCliente;
    } 
    
    
}
