package com.eladio.aop;

import org.springframework.richclient.application.config.DefaultApplicationLifecycleAdvisor;
import org.springframework.richclient.command.support.ExitCommand;

import com.eladio.beans.UsuarioBean;
import com.eladio.beans.UsuariosBean;
import com.eladio.dialogos.LoginDialog;

/**
 * @author Carlos Eladio Fernández Ordóñez
 *
 * Clase que mediante AOP gestionará la aplicación en los diferentes cilos
 * de la misma, commonStartup, onClose, ...
 */
public class ApplicationLifecycleAdvisor extends DefaultApplicationLifecycleAdvisor {

	private UsuariosBean usuarios;
	
	public ApplicationLifecycleAdvisor() {
		super();
	}
	
	public UsuariosBean getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(UsuariosBean usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public void onPostStartup() {
		System.out.println("Inicializando");
		UsuarioBean usuario = new UsuarioBean();
    	new LoginDialog(usuario).showDialog();
    	System.out.println(usuario.getUser()+","+usuario.getPassword());
    	
    	for ( UsuarioBean var:usuarios.getUsuarios())
    	{
    		if ( usuario.getUser().equals(var.getUser())&& usuario.getPassword().equals(var.getPassword()))
    			return;
    	}
    	
    	new ExitCommand().execute();	
	}
}
