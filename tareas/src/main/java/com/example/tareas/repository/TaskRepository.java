package com.example.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tareas.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
