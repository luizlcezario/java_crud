package me.dio.academia.digital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.academia.digital.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
	Optional<Matricula> findByAlunoId(Long id);
}
