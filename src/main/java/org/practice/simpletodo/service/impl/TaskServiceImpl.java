package org.practice.simpletodo.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.practice.simpletodo.dto.TaskDTO;
import org.practice.simpletodo.dto.TaskRequestDTO;
import org.practice.simpletodo.dto.UserDto;
import org.practice.simpletodo.entities.Task;
import org.practice.simpletodo.entities.TaskPriority;
import org.practice.simpletodo.entities.TaskStatus;
import org.practice.simpletodo.exception.InvalidPriorityException;
import org.practice.simpletodo.exception.InvalidTaskValues;
import org.practice.simpletodo.exception.TaskNotFoundException;
import org.practice.simpletodo.exception.TaskOperationException;
import org.practice.simpletodo.repository.TaskRepository;
import org.practice.simpletodo.service.TaskService;
import org.practice.simpletodo.util.TaskMapper;
import org.practice.simpletodo.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final ValidationUtil validationUtil;

    @Override
    public TaskDTO save(TaskRequestDTO requestDto) {
        Task task = taskMapper.convertToEntity(requestDto);
        if (validationUtil.isValid(task)) {
            taskRepository.save(task);
            return taskMapper.convertToTaskDTO(task);
        } else {
            throw new InvalidTaskValues("Invalid Task Values");
        }
    }

    @Override
    public TaskDTO update(TaskRequestDTO requestDto) {
        try {
            Task task = taskMapper.convertToEntity(requestDto);
            taskRepository.save(task);
            return taskMapper.convertToTaskDTO(task);
        } catch (Exception e) {
            throw new TaskOperationException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new TaskOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Task task) {
        try {
            taskRepository.delete(task);
        } catch (Exception e) {
            throw new TaskOperationException(e.getMessage());
        }
    }

    @Override
    public List<Task> findByTaskName(String name) {
        try {
            return taskRepository.findByName(name).orElseThrow(() -> new TaskNotFoundException("Task by name  " + name + " not found"));
        } catch (Exception e) {
            throw new TaskOperationException(e.getMessage());
        }
    }

    @Override
    public Task findById(Long id) {
        try {
            return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task by id " + id + " not found"));
        } catch (Exception e) {
            throw new TaskOperationException(e.getMessage());
        }
    }

    @Override
    public List<Task> findByPriority(TaskPriority priority, Long userId) {
        try {
            return switch (priority) {
                case LOW ->
                        taskRepository.findLowPriorityTask(userId).orElseThrow(() -> new TaskNotFoundException("Task by priority " + priority + " not found"));
                case MEDIUM ->
                        taskRepository.findMediumPriorityTask(userId).orElseThrow(() -> new TaskNotFoundException("Task by priority " + priority + " not found"));
                case HIGH ->
                        taskRepository.findHighPriorityTask(userId).orElseThrow(() -> new TaskNotFoundException("Task by priority " + priority + " not found"));
                case URGENT ->
                        taskRepository.findUrGentPriorityTask(userId).orElseThrow(() -> new TaskNotFoundException("Task by priority " + priority + " not found"));
            };
        } catch (Exception e) {
            throw new TaskOperationException(e.getMessage());
        }
    }

    @Override
    public List<Task> findByStatus(TaskStatus status, Long userId) {
        try {
            return switch (status) {
                case COMPLETED ->
                        taskRepository.findCompleteTasks(userId).orElseThrow(() -> new TaskNotFoundException("Tasks by status " + TaskStatus.COMPLETED + " not found"));
                case FAILED ->
                        taskRepository.findFailedTasks(userId).orElseThrow(() -> new TaskNotFoundException("Tasks by status " + TaskStatus.FAILED + " not found"));
                case IN_PROGRESS ->
                        taskRepository.findInProgressTasks(userId).orElseThrow(() -> new TaskNotFoundException("Tasks by status " + TaskStatus.IN_PROGRESS + " not found"));
            };
        } catch (Exception e) {
            throw new TaskOperationException(e.getMessage());
        }
    }

    @Override
    public List<Task> findByUser(Long userId) {
        try {
            return taskRepository.findByUser(userId).orElseThrow(() -> new TaskNotFoundException("Task by id " + userId + " not found"));
        } catch (Exception e) {
            throw new TaskOperationException(e.getMessage());
        }
    }

    @Override
    public List<Task> findAll() {
        try {
            return taskRepository.findAll();
        } catch (Exception e) {
            throw new TaskOperationException(e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        try {
            taskRepository.deleteAll();
        } catch (Exception e) {
            throw new TaskOperationException(e.getMessage());
        }
    }
}
