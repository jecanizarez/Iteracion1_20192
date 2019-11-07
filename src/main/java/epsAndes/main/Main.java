package epsAndes.main;

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
