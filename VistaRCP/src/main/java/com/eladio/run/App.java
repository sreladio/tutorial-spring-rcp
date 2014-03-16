package com.eladio.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.richclient.application.ApplicationLauncher;

/**
 * Clase que lanza la aplicación SRCP
 */
public class App {
	
    public static void main( String[] args ) {
    	final String appContextPath= "context/richclient-application-context.xml";
    	ApplicationContext appCtx= new ClassPathXmlApplicationContext(appContextPath);
    	
    	new ApplicationLauncher(appCtx);
    }
}
