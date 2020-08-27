package modelo;

import java.util.ArrayList;

public class Funcionalidad {
	private int id;
	private String nombre;
	private String descripcion;
	private ArrayList<Rol> roles;
	
	
	public Funcionalidad() {
		
	}
	
	public Funcionalidad(String nombre, String descripcion, ArrayList<Rol> roles) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.roles = roles;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public ArrayList<Rol> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Rol> roles) {
		this.roles = roles;
	}

	public boolean acceso(Persona p) {
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public void setRol(Rol r) {
		this.roles.add(r);
	}

}
