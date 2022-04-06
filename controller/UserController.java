
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelclass.Department;
import com.example.demo.modelclass.User;
import com.example.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController

public class UserController {
@Autowired(required=true)
private UserService userService;

  

    @GetMapping("/flux")
    public Flux<User> getAllUsers(){
    	System.out.println("helo");
        return userService.getAllUsers();
    }
    @PostMapping("/create")
    public Mono<User> create(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping("/updateuser/{userId}")
    public Mono<ResponseEntity<User>> updateUserById(@PathVariable Integer userId, @RequestBody User user){
        return userService.updateUser(userId,user)
                .map(updatedUser -> ResponseEntity.ok(updatedUser))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
    
    @DeleteMapping("/delete/{userId}")
    public Mono<ResponseEntity<Void>> deleteUserById(@PathVariable Integer userId){
        return userService.deleteUser(userId)
                .map( r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}




