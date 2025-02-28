package org.practice.simpletodo.util;

import org.practice.simpletodo.dto.UserDto;
import org.practice.simpletodo.dto.UserRequestDto;
import org.practice.simpletodo.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto convertToDTO(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }

    public User convertToEntity(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("UserDto cannot be null");
        }

        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .build();
    }

    public User convertToEntity(UserRequestDto userRequestDto) {
        if (userRequestDto == null) {
            throw new IllegalArgumentException("UserRequestDto cannot be null");
        }

        return User.builder()
                .fullName(userRequestDto.getFullName())
                .username(userRequestDto.getUsername())
                .password(userRequestDto.getPassword())
                .email(userRequestDto.getEmail())
                .build();
    }
}