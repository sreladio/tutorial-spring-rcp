package com.eladio.vistas;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.richclient.application.support.AbstractView;

/**
 * @author Carlos Eladio Fernández Ordóñez
 *
 * Vista principal que se mostrará al iniciar la aplicación.
 */
public class StartingAppView extends AbstractView {

	@Override
	protected JComponent createControl() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Bienvenido a mi aplicación SRCP"));
		panel.add(new JLabel("¡Hola!"));
				
		return panel;
	}

}
