package com.example.demo.modelclass;

import org.springframework.data.annotation.Id;

public class Department {

	 @Id
	    private Integer id;
	    private String name;
	    private Integer userId;
	    private String loc;
	    
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
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getLoc() {
			return loc;
		}
		public void setLoc(String loc) {
			this.loc = loc;
		}
		
}
