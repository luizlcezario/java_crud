package me.dio.academia.digital.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

	@Autowired
	AvaliacaoFisicaService service;

	@PostMapping
	public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form) {
		return service.create(form);
	}

	@PostMapping("/{id}")
	public AvaliacaoFisica update(@Valid @RequestBody AvaliacaoFisicaUpdateForm form, @PathVariable Long id) {
		return service.update(id, form);
	}

	@GetMapping("/{id}")
	public AvaliacaoFisica getById(@PathVariable Long id) {
		return service.get(id);
	}

	@GetMapping
	public List<AvaliacaoFisica> getAll(@RequestParam(value = "peso", required = false) String peso,
			@RequestParam(value = "altura", required = false) String altura) {
		return service.getAll(peso, altura);
	}
}
