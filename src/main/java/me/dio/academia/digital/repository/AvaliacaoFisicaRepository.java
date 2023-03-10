package me.dio.academia.digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.academia.digital.entity.AvaliacaoFisica;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {

	List<AvaliacaoFisica> findByPesoAndAltura(double peso, double altura);

	List<AvaliacaoFisica> findByPeso(double peso);

	List<AvaliacaoFisica> findByAltura(double altura);
}
