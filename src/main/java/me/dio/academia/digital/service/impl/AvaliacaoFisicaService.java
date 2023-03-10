package me.dio.academia.digital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.infra.erros.CustomException;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaService implements IAvaliacaoFisicaService {

	@Autowired
	AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	@Autowired
	AlunoRepository alunoRepository;

	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		Optional<Aluno> aluno = alunoRepository.findById(form.getAlunoId());
		if (aluno.isPresent() == false)
			throw new CustomException("Aluno não encontrado", HttpStatus.NOT_FOUND);
		avaliacaoFisica.setAluno(aluno.get());
		avaliacaoFisica.setAltura(form.getAltura());
		avaliacaoFisica.setPeso(form.getPeso());
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}

	@Override
	public void delete(Long id) {
		Optional<AvaliacaoFisica> ava = avaliacaoFisicaRepository.findById(id);
		if (ava.isPresent() == false)
			throw new CustomException("Aluno não encontrado", HttpStatus.NOT_FOUND);
		avaliacaoFisicaRepository.delete(ava.get());
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		Optional<AvaliacaoFisica> ava = avaliacaoFisicaRepository.findById(id);
		if (ava.isPresent() == false)
			throw new CustomException("Aluno não encontrado", HttpStatus.NOT_FOUND);
		return ava.get();
	}

	@Override
	public List<AvaliacaoFisica> getAll(String peso, String altura) {
		double numPeso = Double.parseDouble(peso);
		double numAltura = Double.parseDouble(altura);

		if (peso != null && altura != null)
			return avaliacaoFisicaRepository.findByPesoAndAltura(numPeso, numAltura);
		else if (peso != null)
			return avaliacaoFisicaRepository.findByPeso(numPeso);
		else if (altura != null)
			return avaliacaoFisicaRepository.findByAltura(numAltura);
		else
		return avaliacaoFisicaRepository.findAll();
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		AvaliacaoFisica ava = this.get(id);
		formUpdate.getAltura().ifPresent(ava::setAltura);
		formUpdate.getPeso().ifPresent(ava::setPeso);
		return null;
	}

}
