package edu.usal.vista.consola;


import java.util.List;
import java.util.Scanner;

import edu.usal.negocio.dominio.Cliente;
import edu.usal.util.IOGeneral;

public class VistaCliente {
	private  Scanner sc ;
public VistaCliente(){


}
	public int menu() {
		System.out.println("");
		System.out.println("1-Agregar Cliente");
		System.out.println("2-Todos Los Clientes");
		System.out.println("3-Eliminar Cliente");
		System.out.println("4-Salir");
		return IOGeneral.leerInt("Ingrese una opcion", "Solo numeros");

	}
	
	
	
	public Cliente AltaCliente() {
		
		
		
		Cliente cliente = new Cliente();
		
		cliente.setNombreYApellido(IOGeneral.leerLinea("Ingrese nombre y apellido: "));
		cliente.setDni(IOGeneral.leerLinea("Ingrese Dni: "));


		
		
		return cliente;
		
		
		
	}

	public String eliminarCliente() {


		String dni  =  IOGeneral.leerLinea("Ingrese el dni del cliente que desea eliminar");

return dni ;

	}


	public void imprimirTodos(List<Cliente> listado) {

		for(Cliente cliente : listado) {
			
			System.out.println(
			"Nombre y apellido: "+ cliente.getNombreYApellido() +
			", Dni: " + cliente.getDni()
			+ " || "	);
			
			
			
			//Agregar todos los getters...
			
		}
		
	}


	public void mensaje(String mensaje) {
		System.out.println(mensaje);
	}
}

