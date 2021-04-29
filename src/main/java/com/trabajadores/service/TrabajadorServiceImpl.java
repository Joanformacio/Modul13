package com.trabajadores.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.trabajadores.bean.Trabajador;
import com.trabajadores.dao.ITrabajadorDao;



@Service
public class TrabajadorServiceImpl implements TrabajadorService {
	
	@Autowired
	 private ITrabajadorDao db;

	@Override
	@Transactional(readOnly = true)
	public ArrayList<Trabajador> getTrabajadores() {
		
		return (ArrayList<Trabajador>) db.findAll();
	}

	@Override
	@Transactional
	public void insertar(Trabajador trabajador) {
		db.save(trabajador);
		
	}

	@Override
	@Transactional
	public void modificar(Trabajador trabajador) {
		db.save(trabajador);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Trabajador getTrabajador(Trabajador trabajador) {
		
		 return db.findById(trabajador.getId()).orElse(null);
	
	}

	@Override
	@Transactional
	public void borrar(Trabajador trabajador ) {
		
		db.delete(trabajador);;
		
	}
}
