package com.trabajadores.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import com.trabajadores.bean.Categoria;
import com.trabajadores.bean.Trabajador;
import com.trabajadores.bean.Usuario;
import com.trabajadores.service.TrabajadorServiceImpl;





@Controller
@RequestMapping("/")
public class Controlador {
	
	Usuario usuario;
	@Autowired
	private TrabajadorServiceImpl db;
	
	
	@GetMapping("/")
	public String inicio(Model model) {
		
		model.addAttribute("titulo", "FORMULARIO DE ACCESO");
		
		return "login";
		
	}
	
	@PostMapping("/")
	public String login(Usuario usuario, Model model) {
		
		if( db.compruebaUsuario(usuario.getNombre(), usuario.getPassword())) {
			this.usuario=usuario;
			ArrayList<Trabajador> trabajadores =db.getTrabajadores();
			
			model.addAttribute("trabajadores", trabajadores);
			model.addAttribute("usuario", this.usuario);
			
			return "index";
		}else {
			return "login";
		}		
	}
	
	@GetMapping("/agregar")
	public String agregar(Trabajador trabajador, Model model) {
		final ArrayList<Categoria> categorias =db.getCategorias();
		System.out.println(categorias.get(0));
		model.addAttribute("categorias", categorias);
		return "modificar";
		
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Trabajador trabajador, Errors errores, Model model) {
		if(errores.hasErrors()) {
			return "modificar";
		}
		db.insertar(trabajador);
		ArrayList<Trabajador> trabajadores =db.getTrabajadores();
		
		model.addAttribute("trabajadores", trabajadores);
		return "index";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(Trabajador trabajador, Model model) {
		trabajador= db.getTrabajador(trabajador);
		
		model.addAttribute("trabajador", trabajador);
		
		return "modificar";
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Trabajador trabajador, Model model) {
		 db.borrar(trabajador);
	
		return "modificar";
		
	}
}
