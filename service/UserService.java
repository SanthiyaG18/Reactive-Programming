package com.example.demo.service;

import java.util.List;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelclass.Department;
import com.example.demo.modelclass.User;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service

public class UserService {

    @Autowired(required=true)
    private UserRepository userRepository;
    
    @Autowired
    
    private DepartmentRepository departmentRepository;

	
    public Flux<User> getAllUsers(){
        return userRepository.findAll();
    }
	
	

    public Mono<User> createUser(User user){
        return userRepository.save(user);
    }
    
    public Mono<User> updateUser(Integer userId,  User user){
        return userRepository.findById(userId)
                .flatMap(dbUser -> {
                    dbUser.setName(user.getName());

                    dbUser.setAge(user.getAge());
                    dbUser.setSalary(user.getSalary());
                    return userRepository.save(dbUser);
                });
    }
    public Mono<User> deleteUser(Integer userId){
        return userRepository.findById(userId)
                .flatMap(existingUser -> userRepository.delete(existingUser)
                .then(Mono.just(existingUser)));
    }   




}
   


	

	     

