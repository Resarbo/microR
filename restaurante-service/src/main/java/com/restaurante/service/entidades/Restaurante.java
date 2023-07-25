package com.restaurante.service.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;
	private int mesas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMesas() {
		return mesas;
	}

	public void setMesas(int mesas) {
		this.mesas = mesas;
	}

	public Restaurante(int id, String nombre, int mesas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mesas = mesas;
	}

	public Restaurante() {
		super();
		// TODO Auto-generated constructor stub
	}

}
