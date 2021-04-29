package com.trabajadores.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import com.trabajadores.bean.Categoria;
import com.trabajadores.dao.ICategoriaDao;


public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	 private ICategoriaDao tCategoria;
	@Override
	public ArrayList<Categoria> getCategorias() {
		
		 return (ArrayList<Categoria>) tCategoria.findAll();
	}

}
