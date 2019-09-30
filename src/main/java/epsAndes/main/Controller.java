package epsAndes.main;

import java.util.Scanner;

public class Controller 
{
	// Attributes
	
	// Methods
	
	/**
	 * Method that runs the project's console input and output.
	 */
	public static void run()
	{
		Scanner sc = new Scanner(System.in);
		boolean end = false;
		while(!end)
		{
			ControllerView.printMenuLogin();
			String login = sc.nextLine();
			// Acá hiría la QUERY de pedir login y luego se hace switch para roles.
		}
	}
}
