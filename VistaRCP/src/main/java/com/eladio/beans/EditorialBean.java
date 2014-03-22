package com.eladio.beans;

/**
 * Clase que contiene la información de una entidad de domínio Editorial.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class EditorialBean {

	private String nombre;
	private String pais;
	
	/**
	 * Constructor por defecto
	 */
	public EditorialBean() {}
	
	/**
	 * Constructor con parámetros.
	 * 
	 * @param nombre Nombre del libro.
	 * @param direccion Dirección del libro.
	 */
	public EditorialBean(String nombre, String pais) {
		this.nombre = nombre;
		this.pais = pais;
	}

	/**
	 * Devuelve el nombre de la editorial.
	 * 
	 * @return El nombre de la editorial.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la editorial.
	 * 
	 * @param nombre El nombre de la editorial.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el país de la editorial.
	 * 
	 * @return El país de la editorial.
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Establece el país de la editorial.
	 * 
	 * @param pais El país de la editorial.
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	/**
	 * Compara dos objetos de tipo EditorialBean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EditorialBean other = (EditorialBean) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
