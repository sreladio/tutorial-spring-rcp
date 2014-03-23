package com.eladio.beans;

public class UsuarioBean {

	private String user;
	private String password;
	
	/**
	 * Constructor por defecto.
	 */
	public UsuarioBean() { }

	/**
	 * Devuelve el user.
	 * 
	 * @return El user.
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Establece el user.
	 * 
	 * @param user El user.
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Devuelve la password.
	 * 
	 * @return La password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establece la password.
	 * 
	 * @param password La password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
