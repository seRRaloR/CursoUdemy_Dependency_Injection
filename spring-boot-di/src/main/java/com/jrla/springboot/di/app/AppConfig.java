package com.jrla.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.jrla.springboot.di.app.models.domain.ItemFactura;
import com.jrla.springboot.di.app.models.domain.Producto;
import com.jrla.springboot.di.app.models.services.IServicio;
import com.jrla.springboot.di.app.models.services.MiServicio;
import com.jrla.springboot.di.app.models.services.MiServicioComplejo;

@Configuration
public class AppConfig {
	
	/*
	 * Otra forma de inyectar. El método debe devolver un objeto de la interfaz
	 */
	@Bean("miServicioSimple")
	@Primary
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}

	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}
	
	@Bean("itemsFactura")
	@Primary
	public List<ItemFactura> registrarItems() {
		Producto producto1 = new Producto("Cámara Sony", 100);
		Producto producto2 = new Producto("Bicicleta estática", 200);
		
		ItemFactura linea1 = new ItemFactura(producto1, 4);
		ItemFactura linea2 = new ItemFactura(producto2, 45);
		
		return Arrays.asList(linea1, linea2);
	}

	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsOficina() {
		Producto producto1 = new Producto("Monitor 24 pulgadas", 240);
		Producto producto2 = new Producto("Tablet ASUS", 301);
		Producto producto3 = new Producto("Portatil Lenovo", 612);
		Producto producto4 = new Producto("Impresora Multifunción HP", 126);
		Producto producto5 = new Producto("Kit Teclado+Ratón", 78);
		
		ItemFactura linea1 = new ItemFactura(producto1, 8);
		ItemFactura linea2 = new ItemFactura(producto2, 21);
		ItemFactura linea3 = new ItemFactura(producto3, 12);
		ItemFactura linea4 = new ItemFactura(producto4, 3);
		ItemFactura linea5 = new ItemFactura(producto5, 140);
		
		return Arrays.asList(linea1, linea2, linea3, linea4, linea5);
	}
}
