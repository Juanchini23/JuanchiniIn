package com.JuanchiniIn.service.db;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.*;

import com.JuanchiniIn.model.Categoria;
import com.JuanchiniIn.repository.*;
import com.JuanchiniIn.service.ICategoriaService;


@Service
//@Primary
public class CategoriasServiceJpa implements ICategoriaService {

	@Autowired
	private CategoriasRepository categoriasRepo;
	
	@Override
	public void guardar(Categoria categoria) {
		
		categoriasRepo.save(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		
		return categoriasRepo.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		
		Optional<Categoria> op = categoriasRepo.findById(idCategoria);
		if(op.isPresent()) {
			return op.get();
		}
		
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {

		categoriasRepo.deleteById(idCategoria);
	}

}
