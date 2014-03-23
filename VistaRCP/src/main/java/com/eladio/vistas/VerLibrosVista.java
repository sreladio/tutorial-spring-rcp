package com.eladio.vistas;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.springframework.richclient.application.PageComponentContext;
import org.springframework.richclient.application.support.AbstractView;
import org.springframework.richclient.command.ActionCommand;
import org.springframework.richclient.command.ActionCommandExecutor;
import org.springframework.richclient.command.CommandGroup;
import org.springframework.richclient.command.support.GlobalCommandIds;

import com.eladio.beans.LibreriaBean;
import com.eladio.tablas.LibrosTable;

/**
 * Vista VerLibrosVista. Muestra por pantalla una tabla con los libros disponibles.
 * 
 * Recibe por inyección el bean LibreriaBean que contiene una colección de libros (LibrosBean).
 * Inicializa la tabla LibrosTable con el bean que recibe por inyección.
 * Le añade a la tabla un menú emergente con el comando PROPERTIES.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class VerLibrosVista extends AbstractView {

	private LibreriaBean libreria;
	private LibrosTable librosTable;
	private CommandGroup popPupProperties;
	
	@Override
	protected JComponent createControl() {
		
		// Inicializamos la tabla con el bean LibreriaBean.
		librosTable = new LibrosTable(libreria);
		
		// Creamos un menú emergente contextual para darle funcionalidad a la tabla.
		popPupProperties = new CommandGroup();
		
		// Obtenemos del WindowCommandManager el comando global PROPERTIES.
		ActionCommand commandProperties = (ActionCommand) this.getWindowCommandManager().getCommand(GlobalCommandIds.PROPERTIES, ActionCommand.class);
		
		// Insertamos al menú emergente el comando global PROPERTIES.
		popPupProperties.add(commandProperties);
		
		// Asociamos el menú emergente a la tabla.
		librosTable.setPopupCommandGroup(popPupProperties);
		
		// Establecemos el PropertiesExecutor en el controlador 
		// para el doble click sobre una fila.
		librosTable.setDoubleClickHandler(new PropertiesExecutor());
		
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(librosTable.getControl());
		
		panel.add(scrollPane);
		
		return panel;
	}

	/**
	 * Este método es invocado cuando se inicializa el contenedor.
	 * 
	 * Registra en el contexto de la vista la implementación específica del
	 * comando globale <code>propertiesCommand</code> haciéndolo comando 
	 * local parra la vista <code>VerLibrosVista</code>.
	 * 
	 * Los ID's de los comandos globales predefinidos están declarados en la
	 * clase: GlobalCommandIds
	 * 
	 * @param context Contexto de la aplicación (Vista actual).
	 */
	@Override
	protected void registerLocalCommandExecutors(PageComponentContext context) {
		// Asociamos el ejecutor PropertiesExecute al comando PROPERTIES
		context.register(GlobalCommandIds.PROPERTIES, new PropertiesExecutor());
	}
	
	/**
	 * Establece el bean LibreriaBean.
	 * 
	 * @param libreria El LibreriaBean.
	 */
	public void setLibreria(LibreriaBean libreria) {
		this.libreria = libreria;
	}
	
	/**
	 * Inner class que implementa el executor del <code>commandProperties</code> 
	 * para la vista <code>VerLibrosVista</code>.
	 */
	public class PropertiesExecutor implements ActionCommandExecutor {

		/**
		 * Muestra un mensaje en un diálogo.
		 */
		@Override
		public void execute() {
			JOptionPane.showMessageDialog(null, "Propiedades de la tabla");
		}
	}
}
