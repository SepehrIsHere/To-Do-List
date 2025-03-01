package org.practice.simpletodo.controller;

import lombok.RequiredArgsConstructor;
import org.practice.simpletodo.dto.TaskDTO;
import org.practice.simpletodo.dto.TaskRequestDTO;
import org.practice.simpletodo.entities.Task;
import org.practice.simpletodo.entities.TaskPriority;
import org.practice.simpletodo.entities.TaskStatus;
import org.practice.simpletodo.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/save")
    public ResponseEntity<TaskDTO> save(TaskRequestDTO requestDTO) {
        return ResponseEntity.ok(taskService.save(requestDTO));
    }

    @PatchMapping("/update")
    public ResponseEntity<TaskDTO> update(TaskRequestDTO requestDTO) {
        return ResponseEntity.ok(taskService.update(requestDTO));
    }

    @GetMapping("/find-by-status")
    public ResponseEntity<List<Task>> findByStatus(TaskStatus status, Long userId) {
        return ResponseEntity.ok(taskService.findByStatus(status, userId));
    }

    @GetMapping("/find-by-priority")
    public ResponseEntity<List<Task>> findByPriority(TaskPriority priority, Long userId) {
        return ResponseEntity.ok(taskService.findByPriority(priority, userId));
    }

    @GetMapping("/find-by-user")
    public ResponseEntity<List<Task>> findByUser(Long userId) {
        return ResponseEntity.ok(taskService.findByUser(userId));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteById(@RequestParam Long id) {
        taskService.deleteById(id);
        return ResponseEntity.ok("Deleted task with id " + id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody Task task) {
        taskService.delete(task);
        return ResponseEntity.ok("Deleted task with id " + task.getId());
    }

}
