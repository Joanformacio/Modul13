package com.trabajadores.bean;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;




@Entity
@Table(name= "treballadors")
public class Trabajador {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty//es necesario agregar la dependency validation
	private String name;
	@NotEmpty
	private String surname;
	@NotEmpty
	@Email
	private String email;
	private String phone;
	private String category;
	private double salary;
	
	public Trabajador(int id,String name, String surname, String email, String phone) {
		this.name=name;
		this.surname=surname;
		this.email=email;
		this.phone=phone;
	
	}
	
	public Trabajador() {
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
