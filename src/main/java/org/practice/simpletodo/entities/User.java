package org.practice.simpletodo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User extends BaseEntity {
    @Column(nullable = false)
    @NotBlank(message = "username cant be blank!")
    private String fullName;

    @Column(unique = true, nullable = false)
    @Email(message = "Email is invalid!")
    @NotBlank(message = "username cant be blank!")
    private String email;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "username cant be blank!")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "password cant be blank!")
    private String password;

    @OneToMany
    private List<Task> tasks;
}
