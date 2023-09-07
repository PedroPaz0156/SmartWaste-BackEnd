/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.SmartWaste.controller;

import br.com.ifba.SmartWaste.model.Administrador;
import br.com.ifba.SmartWaste.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pedro Augusto
 */
@RestController 
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    @RequestMapping(value="/cadastrar", method=RequestMethod.GET)
    public String form() {
        return "administrador/formAdministrador";
    }
    
    @RequestMapping(value="/cadastrar", method=RequestMethod.POST)
    public String form(Administrador admin) {
        adminService.cadastrar(admin);
        return "redirect:/cadastrarAdmin";
    }
    
    @RequestMapping(value="/deletar", method=RequestMethod.DELETE)
    public String formulario(String email) {
        adminService.deletar(email);
        return "redirect:/deletarAdmin";
    }
    
}
