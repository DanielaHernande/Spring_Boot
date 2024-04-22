package com.riwi.operations.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.operations.entities.Operations;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationsController {

    // Metodo para sumar dos numeros
    @PostMapping("/add")
    public String sum(@RequestBody Operations objOperations) {

        int num1 = objOperations.getNum1();
        int num2 = objOperations.getNum2();

        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    // Metodo para restar dos numeros
    @PostMapping("/subtract")
    public String subtract(@RequestBody Operations objOperations) {

        int num1 = objOperations.getNum1();
        int num2 = objOperations.getNum2();

        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    // Metodo para multiplicar dos numeros
    @PostMapping("/mutiply")
    public String mutiply(@RequestBody Operations objOperations) {

        int num1 = objOperations.getNum1();
        int num2 = objOperations.getNum2();

        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    // Metodo para dividir dos numeros
    @PostMapping("/divide")
    public String divide(@RequestBody Operations objOperations) {

        double num1 = objOperations.getNum1();
        double num2 = objOperations.getNum2();

        if (num2 == 0) return "No se puede dividir por cero.";

        return num1 + " / " + num2 + " = " + (num1 / num2);
    }

    // Metodo para comparar dos numeros
    @PostMapping("/compare")
    public String compare(@RequestBody Operations objOperations) {

        int num1 = objOperations.getNum1();
        int num2 = objOperations.getNum2();

        if (num1 == num2) return "Los dos numeros son iguales";

        return "Los dos numeros no son iguales";
    }

}
