package modelo;

import java.util.ArrayList;

public class Rol {
	private String nombre;
	private String descripcion;
	private ArrayList<Persona> personas;
	private ArrayList<Funcionalidad> funcionalidades;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rol() {
		
	}
	
	public Rol(String nombre, String descripcion, ArrayList<Persona> personas,
			ArrayList<Funcionalidad> funcionalidades) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.personas = personas;
		this.funcionalidades = funcionalidades;
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

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public ArrayList<Funcionalidad> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(ArrayList<Funcionalidad> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

	
	
	

}
