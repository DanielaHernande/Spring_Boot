package com.riwi.vacants.utils.exceptions;

/*
 * RuntimeException es la clase geeral de errores en java 
 * La utilizaremos para implementat su constructor en esta clase y generar 
 * el error personalizado
 */
public class IdNotFoundException extends RuntimeException{
    
    private static final String ERROR_MESSAGE = "No hay registros en la entidad %s con el id suministado";

    /*
     * Utilizamos el constructor de RuntimeException y enviamos el mensaje
     * Inyectando el nombre de la entidad
     */

    // Constructor
    public IdNotFoundException(String nameEntity) {

        super(String.format(ERROR_MESSAGE, nameEntity));
    }
}
