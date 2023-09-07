/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.SmartWaste.service;

import br.com.ifba.SmartWaste.model.Administrador;
import br.com.ifba.SmartWaste.repository.AdminRepository;
import br.com.ifba.SmartWaste.util.ReplyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro Augusto
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private ReplyUtil ru;
    
    //Método de listagem de todas as instâncias de admins
    public Iterable<Administrador> listar() {
        return adminRepository.findAll();
    }
    
    //Método de cadastro
    public Administrador cadastrar(Administrador admin) {
        return adminRepository.save(admin);
    }
    
    //Método de deleção
    public void deletar(String email) {
        Administrador admin;
        admin = adminRepository.findByEmail(email);
        adminRepository.delete(admin);
    }
    
    
    
}
