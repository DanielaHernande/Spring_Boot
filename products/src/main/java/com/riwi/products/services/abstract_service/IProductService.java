package com.riwi.products.services.abstract_service;

import java.util.List;

import com.riwi.products.entities.Products;

// No extiende de nadie
/* Utilizamos una interfaz para ser utilizada como inyeccion de dependencias 
   en controlador, mantiene integridad, desacoplamiento y principios SOLID
 */
public interface IProductService {

    public Products save(Products objProducts);

    public List<Products> getAll();

    public Products getById(Long id);

    public void delete(Long id);

    public Products update(Products objProducts);

    public List<Products> search(String name);
    
}
