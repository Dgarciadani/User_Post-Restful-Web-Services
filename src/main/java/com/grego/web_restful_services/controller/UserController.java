package com.grego.web_restful_services.controller;

import com.grego.web_restful_services.entity.dto.UserDto;
import com.grego.web_restful_services.service.IUserService;
import com.grego.web_restful_services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDto getUserById( @PathVariable Integer id) {
        return userService.getUserById(id);
    }
    @PostMapping("/")
    public UserDto saveUser(@Valid @RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Integer id, @Valid @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }
    @GetMapping("/")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

}
