package server;

import java.net.*;

import cliente.Mensaje;

import java.io.*;

public class Cliente {
	
	Cliente(int i){
		try {
		
			Socket c = new Socket("localhost",5000);
		
				InputStream entrada = c.getInputStream();
				OutputStream salida = c.getOutputStream();
				
				
				ObjectOutputStream salidaObjetos = new ObjectOutputStream (salida);
				
		        //envio mensaje
				Mensaje enviando = new Mensaje();
				enviando.setMensaje("Hola"+i+" Servidor");
				salidaObjetos.writeObject(enviando);
					
		        System.out.println("Mensaje del cliente: "+enviando.getMensaje());

				ObjectInputStream entradaObjetos = new ObjectInputStream (entrada);
				
				//recivo mensaje	
				Mensaje recivido = null ;
				Object aux;
				aux = entradaObjetos.readObject();// Se lee el objeto
				System.out.println("-----");
				if(aux!=null){
					if (aux instanceof Mensaje) // Se comprueba si es de tipo DatoSocket
					    recivido = (Mensaje)aux; // Se hace el cast.
					
			        System.out.println("Mensaje del cliente: "+recivido.getMensaje());
				}
				System.out.println("11111");	
				c.close();
		
			
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	
	}
	
	public static void main(String[] args) {
		Cliente cliente =  new Cliente(1);
		System.out.println("Fin");

	}

}
