package modelo;

import java.util.Date;

public class Persona {
	private int id;
	private String documento;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private java.sql.Date fechaNac;
	private String clave;
	private String email;
	private Rol rol;
	
	public Persona() {}

	public Persona(String documento, String nombre1, String nombre2, String apellido1, String apellido2, java.sql.Date fechaNac,
			String clave, String email) {
		super();
		this.documento = documento;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNac = fechaNac;
		this.clave = clave;
		this.email = email;
		this.rol=null;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public java.sql.Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(java.sql.Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
		
	public String toString() {
		return "Cedula: " + this.documento + " , de nombre: " + this.nombre1 + " " + this.nombre2 + " " + this.apellido1 + " " + this.apellido2;
	}
	
	
	
	
}
