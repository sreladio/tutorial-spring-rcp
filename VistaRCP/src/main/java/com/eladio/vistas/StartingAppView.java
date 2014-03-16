package com.eladio.vistas;

import javax.swing.JComponent;
import javax.swing.JLabel;

import org.springframework.richclient.application.support.AbstractView;

/**
 * @author Carlos Eladio Fernández Ordóñez
 *
 * Vista principal que se mostrará al iniciar la aplicación.
 */
public class StartingAppView extends AbstractView {

	@Override
	protected JComponent createControl() {
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Hola Mundo");
		
		return etiqueta;
	}

}
