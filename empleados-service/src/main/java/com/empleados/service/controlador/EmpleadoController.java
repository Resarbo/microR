package com.empleados.service.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.service.entidades.Empleado;
import com.empleados.service.servicio.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping
	public ResponseEntity<List<Empleado>> listarEmpleados(){
		List<Empleado> empleados = empleadoService.getAll();
		if(empleados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(empleados);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable("id") int id){
		Empleado empleado= empleadoService.getEmpleadoById(id);
		if(empleado == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(empleado);
	}
	
	@PostMapping
	public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado){
		Empleado nuevoEmpleado = empleadoService.save(empleado);
		return ResponseEntity.ok(nuevoEmpleado);
	}
	
	@GetMapping("/restaurante/{restauranteId}")
	public ResponseEntity<List<Empleado>> listarEmpleadosPorUniversidadId(@PathVariable("restauranteId") int id){
		List<Empleado> empleados = empleadoService.byRestauranteId(id);
		if(empleados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(empleados);
	}
}
