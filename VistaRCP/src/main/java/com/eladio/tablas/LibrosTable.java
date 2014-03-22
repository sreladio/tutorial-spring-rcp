package com.eladio.tablas;

import org.springframework.richclient.table.support.AbstractObjectTable;

import com.eladio.beans.LibreriaBean;

/**
 * Clase que extiende de AbstractObjectTable para renderizar una tabla de libros.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class LibrosTable extends AbstractObjectTable {

	private LibreriaBean libreria;
	
	/**
	 * Constructor con parámetros. Llama al constructor de AbstractObjectTable
	 * con los parámetros:
	 * 
	 * 	- Id (identificador de la tabla)
	 *  - Propiedades de los beans que maneje la tabla (autor = getAutor())
	 * 
	 * @param libreriaBean El LibreriaBean.
	 */
	public LibrosTable(LibreriaBean libreria) {
		super("libros", new String[]{"titulo", "autor", "editorial.nombre", "editorial.pais", "precio"});
		this.libreria = libreria;
	}

	/**
	 * 
	 */
	@Override
	protected Object[] getDefaultInitialData() {
		return libreria.obtenerTodosLosLibros();
	}

	/**
	 * Devuelve el bean LibreriaBean.
	 * @return El LibreriaBean.
	 */
	public LibreriaBean getLibreria() {
		return this.libreria;
	}
	
	/**
	 * Establece el bean LibreriaBean de donde obtendrá los
	 * datos que se mostrarán en la tabla.
	 * 
	 * @param libreria El LibreriaBean.
	 */
	public void setLibreria(LibreriaBean libreria) {
		this.libreria = libreria;
	}
}
