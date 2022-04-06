package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.demo.modelclass.Department;

public interface DepartmentRepository extends ReactiveCrudRepository<Department,Integer>{

}
