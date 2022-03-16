package com.JuanchiniIn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.JuanchiniIn.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
                                                          //Clase, tipo de dato del Id		
	
}
