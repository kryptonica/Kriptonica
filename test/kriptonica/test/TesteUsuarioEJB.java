/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptonica.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.naming.InitialContext;
import kriptonica.ejb.UsuarioRemote;
import kriptonica.models.Usuario;

/**
 *
 * @author Mathe
 */
public class TesteUsuarioEJB {

    public static void main(String[] args) throws Exception {
        InitialContext context = new InitialContext();
        UsuarioRemote ejb = (UsuarioRemote) context.lookup("kriptonica.ejb.UsuarioRemote");
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        Usuario usuario = new Usuario("Matheus Coqueiro Andrade", df.parse("09/05/1995"), "Matheus@gmail.com", "senha");
        ejb.salvar(usuario);
        System.out.println(usuario);
    }
}
