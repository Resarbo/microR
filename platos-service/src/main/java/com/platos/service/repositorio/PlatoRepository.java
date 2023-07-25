package com.platos.service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platos.service.entidades.Plato;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer>{
	List<Plato> findByRestauranteId(int restauranteId);
}
