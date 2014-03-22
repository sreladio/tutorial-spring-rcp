package com.eladio.vistas;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.richclient.application.PageComponentContext;
import org.springframework.richclient.application.support.AbstractView;
import org.springframework.richclient.command.ActionCommandExecutor;
import org.springframework.richclient.command.support.GlobalCommandIds;

/**
 * Vista MensajesVista.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class MensajesVista extends AbstractView {

	@Override
	protected JComponent createControl() {
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("Hola mundo del SRCP!"));
		
		return panel;
	}
	
	/**
	 * Este método es invocado cuando se inicializa el contenedor.
	 * 
	 * Registra en el contexto de la vista la implementación específica de los
	 * comandos globales <code>copyCommand</code> y <code>cutCommand</code>
	 * haciéndolos comandos locales parra la vista <code>MensajesVista</code>.
	 * 
	 * Los ID's de los comandos globales predefinidos están declarados en la
	 * clase: GlobalCommandIds
	 * 
	 * @param context Contexto de la aplicación (Vista actual).
	 */
	@Override
	protected void registerLocalCommandExecutors(PageComponentContext context) {
		// Asociamos el ejecutor CopiaExecutor al comando COPY
		context.register(GlobalCommandIds.COPY, new CopiaExecutor());
		
		// Asociamos el ejecutor CortarExecutor al comando CUT
		context.register(GlobalCommandIds.CUT, new CortarExecutor());
	}	
	
	/**
	 * Inner class que implementa el executor del <code>copyCommand</code>
	 * para la vista <code>MensajesVista</code>.
	 */
	private class CopiaExecutor implements ActionCommandExecutor {

		/**
		 * Muestra un mensaje por pantalla.
		 */
		@Override
		public void execute() {
			System.out.println("Pulsado COPIAR en la pantall de mensajes");
		}
	}
	
	/**
	 * Inner class que implementa el executor del <code>cutCommand</code>
	 * para la vista <code>MensajesVista</code>.
	 */
	private class CortarExecutor implements ActionCommandExecutor {
		
		/**
		 * Muestra un mensaje por pantalla.
		 */
		@Override
		public void execute() {
			System.out.println("Pulsado CORTAR en la pantalla de mensajes");
		}
	}

}
