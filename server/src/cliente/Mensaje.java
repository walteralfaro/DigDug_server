package cliente;

import java.io.Serializable;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mensaje;

	public String getMensaje() {

		return mensaje;

	}

	public void setMensaje(String mensaje) {

		this.mensaje = mensaje;

	}
}