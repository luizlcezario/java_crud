package me.dio.academia.digital.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.erros.CustomException;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoService implements IAlunoService {

	@Autowired
	private AlunoRepository repository;

	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNascimento());
		return repository.save(aluno);
	}

	@Override
	public void delete(Long id) {
		Aluno aluno = this.get(id);
		repository.delete(aluno);
	}

	@Override
	public Aluno get(Long id) {
		Optional<Aluno> aluno = repository.findById(id);
		if (aluno.isPresent() == false)
			throw new CustomException("Aluno não encontrado", HttpStatus.NOT_FOUND);
		return aluno.get();
	}

	@Override
	public List<Aluno> getAll(String dataDeNascimento, String bairro) {
		if (dataDeNascimento != null && bairro != null)
			return repository.findByDataDenascimentoAndBairro(
					LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER), bairro);
		else if (dataDeNascimento != null)
			return repository
					.findByDataDenascimento(LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER));
		else if (bairro != null)
			return repository.findByBairro(bairro);
		return repository.findAll();
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		Aluno aluno = this.get(id);
		Aluno alunoUpdate = aluno;
		formUpdate.getNome().ifPresent(alunoUpdate::setNome);
		formUpdate.getBairro().ifPresent(alunoUpdate::setBairro);
		formUpdate.getDataDeNascimento().ifPresent(alunoUpdate::setDataDeNascimento);
		return repository.save(alunoUpdate);
	}

	public List<AvaliacaoFisica> getAllAvaliacoesFisicas(Long id) {
		Aluno aluno = this.get(id);
		return aluno.getAvaliacoes();
	}

}
