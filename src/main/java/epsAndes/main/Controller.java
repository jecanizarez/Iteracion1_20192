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
				// TODO
			}
			else if(usuario.getIdRol() == 1) // Case: afiliado.
			{
				ControllerView.printMenuAfiliado();
				// TODO
			}
			else if(usuario.getIdRol() == 2) // Case: medico
			{
				ControllerView.printMenuMedico();
				// TODO
			}
			else if(usuario.getIdRol() == 3) // Case: recepcionista
			{
				ControllerView.printMenuRecepcionista();
				// TODO
			}
			else if(usuario.getIdRol() == 4) // Case: admin.
			{
				ControllerView.printMenuAdministrador();
				
				int numero = sc.nextInt(); 
				if(numero == 1)
				{
//					System.out.println("Ingrese nombre del rol");
//					String nombre = sc.nextLine(); 
//					persistencia.adicionarRol(nombre);
//					System.out.println("Rol adicionado");
				}
				else if(numero == 2)
				{
//					System.out.println("Ingrese un nombre");
//					String nombre = sc.nextLine();
//					System.out.println("Ingrese una localizacion");
//					String localizacion = sc.nextLine(); 
//					persistencia.adicionarIPS(nombre, localizacion);
//					System.out.println("Se ha añadido la IPS correctamente");
				}
				else if(numero == 3)
				{
					int rolMed = 2;
					System.out.println("Ingrese documento");
					int documento = sc.nextInt(); 
					System.out.println("Ingrese un login");
					String loginMedico = sc.nextLine();
					System.out.println("Ingrese un tipo de documento (TI,CC,CE");
					String tipoDocumento = sc.nextLine();
					int IdtipoDocumento = 0;
					if(tipoDocumento.equalsIgnoreCase("CC"))
					{
						IdtipoDocumento = 1;
					}
					else if(tipoDocumento.equalsIgnoreCase("TI"))
					{
						IdtipoDocumento = 3;
					}
					else if(tipoDocumento.equalsIgnoreCase("CE"))
					{
						IdtipoDocumento = 2;
					}
					else
					{
						System.out.println("Tipo de documento no valido");
					}
					System.out.println("Ingrese un nombre");
					String nombreMedico =  sc.nextLine();
					
					System.out.println("Ingrese numero del registro medico");
					long numRegistroMed = sc.nextLong();
					System.out.println("Ingrese especialidad");
					String especialidad = sc.nextLine(); 
					System.out.println("Ingrese nombre IPS");
					String IPS = sc.nextLine(); 
					IPS ips = persistencia.darIPSPorNombre(IPS);
					long idIPS = 0;
					if (ips != null)
					{
						idIPS = ips.getId();
					}
					else
					{
						System.out.println("La IPS no existe");
					}
					Usuario usuarioMedico = persistencia.adicionarUsuario(loginMedico, documento, rolMed, IdtipoDocumento, nombreMedico, "");
					persistencia.adicionarMedico(loginMedico, documento, rolMed, IdtipoDocumento, nombreMedico, "", numRegistroMed, especialidad, idIPS);
					System.out.println("Se ha adicionado el medico correctamente");
				}
			}
			
			// Acá hiría la QUERY de pedir login y luego se hace switch para roles.
			
		}
	}
}