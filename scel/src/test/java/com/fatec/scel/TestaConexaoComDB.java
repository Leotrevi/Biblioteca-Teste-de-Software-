package com.fatec.scel;

import static org.junit.Assert.*;
import org.junit.Test;
import com.fatec.scel.model.ConfiguraDB;
import com.fatec.scel.model.FabricaDeConexoes;

public class TestaConexaoComDB {
	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com
	 * configuracao valida Pré-condição - a configuracao default da fabrica de
	 * conexoes é valida
	 */
	@Test
	public void quandoConectaComOBancoRetornaOK() {
// cenario
		FabricaDeConexoes fabrica;
// acao
		fabrica = new FabricaDeConexoes();
// verificacao
		assertNotNull(fabrica.getConnection());
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com senha de
	 * acesso invalida Pré-condição - a senha cadastrada é "aluno"
	 */
	@Test
	public void quandoConectaComSenhaInvalida_SQLException() {
// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca?useTimezone=true&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		String usuario = "root";
		String senha = "123"; // senha errada
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
//acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.sql.SQLException: Access denied for user 'root'@'localhost'(using password: YES)");
		}
	}
}