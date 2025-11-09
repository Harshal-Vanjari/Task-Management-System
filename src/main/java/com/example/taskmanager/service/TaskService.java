package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    //CREATE
    Task createTask(Task task);

    //READ (get all)
    List<Task> getAllTasks();

    //READ (get by id)
    Optional<Task> getTaskById(Long id);

    //Update
    Task updateTask(Long id, Task updatedTask);

    //DELETE
    void deleteTask(Long id);
}
