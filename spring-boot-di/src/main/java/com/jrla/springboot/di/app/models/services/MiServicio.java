package com.jrla.springboot.di.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
//@Component  
@Service("miServicioSimple")      // diferencia solo semántica ya que un Service es un Component, pero aquí además se indica que 
                                  // es un componente de tipo servicio.
								  // Se le puede dar un nombre para calificarlo a la hora de inyectar, para diferenciarlo de otros que 
                                  // implementan la misma interfaz
@Primary // Con esto se marca esta clase como la que se debe inyectar de todas las que implementan la interfaz
*/
public class MiServicio implements IServicio{
	
	@Override
	public String operacion() {
		return "ejecutando algún proceso importante simple...";
	}

}
