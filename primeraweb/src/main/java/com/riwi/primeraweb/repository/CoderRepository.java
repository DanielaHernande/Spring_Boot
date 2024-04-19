package com.riwi.primeraweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.primeraweb.entity.Coder;

// Extendemos de la interfaz de JPA para obtener todos los metodos del CRUD
@Repository
public interface CoderRepository extends JpaRepository<Coder, Long>{

    /*
     *  El repositorio se encargad de toda la persistencia de los datos
     *  Interactua directamente con la Base de datos.
     */

     /**
      * Recibe dos parametros el primero el de la entidad a la cual le haremos
      el CRUD Y el segundo parametro es el tipo de dato de la llave primaria
      */
    
}
