package com.restaurante.service.modelos;

public class Plato {
	private String nombre;
	private float costo;
	private int restauranteId;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public int getRestauranteId() {
		return restauranteId;
	}

	public void setRestauranteId(int restauranteId) {
		this.restauranteId = restauranteId;
	}

	public Plato() {
		super();
		// TODO Auto-generated constructor stub
	}

}
