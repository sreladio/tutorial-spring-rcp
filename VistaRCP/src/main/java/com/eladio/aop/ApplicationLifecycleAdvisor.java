package com.eladio.aop;

import org.springframework.richclient.application.config.DefaultApplicationLifecycleAdvisor;

/**
 * @author Carlos Eladio Fernández Ordóñez
 *
 * Clase que mediante AOP gestionará la aplicación en los diferentes cilos
 * de la misma, commonStartup, onClose, ...
 */
public class ApplicationLifecycleAdvisor extends DefaultApplicationLifecycleAdvisor {

	public ApplicationLifecycleAdvisor() {
		super();
	}
}
