/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Laryssa
 */
public class Cliente {
    private int codigo;
    private String nome;
    private String email;
    private Timestamp nascimento;

    
    public void setNascimento(String data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            nascimento = new Timestamp(sdf.parse(data).getTime());
        }catch(ParseException e){
            nascimento = null;
        }
    }
    public Timestamp getNascimento() {
        return nascimento;
    }

    public void setNascimento(Timestamp nascimento) {
        this.nascimento = nascimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

      
}
