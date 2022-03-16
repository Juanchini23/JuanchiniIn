package com.JuanchiniIn.service;

import java.util.*;

import com.JuanchiniIn.model.Categoria;

public interface ICategoriaService {

	void guardar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);
	void eliminar(Integer idCategoria);
	
}
