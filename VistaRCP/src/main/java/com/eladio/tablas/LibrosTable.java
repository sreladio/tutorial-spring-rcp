package com.eladio.tablas;

import org.springframework.richclient.table.support.AbstractObjectTable;

import com.eladio.beans.LibreriaBean;
import com.eladio.beans.LibroBean;

/**
 * Clase que extiende de AbstractObjectTable para renderizar una tabla de libros.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class LibrosTable extends AbstractObjectTable {

	/**
	 * Contiene una colección de beans LibroBean
	 */
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
	 * Devuelve un array con los libros seleccionados en la tabla.
	 * 
	 * @return Array de libros seleccionados.
	 */
	public LibroBean[] getSelectedLibros() {
		// El método getSelectedRows() devuelve los
		// índices de las filas seleccionadas.
		int[] indexOfSelectedRows = getTable().getSelectedRows();
		
		// Creamos una array para almacenar los LibroBean seleccionados.
		LibroBean[] selectedLibros= new LibroBean[indexOfSelectedRows.length];
		
		// Recorremos el array de índices para obtener los LibroBean
		for(int i = 0; i <indexOfSelectedRows.length; i++) {
			selectedLibros[i] = (LibroBean)getTableModel().getElementAt(indexOfSelectedRows[i]);
		}
		
		return selectedLibros;
	}

	/**
	 * Devuelve una sólo LibroBean del array LibroBean que contiene 
	 * los libros que se han seleccionado en la tabla.
	 * 
	 * @return El LibroBean seleccionado.
	 */
	public LibroBean getSelectedLibro()  {
		return getSelectedLibros()[0];
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
