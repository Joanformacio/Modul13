package com.trabajadores.bean;


public class Categoria {
		
	private String categoria;
	private double salario;
	
	
	public Categoria(String categoria, double salario) {
		this.categoria=categoria;
		this.salario=salario;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
