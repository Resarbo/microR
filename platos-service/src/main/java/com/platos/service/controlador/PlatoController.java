package com.platos.service.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platos.service.entidades.Plato;
import com.platos.service.servicio.PlatoService;

@RestController
@RequestMapping("/plato")
public class PlatoController {
	@Autowired
	private PlatoService platoService;
	
	@GetMapping
	public ResponseEntity<List<Plato>> listarPlatos(){
		List<Plato> platos = platoService.getAll();
		if(platos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(platos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Plato> obtenerPlato(@PathVariable("id") int id){
		Plato plato= platoService.getPlatoById(id);
		if(plato == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(plato);
	}
	
	@PostMapping
	public ResponseEntity<Plato> guardarPlato(@RequestBody Plato plato){
		Plato nuevoPlato = platoService.save(plato);
		return ResponseEntity.ok(nuevoPlato);
	}
	
	@GetMapping("/restaurante/{restauranteId}")
	public ResponseEntity<List<Plato>> listarPlatosPorUniversidadId(@PathVariable("restauranteId") int id){
		List<Plato> platos = platoService.byRestauranteId(id);
		if(platos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(platos);
	}
}
