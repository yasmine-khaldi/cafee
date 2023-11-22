package com.example.demo.models;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email =:email")

@NamedQuery(name = "User.getAllUser", query = "SELECT new com.example.demo.wrapper.UserWrapper(u.id, u.name, u.email, u.contactNumber, u.status) from User u where u.role='user'")

@NamedQuery(name = "User.updateStatus", query = "UPDATE User u set u.status =: status where u.id=:id")

@NamedQuery(name = "User.getAllAdmin", query = "SELECT u.email from User u where u.role='admin'")
@NamedQuery(name = "User.getAllUsers", query = "SELECT u from User u where u.role='admin'")

@Data //we worked with this to replace the constructors
@Getter
@Setter
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="user")
public  class User implements Serializable{
	
	private static final long serialVersionUTD = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contactNumber")
	private String contactNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private String status;
	
	@Column(name="role")
	private String role;

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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
	
	
	
	
	
	
	

}
