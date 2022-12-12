package com.jrla.springboot.di.app.models.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
//@RequestScope
public class Cliente {

	@Value("${cliente.nombre}")
	private String nombre;
	
	@Value("${cliente.apellido}")
	private String Apellido;

	@PostConstruct
	public void inicializar() {
		System.out.println("Se crea el cliente: ".concat(this.nombre));
	}
	
	@PreDestroy
	public void destruir() {
		System.out.println("Se elimina el cliente: ".concat(this.nombre));
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

}
