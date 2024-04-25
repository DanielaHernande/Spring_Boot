package com.riwi.vacants.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //@Column(length = 40, nullable = false) es para indicarle la cantidad y si el null o no, false es que es obligatorio ponerlo
    @Column(length = 40, nullable = false)
    private String name;

    private String location;

    @Column(length = 14, nullable = false)
    private String contact;

    /* @OneToMany - Uno a Muchos = una empresa puede tener muchas vacantes*/ 
    /*  mappedBy para saber el nombre del atributo que va a guardar
     * especificamos donde se guardara informacion de la relacion
     * 
     * fetch = FetchType.EAGER es un Join implicito  
     * fetch = FetchType.LAZY es un Join perezoso
     * 
     * orphanRemoval = TRUE remover objeto huerfano (sin llave foranea) 
    */
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    /*@ToString.Exclude es para que no incluya el toString 
     * 
    */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vacant> vacants;
    
}
