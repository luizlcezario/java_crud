package me.dio.academia.digital.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.infra.erros.CustomException;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;

public class MatriculaService implements IMatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public Matricula create(MatriculaForm form) {
		Optional<Aluno> aluno = alunoRepository.findById(form.getAlunoId());
		if (aluno.isPresent() == false)
			throw new CustomException("Aluno não encontrado", HttpStatus.NOT_FOUND );
		Matricula matricula = new Matricula();
		matricula.setAluno(aluno.get());
		matricula.setDataDaMatricula(LocalDateTime.now());
		return matriculaRepository.save(matricula);
	}

	@Override
	public Matricula get(Long id) {
		Optional<Matricula> matricula = matriculaRepository.findById(id);
		if (matricula.isPresent() == false)
			throw new CustomException("Matricula não encontrada", HttpStatus.NOT_FOUND );
			return matricula.get();
		}

	@Override
	public List<Matricula> getAll() {
		List<Matricula> matriculas = matriculaRepository.findAll();
		return matriculas;
	}

	@Override
	public void delete(Long id) {
		Matricula matricula = this.get(id);
		matriculaRepository.delete(matricula);
	}
	
}
