package com.restaurante.service.feignclientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurante.service.modelos.Empleado;

@FeignClient(name = "empleados-service")
public interface EmpleadoFeignClient {
	@PostMapping("/empleado")
	public Empleado save(@RequestBody Empleado empleado);
	
	@GetMapping("/empleado/restaurante/{restauranteId}")
	public List<Empleado> getEmpleados(@PathVariable("restauranteId") int restauranteId);
}
