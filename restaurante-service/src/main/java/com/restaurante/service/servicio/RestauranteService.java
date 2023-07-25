package com.restaurante.service.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.service.entidades.Restaurante;
import com.restaurante.service.feignclientes.EmpleadoFeignClient;
import com.restaurante.service.feignclientes.PlatoFeignClient;
import com.restaurante.service.modelos.Empleado;
import com.restaurante.service.modelos.Plato;
import com.restaurante.service.repositorio.RestauranteRepository;

@Service
public class RestauranteService {
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired 
	private EmpleadoFeignClient empleadoFeignClient;
	
	@Autowired
	private PlatoFeignClient platoFeignClient;
	
	public List<Restaurante> getAll() {
		return restauranteRepository.findAll();
	}

	public Restaurante getRestauranteById(int id) {
		return restauranteRepository.findById(id).orElse(null);
	}

	public Restaurante saveRestaurante(Restaurante restaurante) {
		Restaurante nuevoRestaurante = restauranteRepository.save(restaurante);
		return nuevoRestaurante;
	}
	
	public Empleado saveEmpleado(int restauranteId, Empleado empleados) {
		empleados.setRestauranteId(restauranteId);
		Empleado nuevoEmpleado = empleadoFeignClient.save(empleados);
		return nuevoEmpleado;
	}
	
	public Plato savePlato(int restauranteId, Plato platos) {
		platos.setRestauranteId(restauranteId);
		Plato nuevoPlato = platoFeignClient.save(platos);
		return nuevoPlato;
	}
	
	public Map<String, Object> getRestauranteAndEmpleadosAndPlatos(int restauranteId){
		Map<String,Object> resultado = new HashMap<>();
		Restaurante restaurante = restauranteRepository.findById(restauranteId).orElse(null);
		
		if(restaurante == null) {
			resultado.put("Mensaje", "El restaurante no existe");
			return resultado;
		}
		resultado.put("Restaurante",restaurante);
		
		List<Empleado> empleados = empleadoFeignClient.getEmpleados(restauranteId);
		if(empleados.isEmpty()) {
			resultado.put("Empleados", "El restaurante no tiene empleados");
		}
		else {
			resultado.put("Empleados", empleados);
		}
		
		List<Plato> platos = platoFeignClient.getPlatos(restauranteId);
		if(platos.isEmpty()) {
			resultado.put("Platos", "No hay platos disponibles");
		}
		else {
			resultado.put("Platos", platos);
		}
		return resultado;
	}
}
