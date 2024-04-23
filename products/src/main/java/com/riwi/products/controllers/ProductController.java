package com.riwi.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // Metodo para bsucar por id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Products> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.objIProductService.getById(id));
    }

    // Metodo para buscar por nombre
    @GetMapping(path = "/search")
    public ResponseEntity<List<Products>> getName(@RequestParam String name) {
        return ResponseEntity.ok(this.objIProductService.search(name));
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<Products> insert(@RequestBody Products objProducts) {
        return ResponseEntity.ok(this.objIProductService.save(objProducts));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Products> update(

        @RequestBody Products objProducts, // Para obtener los datos actualiazados del producto
        @PathVariable Long id) // Obtener el Id que viene en la URL
        {

            objProducts.setId(id);
            return ResponseEntity.ok(this.objIProductService.update(objProducts));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        this.objIProductService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
