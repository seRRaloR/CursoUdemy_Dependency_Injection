package com.jrla.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrla.springboot.di.app.models.services.IServicio;
import com.jrla.springboot.di.app.models.services.MiServicio;

@Controller 
public class IndexController {
	
	// Sin inyección de dependencias = muy acoplado
	/// private MiServicio servicio = new MiServicio();
	
	// Con inyección de dependencias = menos acoplado (aunque todavía algo porque depende de la clase concreta)
	//@Autowired
	//private MiServicio servicio;
	
	// Con inyección de dependencias mediante interface nada acoplado 
	@Autowired
	@Qualifier("miServicioComplejo") // Con esto se le dice que implementación concreta inyectar
	private IServicio servicio;

	/*
	//@Autowired // Se puede omitir cuando se inyecta por constructor
	public IndexController(IServicio servicio) {
		this.servicio = servicio;
	}
	*/


	@GetMapping({"/index","/",""})
	public String index(Model model) {
	
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}

	/*
	@Autowired
	public void setServicio(IServicio servicio) {
		this.servicio = servicio;
	}
	*/


	

}
