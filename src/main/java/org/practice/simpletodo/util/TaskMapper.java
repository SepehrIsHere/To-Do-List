package org.practice.simpletodo.util;

import org.practice.simpletodo.dto.TaskDTO;
import org.practice.simpletodo.dto.TaskRequestDTO;
import org.practice.simpletodo.entities.Task;
import org.springframework.stereotype.Component;


@Component
public class TaskMapper {

    public Task convertToEntity(TaskDTO taskDTO) {
        if (taskDTO == null) {
            throw new IllegalArgumentException("TaskDTO cannot be null");
        }

        return Task.builder()
                .id(taskDTO.getId())
                .name(taskDTO.getName())
                .priority(taskDTO.getPriority())
                .status(taskDTO.getStatus())
                .build();
    }

    public TaskDTO convertToTaskDTO(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        return TaskDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .priority(task.getPriority())
                .status(task.getStatus())
                .build();
    }

    public Task convertToEntity(TaskRequestDTO taskRequestDTO) {
        if (taskRequestDTO == null) {
            throw new IllegalArgumentException("TaskRequestDTO cannot be null");
        }

        return Task.builder()
                .name(taskRequestDTO.getTitle()) // Map title to name
                .description(taskRequestDTO.getDescription())
                .priority(taskRequestDTO.getPriority())
                .status(taskRequestDTO.getStatus())
                .startedDate(taskRequestDTO.getStartDate())
                .dueDate(taskRequestDTO.getEndDate())
                .build();
    }
}