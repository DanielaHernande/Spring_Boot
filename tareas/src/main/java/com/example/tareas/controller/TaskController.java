package com.example.tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tareas.entity.Task;
import com.example.tareas.service.TaskService;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskService ojbTaskService;

    @GetMapping
    public String showViewTask(Model objModel) {

        List<Task> listTasks = this.ojbTaskService.findAll();

        objModel.addAttribute("listTasks", listTasks);

        return "viewTasks";
    }

    @GetMapping("form")
    public String showViewForm(Model model) {

        model.addAttribute("task", new Task());
        model.addAttribute("action", "/create-task");

        return "viewForm";

    }
}