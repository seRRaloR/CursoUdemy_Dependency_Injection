package com.jrla.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
//// >>>> tipos de scopes
// @RequestScope // Por defecto el Scope es Singleton
// @SessionScope // Debe implementar Serializable
@ApplicationScope // Parecido a Singleton pero se almacena en el ServletContext en lugar del ApplicationContext
public class Factura implements Serializable {

	private static final long serialVersionUID = -8532783700521192891L;

	@Autowired
	private Cliente cliente;
	
	@Value("${factura.descripcion}")
	private String descripcion;

	@Autowired
	//@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;

	@PostConstruct
	public void inicializar() {
		System.out.println("Se crea la facutra : ".concat(this.descripcion).concat(" / ".concat(cliente.getNombre())));
		cliente.setNombre(cliente.getNombre().concat(" ").concat("de Todos los Santos"));
		descripcion = descripcion.concat(" del cliente: ".concat(cliente.getNombre()));
	}
	
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida: ".concat(descripcion));
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
