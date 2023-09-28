package br.com.ifba.SmartWaste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.ifba.SmartWaste.dao.IAdminDAO;
import br.com.ifba.SmartWaste.model.Administrador;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private IAdminDAO adminDAO;

    @GetMapping("/")
    public String index() {
        //"nomedocontroller/nomedaação"
        return "login/telaLogin";
    }

    @PostMapping("/logar")
    public String logar(Model model, Administrador admin) {
        Administrador adm = this.adminDAO.checkLogin(admin.getCpf(), admin.getSenha());
        if(adm!=null) {
            return "/principal/telaPrincipal";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/telaLogin";
    }

    @GetMapping("/telaCadastro.html")
    public String abrirTelaCadastro(){
        return "/cadastro/telaCadastro.html";
    }

}
