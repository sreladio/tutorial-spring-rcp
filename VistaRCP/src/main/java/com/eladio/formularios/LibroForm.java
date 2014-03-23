package com.eladio.formularios;

import javax.swing.JComponent;

import org.springframework.richclient.form.AbstractForm;
import org.springframework.richclient.form.binding.BindingFactory;
import org.springframework.richclient.form.builder.TableFormBuilder;

import com.eladio.beans.LibroBean;

/**
 * Formulario que da soporte al diálogo <code>LibroPropertiesDialog</code> 
 * de la vista <code>VerLibrosVista</code>.
 * 
 * AbstractForm es la base de implementación de los formularios.
 * Implementa los comandos:
 * 	
 * 	- CommitCommand: vuelca los datos al bean que se está editando.
 * 	- RevertCommand: carga el formulario con los datos del bean.
 * 	- NewFormObjectCommand: crea una nueva instancia del modelo.
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
	
	/**
	 * Para crear un componente para un formulario, se utilizan lo <code>FormBuilder's</code>.
	 * Estos crean automáticamente la representación swing del formulario.
	 * Tres tipos de FormBuilder's:
	 * 
	 * 	- GridBagLayoutFormBuilder
	 *  - HtmlFormBuilder
	 *  - TableFormBuilder
	 */
	@Override
	protected JComponent createFormControl() {
		// El bindingFactory genera enlaces (bindings) con las clases del modelo 
		// que tiene enlazado el formulario, en este caso el LibroBean libro.
		BindingFactory bindingFactory = this.getBindingFactory();
		
		// Instanciamos el TableFormBuilder
		TableFormBuilder formBuilder= new TableFormBuilder(bindingFactory);
		
		// Añadimos un separador para notificar que empieza la sección de datos del libro.
		formBuilder.addSeparator("General");
		
		// Añadimos un salto de línea.
		formBuilder.row();
		
		// Añadimos las propiedades del bean. 
		formBuilder.add("titulo");
		formBuilder.add("autor");
		formBuilder.row();
		formBuilder.add("precio");
		formBuilder.row();
		formBuilder.addSeparator("Editorial");
		formBuilder.row();
		formBuilder.add("editorial.nombre");
		formBuilder.add("editorial.pais");
		
		// Una vez configurado el FormBuilder, se retorna el objeto de tipo JComponent.
		return formBuilder.getForm();
	}

}
