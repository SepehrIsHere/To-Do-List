package org.practice.simpletodo.repository;

import org.practice.simpletodo.entities.Task;
import org.practice.simpletodo.entities.TaskStatus;
import org.practice.simpletodo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.name = :name")
    Optional<List<Task>> findByName(@Param("name") String name);

    @Query("SELECT t FROM Task t WHERE t.id = :id")
    Optional<List<Task>> findByUser(@Param("id") Long id);

    @Query("SELECT t FROM Task t WHERE t.user.id = : id AND t.priority = :LOW")
    Optional<List<Task>> findLowPriorityTask(@Param("id") Long id);

    @Query("SELECT t FROM Task t WHERE t.user.id = : id AND t.priority = :MEDIUM")
    Optional<List<Task>> findMediumPriorityTask(@Param("id") Long id);

    @Query("SELECT t FROM Task t WHERE t.user.id = : id AND t.priority = :HIGH")
    Optional<List<Task>> findHighPriorityTask(@Param("id") Long id);

    @Query("SELECT t FROm Task t WHERE t.user.id = : id AND t.priority = :URGENT")
    Optional<List<Task>> findUrGentPriorityTask(@Param("id") Long id);

    @Query("SELECT t FROM Task t WHERE t.user.id = :id AND  t.status = :COMPLETED")
    Optional<List<Task>> findCompleteTasks(@Param("id") Long id);

    @Query("SELECT t FROM Task t WHERE t.user.id = :id AND  t.status = :IN_PROGRESS")
    Optional<List<Task>> findInProgressTasks(@Param("id") Long id);

    @Query("SELECT t FROM Task t WHERE t.user.id = :id AND  t.status = :FAILED")
    Optional<List<Task>> findFailedTasks(@Param("id") Long id);

    Long user(User user);

    Long user(User user);
}
    