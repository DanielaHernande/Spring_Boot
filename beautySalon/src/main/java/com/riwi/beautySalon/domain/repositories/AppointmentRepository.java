package com.riwi.beautySalon.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.riwi.beautySalon.domain.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    


    @Query(value = "select a from appointment a join fetch a.client c.id = :idClient")
    Optional<Appointment> findByClientId(Long idClient);
}
