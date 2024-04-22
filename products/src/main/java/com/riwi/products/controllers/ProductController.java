package com.riwi.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.products.entities.Products;
import com.riwi.products.services.abstract_service.IProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private final IProductService objIProductService;

    @GetMapping
    /* @ResponseEntity lo utilizamos para responder con los status htto */
    public ResponseEntity<List<Products>> getAll() {

        /* @ResponseEntity.ok significa que todo salio bien*/
        return ResponseEntity.ok(this.objIProductService.getAll());
        
    }
    
}
