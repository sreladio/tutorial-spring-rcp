package com.eladio.beans;

import java.util.Collection;
import java.util.HashSet;

/**
 * Clase TODO
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class LibreriaBean {

	private Collection<LibroBean> libreria = new HashSet<LibroBean>();
	
	/**
	 * Constructor por defecto.
	 */
	public LibreriaBean() {
		this.cargarLibreria();
	}
	
	/**
	 * Carga una serie de LibrosBean en el HashSet <code>libreria</code>.
	 */
	private void cargarLibreria() {
		EditorialBean editorialCC = new EditorialBean("Prentice Hall", "USA");
		EditorialBean editorialAJ = new EditorialBean("Auto-Published", "Spain");
		
		this.libreria.add(new LibroBean("Clean Code", "Robert C. Martin", editorialCC, 49.50F));
		this.libreria.add(new LibroBean("Arquitectura Java Sólida", "Cecilio Álvarez Caules", editorialAJ, 0.0F));
	}
	
	/**
	 * Devuelve toda la colección de libros.
	 * 
	 * @return La colección de libros.
	 */
	public Object[] obtenerTodosLosLibros() {
		return this.libreria.toArray();
	}
	
	/**
	 * Añade un LibroBean que se le pasa por parámetro a la
	 * colección <code>libreria</code>
	 * 
	 * @param libro El LibroBean.
	 */
	public void add(LibroBean libro) {
		this.libreria.add(libro);
	}
}
