package com.eladio.comandos;

import org.springframework.richclient.command.ActionCommand;

/**
 * @author Carlos Eladio Fernández Ordóñez
 *
 * Clase comando local que irá en el submenú Ventana de la aplicación.  
 */
public class PruebaCommand extends ActionCommand {

	/**
	 * El String que le pasamos al constructor heredado será el ID del comando.
	 * Será la etiqueta con el que nos referiremos a él en la aplicación.
	 */
	public PruebaCommand() {
		super("pruebaCommand");
	}

	/**
	 * Muestra un mensaje por consola.
	 */
	@Override
	protected void doExecuteCommand() {
		System.out.println("Prueba Command");
	}
}
