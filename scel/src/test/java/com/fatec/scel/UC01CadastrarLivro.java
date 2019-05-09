package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.fatec.scel.model.Livro;
import com.fatec.scel.model.LivroRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UC01CadastrarLivro {
	@Autowired
	private LivroRepository livroRepository;
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	private Livro livro;

	@Before
	public void start() {
		livro = new Livro("1111", "Engenharia de Software", "Pressman");
	}

	@Test
	public void ct01_saveComISBN_NuloDeveLancarException() throws Exception {
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("O isbn deve ser preenchido");
		livro.setIsbn(null);
		livroRepository.save(livro);
	}

	@Test
	public void ct02_saveComTituloNuloDeveLancarException() throws Exception {
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("O titulo deve ser preenchido");
		livro.setTitulo(null);
		livroRepository.save(livro);
	}

	@Test
	public void ct03_saveComTituloBrancoDeveLancarException() throws Exception {
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("O titulo deve ser preenchido");
		livro.setTitulo("");
		livroRepository.save(livro);
	}

	@Test
	public void ct04_saveComAutorInvalidoSizeDeveLancarException() throws Exception {
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("Autor deve ter entre 1 e 10 caracteres");
		livro.setAutor("engenharia dddddd dddddddddddddd");
		livroRepository.save(livro);
	}

	@Test
	public void ct05_saveComAutorInvalidoNuloDeveLancarException() throws Exception {
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("Autor invalido");
		livro.setAutor(null);
		livroRepository.save(livro);
	}
	
	@Test
	public void ct06_save() throws Exception {
		livroRepository.save(livro);
		List livros = livroRepository.findAll();
		assertThat(livros.size()).isEqualTo(1L);
		
	}
	
	
	
}