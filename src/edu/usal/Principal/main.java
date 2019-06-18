package edu.usal.Principal;

import java.io.IOException;

import edu.usal.controlador.consola.ControladorCliente;
import edu.usal.vista.consola.VistaCliente;

public class main {

	public static void main(String[] args) throws IOException {

		VistaCliente vista = new VistaCliente();
		ControladorCliente controladorCli = new ControladorCliente(vista);
		
		controladorCli.MostrarMenu();
		
	}

}
