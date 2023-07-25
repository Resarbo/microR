package com.empleados.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.service.entidades.Empleado;
import com.empleados.service.repositorio.EmpleadoRepository;

@Service
public class EmpleadoService {
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	public List<Empleado> getAll(){
		return empleadoRepository.findAll();
	}
	
	public Empleado getEmpleadoById(int id) {
		return empleadoRepository.findById(id).orElse(null);
	}
	
	public Empleado save(Empleado empleado) {
		Empleado nuevoEmpleado = empleadoRepository.save(empleado);
		return nuevoEmpleado;
	}
	
	public List<Empleado> byRestauranteId(int restauranteId){
		return empleadoRepository.findByRestauranteId(restauranteId);
	}
}
