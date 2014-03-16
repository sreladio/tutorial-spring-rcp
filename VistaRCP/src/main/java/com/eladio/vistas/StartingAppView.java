package com.eladio.vistas;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.richclient.application.PageComponentContext;
import org.springframework.richclient.application.support.AbstractView;
import org.springframework.richclient.command.ActionCommandExecutor;
import org.springframework.richclient.command.support.GlobalCommandIds;

import com.eladio.comandos.NuevoLibroExecutor;

/**
 * @author Carlos Eladio Fernández Ordóñez
 *
 * Vista principal que se mostrará al iniciar la aplicación.
 */
public class StartingAppView extends AbstractView {

	private ActionCommandExecutor nuevoLibroExecutor = new NuevoLibroExecutor();
	
	/**
	 * Añade los componentes a la vista
	 */
	@Override
	protected JComponent createControl() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Bienvenido a mi aplicación SRCP"));
		panel.add(new JLabel("¡Hola!"));
				
		return panel;
	}
	
	/**
	 * Este método es invocado cuando se inicializa el contenedor.
	 * 
	 * Registra en el contexto de la vista la implementación específica del
	 * comando global 'properties' que queremos asociar a la vista.
	 * 
	 * Los ID's de los comandos globales predefinidos están declarados en la
	 * clase: GlobalCommandIds
	 * 
	 * @param context Contexto de la aplicación (Vista actual).
	 */
	@Override
	protected void registerLocalCommandExecutors(PageComponentContext context) {
		// Asociamos el nuevo ejecutor al comando
		context.register(GlobalCommandIds.PROPERTIES, this.nuevoLibroExecutor);
	}
}
