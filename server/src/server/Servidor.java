package server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import cliente.Mensaje;

public class Servidor {
	
	public final static int PORT = 5000 ;

	Servidor() {
		try {
			
			System.out.println("Servidor....up");
			ServerSocket sock = new ServerSocket(PORT);
			
			do{

				Socket cliente = sock.accept();
	
				InputStream entrada = cliente.getInputStream();
				OutputStream salida = cliente.getOutputStream();
				
				ObjectInputStream entradaObjetos = new ObjectInputStream (entrada);
				ObjectOutputStream salidaObjetos = new ObjectOutputStream (salida);
				
				//recivo el mensaje
				Mensaje recivido = null ;
				Object aux;
				aux = entradaObjetos.readObject();// Se lee el objeto
				
				if (aux instanceof Mensaje) // Se comprueba si es de tipo DatoSocket
				    recivido = (Mensaje)aux; // Se hace el cast.
				
		        System.out.println("Mensaje del cliente: "+recivido.getMensaje());
	
		        if(recivido!=null){	
					System.out.println("Mensaje enviando...");
		        	 //envio la respuesta
					Mensaje respuesta = new Mensaje();
					respuesta.setMensaje("Hola Cliente");
					salidaObjetos.writeObject(respuesta);	
					salidaObjetos.flush();
		        }
		        
				System.out.println("Cliente finalizado");
				cliente.close();
			}while(true);

		} catch (Exception e) {

			System.out.println("Error:" + e);

		}
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor();
	}
}
