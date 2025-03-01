package org.practice.simpletodo.controller;

import lombok.RequiredArgsConstructor;
import org.practice.simpletodo.dto.UserDto;
import org.practice.simpletodo.dto.UserRequestDto;
import org.practice.simpletodo.entities.User;
import org.practice.simpletodo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.save(userRequestDto));
    }

    @PatchMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.update(userRequestDto));
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<User> findUserByName(@RequestParam String userName) {
        return ResponseEntity.ok(userService.findByUsername(userName));
    }

    @GetMapping("/find-by-email")
    public ResponseEntity<User> findUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<User> findUserById(@RequestParam Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAllUsers() {
        userService.deleteAll();
        return ResponseEntity.ok("Deleted all users");
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteUserById(@RequestParam Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Deleted user by id");
    }


}
