package br.com.ifba;

import br.com.ifba.infrastructure.facade.FacadeInstance;
import br.com.ifba.usuario.model.Usuario;

public class MainTest {

    public static void main(String[] args) {
        
//        List<Pessoa> lista = FacadeInstance.getInstance().findAllPessoa();
//        for (Pessoa p : lista) {
//            System.out.println(p.getNome());
//        }   
//        
        Usuario usuario = new Usuario("admin", "admin");
        if(FacadeInstance.getInstance().checkLoginUsuario("admin", "admin")){
            System.out.println("Login Ok");
            System.out.println("Login: " + usuario.getLogin());
            System.out.println("E-mail: " + usuario.getEmail());
        } else{
            System.out.println("Login malsucedido");
        }
    }
    
    
    

}
