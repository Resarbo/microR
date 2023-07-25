package com.restaurante.service.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.service.entidades.Restaurante;
import com.restaurante.service.modelos.Empleado;
import com.restaurante.service.modelos.Plato;
import com.restaurante.service.servicio.RestauranteService;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
	@Autowired
	RestauranteService restauranteService;
	
	@GetMapping
	public ResponseEntity<List<Restaurante>> listarRestaurantes(){
		List<Restaurante> restaurantes = restauranteService.getAll();
		if(restaurantes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(restaurantes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> obtenerRestaurante(@PathVariable("id") int id){
		Restaurante restaurante = restauranteService.getRestauranteById(id);
		if(restaurante == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(restaurante);
	}
	
	@PostMapping
	public ResponseEntity<Restaurante> guardarRestaurante(@RequestBody Restaurante restaurante){
		Restaurante nuevoRestaurante = restauranteService.saveRestaurante(restaurante);
		return ResponseEntity.ok(nuevoRestaurante);
	}
	
	@PostMapping("/empleados/{restauranteId}")
	public ResponseEntity<Empleado> guardarEmpleados(@PathVariable("restauranteId") int restauranteId,@RequestBody Empleado empleado){
		Empleado nuevoEmpleado = restauranteService.saveEmpleado(restauranteId, empleado);
		return ResponseEntity.ok(nuevoEmpleado);
	} 
	
	@PostMapping("/platos/{restauranteId}")
	public ResponseEntity<Plato> guardarPlatos(@PathVariable("restauranteId") int restauranteId,@RequestBody Plato platos){
		Plato nuevoPlato = restauranteService.savePlato(restauranteId, platos);
		return ResponseEntity.ok(nuevoPlato);
	} 
	
	@GetMapping("/todos/{restauranteId}")
	public ResponseEntity<Map<String, Object>> listarTodosLosEmpleadosYPlatos(@PathVariable("restauranteId") int restauranteId){
		Map<String,Object> resultado = restauranteService.getRestauranteAndEmpleadosAndPlatos(restauranteId);
		return ResponseEntity.ok(resultado);
	}
}
