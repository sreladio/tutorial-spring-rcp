package com.eladio.vistas;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.springframework.richclient.application.PageComponentContext;
import org.springframework.richclient.application.support.AbstractView;
import org.springframework.richclient.command.ActionCommand;
import org.springframework.richclient.command.ActionCommandExecutor;
import org.springframework.richclient.command.CommandGroup;
import org.springframework.richclient.command.support.GlobalCommandIds;

import com.eladio.beans.EditorialBean;
import com.eladio.beans.LibreriaBean;
import com.eladio.beans.LibroBean;
import com.eladio.dialogos.LibroPropertiesDialog;
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
	private final String NEW_COMMAND = "newCommand";
	
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
		// Asociamos el ejecutor PropertiesExecute al comando PROPERTIES.
		context.register(GlobalCommandIds.PROPERTIES, new PropertiesExecutor());
		
		// Asociamos el ejecutor NuevoLibroExecutor al comando NEW_COMMAND.
		context.register(this.NEW_COMMAND, new NuevoLibroExecutor());
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
	 * Inner class que implementa el executor <code>NuevoLibroExecutor</code>
	 * para la vista <code>VerLibrosVista</code>
	 */
	private class NuevoLibroExecutor implements ActionCommandExecutor {
		
		@SuppressWarnings("unchecked")
		@Override
		public void execute() {
			// Creamos un nuevo libro en blanco.
			LibroBean nuevoLibro = new LibroBean();
			nuevoLibro.setEditorial(new EditorialBean());
			
			// Le pasamos el nuevo libro al diálogo para que lo muestre.
			new LibroPropertiesDialog(nuevoLibro).showDialog();
			
			// Lo añadimos a la librería.
			libreria.add(nuevoLibro);
			
			// Lo añadimos a la tabla
			librosTable.getBaseEventList().add(nuevoLibro);
		}
	}
	
	/**
	 * Inner class que implementa el executor del <code>commandProperties</code> 
	 * para la vista <code>VerLibrosVista</code>.
	 */
	private class PropertiesExecutor implements ActionCommandExecutor {

		/**
		 * Muestra el diálogo <code>LibroPropertiesDialog</code>.
		 */
		@Override
		public void execute() {
			// Obtenemos el libro seleccionado.
			LibroBean libroSeleccionado = librosTable.getSelectedLibro();
			
			// Creamos el diálogo en sí y lo mostramos.
			new LibroPropertiesDialog(libroSeleccionado).showDialog();
		}
	}
}
