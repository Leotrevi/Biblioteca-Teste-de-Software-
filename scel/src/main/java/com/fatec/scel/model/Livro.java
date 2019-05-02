package com.fatec.scel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Livro")
public class Livro {
	@Id
	private String isbn;
	private String titulo;
	private String autor;

	public Livro() {
	}

	public Livro(String i, String t, String a) {
		this.isbn = i;
		this.titulo = t;
		this.autor = a;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if (isbn == "" | isbn == null) {
			throw new RuntimeException("ISBN invalido");
		}
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo == "" | titulo == null) {
			throw new RuntimeException("Titulo invalido");
		}
		this.titulo = titulo;

	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (autor == "" | autor == null) {
			throw new RuntimeException("Autor invalido");
		}
		this.autor = autor;
	}
}