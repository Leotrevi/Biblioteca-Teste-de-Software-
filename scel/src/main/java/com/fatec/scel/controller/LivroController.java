package com.fatec.scel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatec.scel.model.Livro;
import com.fatec.scel.model.LivroRepository;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {
	@Autowired
	private LivroRepository repository;

	@GetMapping
	public Iterable<Livro> list() {
		return repository.findAll();
	}
}