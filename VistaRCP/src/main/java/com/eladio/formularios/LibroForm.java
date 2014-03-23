package com.eladio.formularios;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.springframework.richclient.form.AbstractForm;

import com.eladio.beans.LibroBean;

/**
 * Formulario que da soporte al diálogo <code>LibroPropertiesDialog</code> 
 * de la vista <code>VerLibrosVista</code>.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class LibroForm extends AbstractForm {

	/**
	 * Constructor con parámetros.
	 * 
	 * @param libro El LibroBean.
	 */
	public LibroForm(LibroBean libro) {
		super(libro);
		super.setId("libro");
	}
	
	@Override
	protected JComponent createFormControl() {
		return new JPanel();
	}

}
