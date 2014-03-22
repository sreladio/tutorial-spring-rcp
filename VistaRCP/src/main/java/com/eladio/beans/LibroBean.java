package com.eladio.beans;

/**
 * Clase que contiene la información de una entidad de domínio Libro.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class LibroBean {
	
	private String titulo;
	private String autor;
	private EditorialBean editorial;
	private Float precio;
	
	/**
	 * Constructor por defecto.
	 */
	public LibroBean() {}
	
	/**
	 * Constructor con parámetros.
	 * 
	 * @param titulo Título del libro.
	 * @param autor Autor del libro.
	 * @param editorialBean Ediorial del libro.
	 * @param precio Precio del libro.
	 */
	public LibroBean(String titulo, String autor, EditorialBean editorial, Float precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.precio = precio;
	}

	/**
	 * Devuelve el título del libro.
	 * 
	 * @return El título del libro.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el título del libro.
	 * 
	 * @param tituo El título del libro.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Devuelve el autor del libro.
	 * 
	 * @return El autor del libro.
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Establece el autor del libro.
	 * 
	 * @param autor El autor del libro.
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * Devuelve la editorial del libro.
	 * 
	 * @return La editorial del libro.
	 */
	public EditorialBean getEditorial() {
		return editorial;
	}

	/**
	 * Establece la editorial del libro.
	 * 
	 * @param editorialBean La editorial del libro.
	 */
	public void setEditorial(EditorialBean editorial) {
		this.editorial = editorial;
	}

	/**
	 * Devuelve el precio del libro.
	 * 
	 * @return El precio del libro.
	 */
	public Float getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del libro.
	 * 
	 * @param precio El precio del libro.
	 */
	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibroBean other = (LibroBean) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
}
