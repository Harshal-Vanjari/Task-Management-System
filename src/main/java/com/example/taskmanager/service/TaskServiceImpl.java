package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    //CREATE
    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    //READ (get all)
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    //READ (get by id)
    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    //UPDATE
    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setDueDate(updatedTask.getDueDate());
        return taskRepository.save(task);
    }

    //DELETE
    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
