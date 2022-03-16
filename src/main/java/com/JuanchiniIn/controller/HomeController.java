package com.JuanchiniIn.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JuanchiniIn.model.Perfil;
import com.JuanchiniIn.model.Usuario;
import com.JuanchiniIn.model.Vacante;
import com.JuanchiniIn.service.IUsuariosService;
import com.JuanchiniIn.service.IVacanteService;

@Controller
public class HomeController {

	@Autowired
	private IVacanteService serviceVacantes;
	
	@Autowired
	private IUsuariosService serviceUsuarios;

	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "formRegistro";
	}
	
	@PostMapping("/signup") // aca es cuan
	public String guardarRegistro(Usuario usuario,RedirectAttributes attributes) {

		usuario.setEstatus(1); // Activado por defecto
		usuario.setFechaRegistro(new Date()); // Fecha de Registro, la fecha actual del servidor
		
		// Creamos el Perfil que le asignaremos al usuario nuevo
		Perfil perfil = new Perfil();
		perfil.setId(3); // Perfil USUARIO
		usuario.agregar(perfil);
		
		serviceUsuarios.guardar(usuario);
		attributes.addFlashAttribute("msg","Usuario guardada");
		System.out.println(usuario.toString());
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);

		return "tabla";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Programador Java");
		vacante.setDescripcion("Se necesita programador junior Java");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		model.addAttribute("vacante", vacante);
		return "detalle";
	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Programador Java");
		lista.add("Programador JavaScript");
		lista.add("Programador fullstack");
		model.addAttribute("empleos", lista);

		return "listado";
	}
	
	

	@GetMapping("/")
	public String mostrarHome(Model model) {

		return "home";
	}

	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("vacantes", serviceVacantes.buscarDestacadas());
	}

}
