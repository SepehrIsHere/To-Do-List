package org.practice.simpletodo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Task extends BaseEntity {
    @Column(nullable = false)
    @NotBlank(message = "task's name cant be blank!")
    private String name;

    private String description;

    @NotNull(message = "Task should have a state ")
    private TaskStatus status;

    @NotNull(message = "Task must have a priority")
    private TaskPriority priority;

    private LocalDate startedDate;

    private LocalDate dueDate;

    @ManyToOne
    private User user;
}
