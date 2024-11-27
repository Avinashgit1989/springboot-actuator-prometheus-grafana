package com.learnwithak.userservice.controller;

import com.learnwithak.userservice.model.UserRestModel;
import com.learnwithak.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    public static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserRestModel> createUser(@RequestBody UserRestModel user){
        log.info("User created API Called");
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserRestModel>> getUser(){
        log.info("Get User API Called");
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserRestModel> getUserById(Integer userId ){
        log.info("Get User By Id API Called");
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserRestModel> getUpdateUserById(@RequestBody UserRestModel user,Integer userId ){
        log.info("Update User By Id API Called");
        return new ResponseEntity<>(userService.updateUserById(user,userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> getDeleteUserById(Integer userId ){
        log.info("Delete User By Id API Called");
        return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.OK);
    }

}
