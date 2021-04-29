package com.trabajadores.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajadores.bean.Trabajador;

public interface ITrabajadorDao extends JpaRepository<Trabajador, Integer>{

}
