package com.eladio.vistas;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.springframework.richclient.application.support.AbstractView;

import com.eladio.beans.LibreriaBean;
import com.eladio.tablas.LibrosTable;

/**
 * Vista VerLibrosVista.
 * 
 * @author Carlos Eladio Fernández Ordóñez
 */
public class VerLibrosVista extends AbstractView {

	private LibreriaBean libreria;
	private LibrosTable librosTable;
	
	@Override
	protected JComponent createControl() {
		librosTable = new LibrosTable(libreria);
		
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(librosTable.getControl());
		
		panel.add(scrollPane);
		
		return panel;
	}

	/**
	 * Establece el bean LibreriaBean.
	 * @param libreria El LibreriaBean.
	 */
	public void setLibreria(LibreriaBean libreria) {
		this.libreria = libreria;
	}
}
