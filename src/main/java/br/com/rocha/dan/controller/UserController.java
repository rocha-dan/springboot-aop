package br.com.rocha.dan.controller;

import br.com.rocha.dan.annotation.LogExecutionTime;
import br.com.rocha.dan.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "groupId", required = false) String groupId) {
        List<User> usersResponse = List.of(new User("João"));
        return ResponseEntity.ok(usersResponse);
    }

    @LogExecutionTime
    @GetMapping("/user")
    public ResponseEntity<User> getUser() {
        User user = new User("João");
        return ResponseEntity.ok(user);
    }

}
