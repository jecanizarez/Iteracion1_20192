package epsAndes.main;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import epsAndes.persistencia.PersistenciaEpsAndes;

public class Main 
{
	// Attributes
	
	/**
	 * The project's controller.
	 */
	private static Controller controller;
	
	

	/**
	 * Starts the project.
	 * @param args Arguments.
	 */
	public static void main(String[] args) 
	{
		controller = new Controller();
		controller.run();
		
	}

	   
}
