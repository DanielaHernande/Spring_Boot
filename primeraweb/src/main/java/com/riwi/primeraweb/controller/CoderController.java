package com.riwi.primeraweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.service.CoderService;

@Controller

/* @RequestMapping("/") crea la ruta donde se activara este 
controlador del navegador*/
@RequestMapping("/")
public class CoderController {

    /* EStablece la inyeccion de dependencias */
    @Autowired
    private CoderService objCoderService;

    /* 
     * Metodo para mostrar la vista y enviarle la lista de coders
     */

     @GetMapping
    public String showViewCoder(Model objModel) {

        /* Obtenemos la lista de coders */
        List<Coder> listCoders = this.objCoderService.findAll();

        /* Cargamos la lista en el modelo */
        objModel.addAttribute("listCoders", listCoders); // LLave - Valor
        
        /* Debe de ser igual al nombre de la vista ej html, */
        return "viewCoders";
    }

    /*
     * Metodo para mostrar la vista del formulario y ademas
     * enviar una instancia de Coder vacia
     */
    @GetMapping("form")
    public String showViewForm(Model model) {

        model.addAttribute("coder", new Coder());
        model.addAttribute("action", "/create-coder");
        return "viewForm";
    }

    /*
     * Metodo para recibir toda la informacion del formulario
     *  @ModelAttribute lo utilizamos para recibir informacion de la vista
     */

    @PostMapping("create-coder")
    public String createCoder(@ModelAttribute Coder objCoder) {

        this.objCoderService.create(objCoder);
        return "redirect:/";
    }
}
