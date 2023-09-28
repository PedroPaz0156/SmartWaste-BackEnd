package br.com.ifba.SmartWaste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.ifba.SmartWaste.dao.IAdminDAO;
import br.com.ifba.SmartWaste.model.Administrador;


@Controller
public class CadastroController {

    @Autowired
    private IAdminDAO adminDAO;
    
    @GetMapping("/telaLogin.html")
    public String voltar(){
        return "/login/telaLogin";
    }

    @PostMapping("/cadastro/cadastrar")
    public String cadastrar(Administrador admin) {
        adminDAO.save(admin);
        return "redirect:/";
    }
}
