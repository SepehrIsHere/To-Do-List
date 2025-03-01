package org.practice.simpletodo.service;

import org.practice.simpletodo.dto.TaskDTO;
import org.practice.simpletodo.dto.TaskRequestDTO;
import org.practice.simpletodo.dto.UserDto;
import org.practice.simpletodo.entities.Task;
import org.practice.simpletodo.entities.TaskPriority;
import org.practice.simpletodo.entities.TaskStatus;

import java.util.List;

public interface TaskService {
    TaskDTO save(TaskRequestDTO requestDto);

    TaskDTO update(TaskRequestDTO requestDto);

    void deleteById(Long id);

    void delete(Task task);

    List<Task> findByTaskName(String name);

    Task findById(Long id);

    List<Task> findByPriority(TaskPriority priority,Long userId);

    List<Task> findByStatus(TaskStatus status,Long userId);

    List<Task> findByUser(Long userId);

    List<Task> findAll();

    void deleteAll();

}
