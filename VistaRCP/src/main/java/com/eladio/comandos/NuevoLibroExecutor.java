package com.eladio.comandos;

import org.springframework.richclient.command.ActionCommandExecutor;

/**
 * @author Carlos Eladio Fernández Ordóñez
 *
 * Clase Executor que se utilizará para asociarlo al commando global 
 * 'propertiesCommand' de la vista 'StartingAppView'.
 */
public class NuevoLibroExecutor implements ActionCommandExecutor {

	/**
	 * Imprime un mensaje por consola
	 */
	@Override
	public void execute() {
		System.out.println("Comando Nuevo Libro");
	}

}
