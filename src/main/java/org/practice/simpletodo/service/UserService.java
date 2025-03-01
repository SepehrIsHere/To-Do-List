package org.practice.simpletodo.service;

import org.practice.simpletodo.dto.UserDto;
import org.practice.simpletodo.dto.UserRequestDto;
import org.practice.simpletodo.entities.User;

import java.util.List;

public interface UserService {
    UserDto save(UserRequestDto requestDto);

    UserDto update(UserRequestDto requestDto);

    void deleteById(Long id);

    void delete(User user);

    User findByUsername(String username);

    User findByEmail(String email);

    User findById(Long id);

    List<User> findAll();

    void deleteAll();

}
