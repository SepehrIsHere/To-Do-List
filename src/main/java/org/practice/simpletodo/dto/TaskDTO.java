package org.practice.simpletodo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.practice.simpletodo.entities.TaskPriority;
import org.practice.simpletodo.entities.TaskStatus;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private Long id;
    private String name;
    private TaskPriority priority;
    private TaskStatus status;

}
