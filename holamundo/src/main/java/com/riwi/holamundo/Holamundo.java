package com.riwi.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Indica que esta clase será un controlador (@Controller)
@Controller
// @RequestMapping crea la ruta basepara acceder al controlador
@RequestMapping("/controller")
public class Holamundo {

    // @GetMapping crea la ruta especifica donde se disparará el metodo
    @GetMapping("/saludar")
    // @ResponseBody permite responder en formato texto o json
    @ResponseBody
    public String mostrarMensasje() {

        return "Hola Mundo";
    }
    
}
