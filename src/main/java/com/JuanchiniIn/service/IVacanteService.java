package com.JuanchiniIn.service;

import java.util.List;
import com.JuanchiniIn.model.Vacante;

public interface IVacanteService {

	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer id);
	void guardar(Vacante vacante);
	List<Vacante> buscarDestacadas();
	void eliminar(Integer idELiminar);
}
