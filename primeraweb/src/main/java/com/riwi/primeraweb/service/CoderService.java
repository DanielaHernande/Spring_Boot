package com.riwi.primeraweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.repository.CoderRepository;

@Service
public class CoderService {

    /*
     * @Autowired Registra la inyeccion de dependencia en Spring Boot solo 
     * sirve para inyeccion de dependencias
     */

    @Autowired
    private CoderRepository objCoderRepository;

    public List<Coder> findAll() {

        /*
         * Capa de negocio 
         */
        return this.objCoderRepository.findAll();
    }


    /*
     * Metodo para crear un nuevo coder, se hace uso del repositorio y del metodo save,
     * el cual se encarga de insertar en la bse de datos
     */
    public Coder create(Coder objCoder) {

        return this.objCoderRepository.save(objCoder);
    }
    
}
