package com.rajan.employee.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int Id;
	@Column(unique = true)
	private String name;
	private int age;
	private String location;
	private String department;
	private int experience;
	private String dateOfJoining;
	private long phone;
	private String email;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, int age, String location, String department, int experience,
			String dateOfJoining, long phone, String email) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
		this.location = location;
		this.department = department;
		this.experience = experience;
		this.dateOfJoining = dateOfJoining;
		this.phone = phone;
		this.email = email;
	}
	public Employee(String name, int age, String location, String department, int experience, long phone,
			String email) {
		super();
		this.name = name;
		this.age = age;
		this.location = location;
		this.department = department;
		this.experience = experience;
		this.phone = phone;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", age=" + age + ", location=" + location + ", department="
				+ department + ", experience=" + experience + ", dateOfJoining=" + dateOfJoining + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
