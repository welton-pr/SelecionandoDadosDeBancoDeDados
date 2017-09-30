/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle;

import br.com.dao.ClienteDAO;
import br.com.vo.Cliente;
import java.util.List;

/**
 *
 * @author Laryssa
 */
public class Main {

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClienteDAO cDAO = new ClienteDAO();
        List<Cliente> listaClientes = cDAO.selecionarTodosCliente(0);
        
        for(Cliente c: listaClientes){
            System.out.println("Código "+c.getCodigo()+" Nome "+ c.getNome());
        }
    }
    
}
