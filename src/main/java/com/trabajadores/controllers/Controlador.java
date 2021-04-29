package com.trabajadores.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


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
		
		return "modificar";
		
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Trabajador trabajador, Errors errores) {
		if(errores.hasErrors()) {
			return "modificar";
		}
		db.insertar(trabajador);
		return "redirect:/";
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
	
		return "redirect:/";
		
	}
}
