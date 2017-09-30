/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laryssa
 */
public class Conexao {
    static Connection con = null;
 
    
    public static Connection conectar(){
        try{
           if(con == null || con.isValid(0) == false){
               Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.
                       getConnection("jdbc:mysql://127.0.0.1/aulas", "teste", "123456");
               System.out.println(con.isValid(0));
           } 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return con;
    }
    
    
    public static void desconectar(){
        try{
            con.close();
            System.out.println(con.isValid(0));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void desconectaPst(PreparedStatement pst){
        try{
            pst.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void desconectaSt(Statement st){
        try{
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void desconectaResult(ResultSet res){
        try{
            res.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    } 
}
