package com.eladio.dialogos;

import org.springframework.richclient.dialog.FormBackedDialogPage;
import org.springframework.richclient.dialog.TitledPageApplicationDialog;
import org.springframework.richclient.form.Form;

import com.eladio.beans.UsuarioBean;
import com.eladio.formularios.LoginForm;

/**
 * Clase diálogo para el login.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class LoginDialog extends TitledPageApplicationDialog {

	private Form usuarioForm;
	
	public LoginDialog(UsuarioBean usuario) {
		this.usuarioForm = new LoginForm(usuario);
		
		// Creamos el FormBackedDialogPage que es el
		// que gestiona el contenido del diálogo.
		FormBackedDialogPage fbdp = new FormBackedDialogPage(usuarioForm);
		
		// Establecemos el DialogPage del diálogo.
		this.setDialogPage(fbdp);
	}
	
	protected void onAboutToShow() {
		@SuppressWarnings("unused")
		UsuarioBean usuario = (UsuarioBean) usuarioForm.getFormModel().getFormObject();
		String title = this.getMessage("login.edit.title");  
		this.setTitle(title);
	}
	
	@Override
	protected boolean onFinish() {
		this.usuarioForm.getFormModel().commit();
		return true;
	}

	protected void onCancel() {
		super.onCancel();
	}
}
