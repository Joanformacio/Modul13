package com.trabajadores.service;

import java.util.ArrayList;

import com.trabajadores.bean.*;
public interface TrabajadorService {
	
	public ArrayList<Trabajador> getTrabajadores();
	public void insertar(Trabajador trabajador);
	public void modificar(Trabajador trabajador);
	public Trabajador getTrabajador(Trabajador trabajador);
	public void borrar(Trabajador trabajador);
	public boolean compruebaUsuario( String usuario, String password);
}
