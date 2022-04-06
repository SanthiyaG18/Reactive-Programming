package com.example.demo.modelclass;

import org.springframework.data.annotation.Id;

public class User {

	@Id
    private Integer id;
    private String name;
    private int age;
    private double salary;
    
    public User() {
    	
    }
	
	  public User(int id, String name, int age, int salary) {
		  this.id=id; 
		  this.name = name; 
		  this.age = age;
		  this.salary = salary;
	  
	  
	  }
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
