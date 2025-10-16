package com.generation.fitness.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.fitness.model.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
	
	public List<Exercicio> findAllByNomeContainingIgnoreCase(String nome);

}
