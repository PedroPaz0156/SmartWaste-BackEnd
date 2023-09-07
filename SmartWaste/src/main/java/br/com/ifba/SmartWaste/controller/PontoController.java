/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.SmartWaste.controller;

import br.com.ifba.SmartWaste.model.PontoDeColeta;
import br.com.ifba.SmartWaste.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pedro Augusto
 */
@RestController
public class PontoController {
    
    @Autowired
    private PontoRepository pr;
    
    @RequestMapping("/pontos")
    public ModelAndView listaPontos() {
        ModelAndView modelView = new ModelAndView("inserir html aqui");
        Iterable<PontoDeColeta> pontos = pr.findAll();
        modelView.addObject("pontos", pontos);
        return modelView;
    }
    
    @RequestMapping("/cadastrar_ponto")
    public String cadastrar(PontoDeColeta ponto) {
        pr.save(ponto);
        return "redirect:/cadastrar_ponto";
    }
    
}
