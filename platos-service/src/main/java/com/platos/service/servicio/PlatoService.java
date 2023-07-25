package com.platos.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platos.service.entidades.Plato;
import com.platos.service.repositorio.PlatoRepository;

@Service
public class PlatoService {
	@Autowired
	private PlatoRepository platoRepository;
	
	public List<Plato> getAll(){
		return platoRepository.findAll();
	}
	
	public Plato getPlatoById(int id) {
		return platoRepository.findById(id).orElse(null);
	}
	
	public Plato save(Plato plato) {
		Plato nuevoPlato = platoRepository.save(plato);
		return nuevoPlato;
	}
	
	public List<Plato> byRestauranteId(int restauranteId){
		return platoRepository.findByRestauranteId(restauranteId);
	}
}
