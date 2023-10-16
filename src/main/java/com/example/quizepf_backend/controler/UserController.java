package com.example.quizepf_backend.controler;

import com.example.quizepf_backend.DTO.UserDto;
import com.example.quizepf_backend.models.User;
import com.example.quizepf_backend.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServices userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PostMapping("")
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @PostMapping("/{id}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
        userService.updateUser(userDto, id);
    }

    @GetMapping("")
    public List<User> getUsers() {
        return userService.findAll();
    }


}