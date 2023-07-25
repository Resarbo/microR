package com.restaurante.service.feignclientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurante.service.modelos.Plato;

@FeignClient(name = "platos-service")
public interface PlatoFeignClient {
	@PostMapping("/plato")
	public Plato save(@RequestBody Plato plato);
	
	@GetMapping("/plato/restaurante/{restauranteId}")
	public List<Plato> getPlatos(@PathVariable("restauranteId") int restauranteId);
}
