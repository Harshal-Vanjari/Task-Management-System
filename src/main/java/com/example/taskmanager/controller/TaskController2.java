package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks-v2")
public class TaskController2 {

    @Autowired
    @Qualifier("TaskServiceImpl2")
    private TaskService taskService;

    //CREATE a new task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        // This is deleting
        return taskService.createTask(task);
    }

    //READ all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    //READ one task by ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    //UPDATE a task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    //DELETE a task
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task Deleted Successfully !";
    }
}

//TaskController
