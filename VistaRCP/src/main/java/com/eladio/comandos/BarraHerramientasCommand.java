package com.eladio.comandos;

import org.springframework.richclient.command.ActionCommand;

/**
 * @author Carlos Eladio Fernández Ordóñez
 *
 * Clase comando local que irá en la barra de herramientas de la aplicación.
 */
public class BarraHerramientasCommand extends ActionCommand {

	/**
	 * Command Id: barraHerramientasCommand
	 */
	public BarraHerramientasCommand() {
		super("barraHerramientasCommand");
	}
	
	/**
	 * Imprime un mensaje por consola.
	 */
	@Override
	protected void doExecuteCommand() {
		System.out.println("Barra Herramientas Command");
	}

}
