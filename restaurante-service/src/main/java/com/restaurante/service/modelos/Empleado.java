package com.restaurante.service.modelos;

public class Empleado {
	private String nombre;
	private String area;
	private int restauranteId;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getRestauranteId() {
		return restauranteId;
	}

	public void setRestauranteId(int restauranteId) {
		this.restauranteId = restauranteId;
	}

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

}
