package com.JuanchiniIn.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.JuanchiniIn.model.Vacante;
import com.JuanchiniIn.repository.VacantesRepository;
import com.JuanchiniIn.service.IVacanteService;

@Service
@Primary
public class VacantesServiceJpa implements IVacanteService {

	@Autowired
	private VacantesRepository vacantesRepo;

	@Override
	public List<Vacante> buscarTodas() {

		return vacantesRepo.findAll();
	}

	@Override
	public Vacante buscarPorId(Integer id) {

		Optional<Vacante> op = vacantesRepo.findById(id);
		if (op.isPresent()) {
			return op.get();
		}

		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		vacantesRepo.save(vacante);
	}

	@Override
	public List<Vacante> buscarDestacadas() {

		return vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	@Override
	public void eliminar(Integer idELiminar) {
		vacantesRepo.deleteById(idELiminar);
	}
	

}
