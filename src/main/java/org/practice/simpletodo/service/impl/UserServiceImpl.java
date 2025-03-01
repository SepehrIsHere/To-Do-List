package org.practice.simpletodo.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.practice.simpletodo.dto.UserDto;
import org.practice.simpletodo.dto.UserRequestDto;
import org.practice.simpletodo.entities.User;
import org.practice.simpletodo.exception.InvalidUserValues;
import org.practice.simpletodo.exception.UserNotFoundException;
import org.practice.simpletodo.exception.UserOperationException;
import org.practice.simpletodo.repository.UserRepository;
import org.practice.simpletodo.service.UserService;
import org.practice.simpletodo.util.UserMapper;
import org.practice.simpletodo.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ValidationUtil validationUtil;

    @Override
    public UserDto save(UserRequestDto requestDto) {
        try {
            User user = userMapper.convertToEntity(requestDto);
            if (validationUtil.isValid(user)) {
                userRepository.save(user);
                return userMapper.convertToDTO(user);
            } else {
                throw new InvalidUserValues("User has some invalid value or values");
            }
        } catch (Exception e) {
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public UserDto update(UserRequestDto requestDto) {
        try {
            User user = userMapper.convertToEntity(requestDto);
            userRepository.save(user);
            return userMapper.convertToDTO(user);
        } catch (Exception e) {
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(User user) {
        try {
            userRepository.delete(user);
        } catch (Exception e) {
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User by username " + username + " not found"));
        } catch (Exception e) {
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User by email : " + email + " not found"));
        } catch (Exception e) {
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public User findById(Long id) {
        try {
            return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " not found"));
        } catch (Exception e) {
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public List<User> findAll() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        try {
            userRepository.deleteAll();
        } catch (Exception e) {
            throw new UserOperationException(e.getMessage());
        }
    }
}
