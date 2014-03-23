package com.eladio.formularios;

import javax.swing.JComponent;

import org.springframework.richclient.form.AbstractForm;
import org.springframework.richclient.form.binding.BindingFactory;
import org.springframework.richclient.form.builder.TableFormBuilder;

import com.eladio.beans.UsuarioBean;

/**
 * Clase formulario que da soporte al diálogo LoginDialog.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class LoginForm extends AbstractForm {

	/**
	 * Constructor con parámetros.
	 * 
	 * @param usuario El UsuarioBean.
	 */
	public LoginForm(UsuarioBean usuario) {
		super(usuario);
		this.setId("usuario");
	}
	
	/**
	 * Crea un <code>TableFormBuilder</code> para el login.
	 */
	@Override
	protected JComponent createFormControl() {
		BindingFactory bf = this.getBindingFactory();
		TableFormBuilder tableForm = new TableFormBuilder(bf);
		
		tableForm.addSeparator("Login");
		tableForm.row();
		
		tableForm.add("user");
		tableForm.row();
		
		tableForm.add("password");
		tableForm.row();
		
		return tableForm.getForm();
	}

}
