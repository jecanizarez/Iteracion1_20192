package epsAndes.main;

public class ControllerView 
{
	// Methods
	
	/**
	 * Prints the main login menu.
	 */
	public static void printMenuLogin()
	{
		print("------- ISIS 2304 Iteraci�n 1 2019-20 --------");
		print("--- Daniel del Castillo A. y Juan E. Ca�izarez");
		print("----------------------------------------------");
		print("Ingrese su login (gen�ricos, 'admin1' para rol Admin,");
		print("'gerente1' para rol Gerente, 'med1' para rol Medico,");
		print("'afil1' para rol Afiliado y 'recep1' para rol Recepcionista).");
		print("No ingrese comillas sencillas o dobles:\n");
	}
	
	public static void printMenuAdministrador()
	{
		System.out.println("Bienvenido administrador");
		System.out.println("1. Registrar roles");
		System.out.println("2. Registrar IPS");
		System.out.println("3. Registrar Medico");
		System.out.println("4. Registrar Afiliado");
		System.out.println("5. Registrar Servicio de salud");
	}
		
	/**
	 * Prints any String.
	 * @param string The String to print.
	 */
	public static void print(String string)
	{ System.out.println(string); }
}
