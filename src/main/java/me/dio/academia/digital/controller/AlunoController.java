package me.dio.academia.digital.controller;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.service.impl.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public List<Aluno> getAll() {
		return alunoService.getAll();
	}

	@GetMapping("/{id}")
	public Aluno getById(@PathVariable Long id) {
		return alunoService.get(id);
	}

	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return alunoService.create(form);
	}
	
	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacoesFisicas(@PathVariable Long id) {
		return alunoService.getAllAvaliacoesFisicas(id);
	}
}
