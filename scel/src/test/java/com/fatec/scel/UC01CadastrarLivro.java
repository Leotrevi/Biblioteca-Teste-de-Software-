package com.fatec.scel;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.scel.model.Livro;

public class UC01CadastrarLivro {

	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}

	@Test
	public void CT02CadastrarLivroComDadosIvalidos() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn("");

		} catch (RuntimeException e) {
			assertEquals("ISBN invalido", e.getMessage());
		}
	}

	@Test
	public void CT03CadastrarLivroComDadosIvalidos() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn(null);

		} catch (RuntimeException e) {
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT04CadastrarLivroComDadosTituloVazio() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setTitulo("");

		} catch (RuntimeException e) {
			assertEquals("Titulo invalido", e.getMessage());
		}
	}

	@Test
	public void CT05CadastrarLivroComTituloNulo() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setTitulo(null);

		} catch (RuntimeException e) {
			assertEquals("Titulo invalido", e.getMessage());
		}
	}
	
	
	@Test
	public void CT06CadastrarLivroComDadosAutorVazio() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setAutor("");

		} catch (RuntimeException e) {
			assertEquals("Autor invalido", e.getMessage());
		}
	}

	@Test
	public void CT05CadastrarLivroComAutorNulo() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setAutor(null);

		} catch (RuntimeException e) {
			assertEquals("Autor invalido", e.getMessage());
		}
	}
	
	
	@Test
	public void CT06CadastrarLivroCom_obtem_ISBN() {
		// cenario
					Livro umLivro = new Livro();
		try {
			// acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
		assertEquals("121212", umLivro.getIsbn());
	}
	
	
	@Test
	public void CT07CadastrarLivroCom_obtem_Titulo() {
		// cenario
					Livro umLivro = new Livro();
		try {
			// acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
		assertEquals("Engenharia de Softwar", umLivro.getTitulo());
	}
	
	@Test
	public void CT08CadastrarLivroCom_obtem_Autor() {
		// cenario
		Livro umLivro = new Livro();
		try {
			// acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
		assertEquals("Pressman", umLivro.getAutor());
	}
	
	
	
}
