package com.bharath.socialmedia.api.controllers;

import com.bharath.socialmedia.core.exceptions.UserNotFoundException;
import com.bharath.socialmedia.core.models.User;
import com.bharath.socialmedia.core.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}")
    public User fetchUser(@PathVariable String userId) {
        User user = userService.fetchUserById(userId);
        if(user == null) {
          throw new UserNotFoundException(String.format("User with id %s not found", userId));
        }
        return user;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        String userId = userService.createUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(userId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

}
