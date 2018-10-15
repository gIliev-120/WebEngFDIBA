package com.fdiba.web.eng.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="username" ,nullable=false)
	private String username;
	@Column(name="firstName",nullable=false)
	private String firstName;
	@Column(name= "lastName",nullable=false)
	private String lastName;
	@Column(name ="password",nullable=false)
	private String password;


	public UserModel() {
		
	}
	
	public UserModel(String username, String firstName, String lastName, String password) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + "]";
	}
	
	
	
		
	
}
