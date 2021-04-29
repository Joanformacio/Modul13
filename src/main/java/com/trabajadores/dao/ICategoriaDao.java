package com.trabajadores.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajadores.bean.Categoria;

public interface ICategoriaDao extends JpaRepository<Categoria, Integer> {

}
