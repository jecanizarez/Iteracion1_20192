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
		print("'afil1' para rol Afiliado, 'recep1' para rol Recepcionista ");
		print("o 'org1' para el rol de Organizador de campaña).");
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
		print("1. [RF8] Reservar una cita de servicio de salud");
		print("0. Salir del programa");
	}
	
	/**
	 * Menu asigned to the user rol 2.
	 */
	public static void printMenuMedico()
	{
		print("--------------------------------------------------");
		print("Ingrese el numero de la accion que desea ejecutar:");
		print("1. [RF7] Registrar una orden de servicio de salud");
		print("0. Salir del programa");
	}
	
	/**
	 * Menu asigned to the user rol 3.
	 */
	public static void printMenuRecepcionista()
	{
		print("--------------------------------------------------");
		print("Ingrese el numero de la accion que desea ejecutar:");
		print("1. [RF9] Registrar la prestación de un servicio de salud");
		print("0. Salir del programa");
	}
	
	/**
	 * Menu asigned to the user rol 4.
	 */
	public static void printMenuAdministrador()
	{
		print("--------------------------------------------------------------------------------------------------------------------");
		print("Ingrese el numero de la accion que desea ejecutar:");
		print("1. [RF1] Registrar roles");
		print("2. [RF3] Registrar IPS");
		print("3. [RF4] Registrar Medico");
		print("4. [RF5] Registrar Afiliado");
		print("5. [RF6] Registrar Servicio de salud");
		print("6. [RFC2] Mostrar los 20 servicios mas solicitados");
		print("7. [RFC1] Mostrar la cantidad de servicios prestados por cada IPS durante un periodo de tiempo y en el año corrido.");
		print("8. [RFC3] Mostrar el índice de uso de cada uno de los servicios provistos.");
		print("9. [RFC4] Dar servicios con capacidad mayor a una capacidad.");
		print("10. [RFC5] Mostrar la utilización de servicios de EPSAndes por un afiliado dado en un rango de fechas indicado.");
		print("11. [RF12] Deshabilitar servicios de salud.");
		print("12. [RF13] Registrar la reapertura de servicios de salud.");
		print("13. [RFC6] Analizar la operación de EPSAndes.");
		print("14. [RFC7] Encontrar los afiliados exigentes.");
		print("15. [RFC8] Encontrar los servicios que no tienen mucha demanda.");
		print("16. [RFC9] Consultar la prestación de servicios en EPSAndes.");
		print("0. Salir del programa");
	}
	
	public static void printMenuOrganizador()
	{
		print("--------------------------------------------------");
		print("Ingrese el numero de la accion que desea ejecutar:");
		print("1. [RF10] Registrar Campaña");
		print("2. [RF11] Cancelar Campaña");
		print("0. Salir del programa");
	}
	
	/**
	 * Prints any String.
	 * @param string The String to print.
	 */
	public static void print(String string)
	{ System.out.println(string); }
}
