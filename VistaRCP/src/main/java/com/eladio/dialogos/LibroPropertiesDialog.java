package com.eladio.dialogos;

import org.springframework.richclient.dialog.FormBackedDialogPage;
import org.springframework.richclient.dialog.TitledPageApplicationDialog;
import org.springframework.richclient.form.Form;

import com.eladio.beans.LibroBean;
import com.eladio.formularios.LibroForm;


/**
 * Diálogo de la vista <code>VerLibros</code> VerLibrosVista.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class LibroPropertiesDialog extends TitledPageApplicationDialog {

	private Form libroForm;
		
	/**
	 * Constructor conparámetros.
	 * 
	 * @param libro El LibroBean.
	 */
	public LibroPropertiesDialog(LibroBean libro) {
		// Instanciamos el LibroForm con el LibroBean como parámetro.
		this.libroForm = new LibroForm(libro);
		
		// Creamos el FormBackedDialogPage que es el
		// que gestiona el contenido del diálogo.
		FormBackedDialogPage fbdp = new FormBackedDialogPage(libroForm);
		
		// Establecemos el DialogPage del diálogo.
		this.setDialogPage(fbdp);
	}
	
	/**
	 * Construye el mensaje que se va a mostrar en el diálogo
	 * a partir del libro seleccionado en la tabla.
	 */
	@Override
	protected void onAboutToShow() {
		// La tabla nos devuelve la referencia al LibroBean que hemos pulsado.
		LibroBean libro = (LibroBean) libroForm.getFormModel().getFormObject();
		
		// Construimos un mensaje pasándole como parámetros los datos del libro.
		String title = this.getMessage( "libroProperties.edit.title", new Object[]{libro.getTitulo(), libro.getAutor()});
		
		// Lo asociamos al diálogo.
		this.setTitle(title);
	}
	
	/**
	 * Vuelca los datos al bean que se está editando.
	 * En este caso al LibroBean.
	 */
	@Override
	protected boolean onFinish() {
		this.libroForm.getFormModel().commit();
		return true;
	}

	@Override
	protected void onCancel() {
		super.onCancel();
	}
}
