package epsAndes.main;

public class ControllerView 
{
	// Methods
	
	/**
	 * Prints the main login menu.
	 */
	public static void printMenuLogin()
	{
		print("------- ISIS 2304 Iteracion 1 2019-20 --------");
		print("--- Daniel del Castillo A. y Juan E. Canizarez");
		print("----------------------------------------------");
		print("Ingrese su login (genericos, 'admin1' para rol Admin,");
		print("'gerente1' para rol Gerente, 'med1' para rol Medico,");
		print("'afil1' para rol Afiliado y 'recep1' para rol Recepcionista).");
		print("-------------------------------------------------------------");
		print("No ingrese comillas sencillas o dobles:\n");
	}
	
	/**
	 * Menu asigned to the user rol 1.
	 */
	public static void printMenuAfiliado()
	{
		print("--------------------------------------------------");
		print("Ingrese el numero de la accion que desea ejecutar:");
		print("1. Reservar una cita de servicio de salud");
		print("0. Salir del programa");
	}
	
	/**
	 * Menu asigned to the user rol 2.
	 */
	public static void printMenuMedico()
	{
		print("--------------------------------------------------");
		print("Ingrese el numero de la accion que desea ejecutar:");
		print("1. Registrar una orden de servicio de salud");
		print("0. Salir del programa");
	}
	
	/**
	 * Menu asigned to the user rol 3.
	 */
	public static void printMenuRecepcionista()
	{
		print("--------------------------------------------------");
		print("Ingrese el numero de la accion que desea ejecutar:");
		print("1. Registrar la prestación de un servicio de salud");
		print("0. Salir del programa");
	}
	
	/**
	 * Menu asigned to the user rol 4.
	 */
	public static void printMenuAdministrador()
	{
		print("--------------------------------------------------");
		print("Ingrese el numero de la accion que desea ejecutar:");
		print("1. Registrar roles");
		print("2. Registrar IPS");
		print("3. Registrar Medico");
		print("4. Registrar Afiliado");
		print("5. Registrar Servicio de salud");
		print("6. Mostrar los 20 servicios mas solicitados");
		print("0. Salir del programa");
	}
	
	/**
	 * Prints any String.
	 * @param string The String to print.
	 */
	public static void print(String string)
	{ System.out.println(string); }
}
