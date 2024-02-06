package com.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserVo> addUser(UserVo user) {
        return new ResponseEntity<UserVo>(userService.addUser(user),HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Optional<UserVo>> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserVo>> getUserList() {
        return new ResponseEntity<>(userService.getUserList(), HttpStatus.OK);
    }
}
