package com.riwi.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.products.entities.Products;
import com.riwi.products.repositories.ProductRepository;
import com.riwi.products.services.abstract_service.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService{

    // Inyeccion de dependencias
    // Cuando creamos final hay que crear un constructor @AllArgsConstructor
    // final es una constante 
    @Autowired
    private final ProductRepository objProductRepository;

    @Override
    public Products save(Products objProducts) {
        return this.objProductRepository.save(objProducts);
    }

    @Override
    public List<Products> getAll() {
        return this.objProductRepository.findAll();
    }

    @Override
    public Products getById(Long id) {
        return this.objProductRepository.findById(id).orElseThrow();     
    }

    @Override
    public void delete(Long id) {

        Products products = this.objProductRepository.findById(id).orElseThrow();

        this.objProductRepository.delete(products);
    
    }

    @Override
    public Products update(Products objProducts) {
        return this.objProductRepository.save(objProducts);
    }

    @Override
    public List<Products> search(String name) {
        return this.objProductRepository.findByName(name);
    }
    
    
}
