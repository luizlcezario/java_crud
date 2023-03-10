package me.dio.academia.digital.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import me.dio.academia.digital.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	List<Aluno> findByDataDenascimento(LocalDate LocalDate);

	List<Aluno> findByBairro(String bairro);

	List<Aluno> findByDataDenascimentoAndBairro(LocalDate LocalDate, String bairro);
}
