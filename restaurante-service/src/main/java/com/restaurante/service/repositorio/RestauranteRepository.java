package com.restaurante.service.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.service.entidades.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{

}
