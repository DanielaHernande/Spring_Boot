package com.example.tareas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.tareas.entity.Task;
import com.example.tareas.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository objTaskRepository;

    public List<Task> findAll() {
        return this.objTaskRepository.findAll();
    }

    public Page<Task> findPagination(int page, int size) {

        if (page < 0) {
            page = 0;
        }

        Pageable objPage = PageRequest.of(page, size);

        return this.objTaskRepository.findAll(objPage);
    }

    public Task create(Task objTask) {
        return this.objTaskRepository.save(objTask);
    }

    
   
}
