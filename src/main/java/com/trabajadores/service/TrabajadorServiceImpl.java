package com.trabajadores.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabajadores.bean.Categoria;
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
	
	@Override 
	public boolean compruebaUsuario(String usuario, String password){
		boolean check=false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String conex="jdbc:mysql://localhost:3306/dbtreballadors";
			Connection  conexion=DriverManager.getConnection(conex,"root", "joan365");
			Statement s= conexion.createStatement();
			String sql="SELECT count(*) FROM usuarios WHERE usuario='"+usuario+"' "+ "and password= '"+ password+ "'";
			s.execute(sql);
			ResultSet rs= s.getResultSet();
			rs.next();
			
			if(rs.getInt(1)>0) {
				check=true;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return check;
		
	}

	@Override
	public ArrayList<Categoria> getCategorias() {
		ArrayList<Categoria> listCategoria = new ArrayList<Categoria>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String conex="jdbc:mysql://localhost:3306/dbtreballadors";
			Connection  conexion=DriverManager.getConnection(conex,"root", "joan365");
			Statement s= conexion.createStatement();
			String sql="SELECT * FROM categorias";
			s.execute(sql);
			ResultSet rs= s.getResultSet();
			
			while(rs.next()) {
				String categoria=rs.getString(1).toString();
				double salario= rs.getInt(2);
				Categoria c= new Categoria(categoria, salario);
				listCategoria.add(c);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return listCategoria;
	}
	
	
	

}
