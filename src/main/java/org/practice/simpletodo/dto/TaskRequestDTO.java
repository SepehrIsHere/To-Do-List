package org.practice.simpletodo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.practice.simpletodo.entities.TaskPriority;
import org.practice.simpletodo.entities.TaskStatus;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {
    private String title;
    private String description;
    private TaskPriority priority;
    private TaskStatus status;
    private LocalDate startDate;
    private LocalDate endDate;

}
