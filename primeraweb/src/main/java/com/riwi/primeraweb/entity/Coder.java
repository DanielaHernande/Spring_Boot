package com.riwi.primeraweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 *  Entity le permite a SpringBott que esta calse es una entidad
 */
@Entity

/*
 *  Table permite configurar la tabla que creara wl ORM (HIBERNATE)
 */
@Table(name = "coder")
public class Coder {

    /* Id indica que el atriibuto siguiente será la llave primaria */
    @Id

    /* GeneratedValue Permite que el id sera autoincrementable */
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String clan;
    private int age;

    // Constructor
    public Coder() {
    }

    public Coder(Long id, String name, String clan, int age) {
        this.id = id;
        this.name = name;
        this.clan = clan;
        this.age = age;
    }

    // Metodos getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString
    @Override
    public String toString() {
        return "Coder [id=" + id + ", name=" + name + ", clan=" + clan + ", age=" + age + "]";
    }

}
