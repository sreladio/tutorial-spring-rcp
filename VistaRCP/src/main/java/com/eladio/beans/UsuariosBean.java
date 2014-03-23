package com.eladio.beans;

import java.util.Collection;

/**
 * Clase que contiene una colección de usuarios UsuarioBean.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class UsuariosBean {

	private Collection<UsuarioBean> usuarios;
	
	/**
	 * Constructor por defecto.
	 */
	public UsuariosBean() { }
	
	/**
	 * Devuelve un array de Strings con los usuarios de UsuarioBean.
	 * @return Los usuarios del bean.
	 */
	public Object[] getAllUsuarios() {
		return this.usuarios.toArray();
	}
	
	/**
	 * Devuelve la colección de usuarios, <code>UsuarioBean</code>.
	 * 
	 * @return La colección de UsuarioBean.
	 */
	public Collection<UsuarioBean> getUsuarios() {
		return this.usuarios;
	}
	
	/**
	 * Establece la colección de UsuarioBean.
	 * 
	 * @param usuarios La colección de UsuarioBean.
	 */
	public void setUsuarios(Collection<UsuarioBean> usuarios) {
		this.usuarios = usuarios;
	}
}
