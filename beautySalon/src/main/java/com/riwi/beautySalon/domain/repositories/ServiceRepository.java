package com.riwi.beautySalon.domain.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.riwi.beautySalon.domain.entities.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceRepository, Long>{

    /*
     * JPQL trabaja con las entidades de jpa por lo tanto los selects deben ser
     * sobre ellas, ademas que podemos recibir variables a travz del metodo
     */
    @Query(value = "select s from service s where service.price between :min and :max")
    public List<ServiceEntity> selectBetweenPrice(BigDecimal min, BigDecimal max);

    @Query(value = "select s from service s where s.name like :name")
    public List<ServiceEntity> findByNameContainig(String name);
    
}   