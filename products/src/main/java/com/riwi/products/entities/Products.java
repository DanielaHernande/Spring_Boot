package com.riwi.products.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "product") // Podemos poner el nombre de la tabla en la entidad
@Data // @Data Para crear los set, get y toString
@AllArgsConstructor // Crea un constructor lleno
@NoArgsConstructor // Crea un constructor vacio

public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    private double price;

}
