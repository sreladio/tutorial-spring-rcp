package com.eladio.vistas;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.richclient.application.support.AbstractView;

/**
 * Vista VerLibrosVista.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class VerLibrosVista extends AbstractView {

	@Override
	protected JComponent createControl() {
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("Bienvenido a mi aplicación SRCP"));
		panel.add(new JLabel("Hola!"));
		
		return panel;
	}

}
