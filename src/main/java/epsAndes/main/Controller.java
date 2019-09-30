package epsAndes.main;

import java.util.Scanner;

import epsAndes.negocio.*;
import epsAndes.persistencia.PersistenciaEpsAndes;

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
		PersistenciaEpsAndes persistencia = new PersistenciaEpsAndes();
		while(!end)
		{
			ControllerView.printMenuLogin();
			String login = sc.nextLine();
			Usuario usuario = persistencia.darUsuarioPorLogin(login);
			if(usuario == null)
			{
				ControllerView.print("El usuario no existe");
			}
			
			// Acá hiría la QUERY de pedir login y luego se hace switch para roles.
			
		}
	}
}
