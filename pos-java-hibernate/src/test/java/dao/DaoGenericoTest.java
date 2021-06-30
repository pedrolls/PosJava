package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import model.Pessoa;

class DaoGenericoTest {

	@Test
	@Ignore
	void salvarTest() {
		//Arrange
		DaoGenerico<Pessoa> daoGenerico = new DaoGenerico<Pessoa>();
		Pessoa pessoa = getPessoa();
		
		//Assert
		try {
			daoGenerico.salvar(pessoa);
		} catch (Exception e) {
			fail("Falhou no cadastro");
		}		
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Test
	@Ignore
	public void consultarTest() {
		//Arrange
		Pessoa pessoa = getPessoa();
		//Act
		pessoa.setId(1L);
		//Assert
		try {
			assertEquals(pessoa, new PessoaDao().consultarPorChavePrimaria(pessoa.getId()));
		} catch (Exception e) {
			fail("Teste de consulta falhou!");
		}
	}
	
	@Test
	public void salvarAtualizarTest() {
		//Arrange
		PessoaDao<Pessoa> pessoaDao = new PessoaDao<Pessoa>();
		Pessoa pessoa = getPessoa();
		//act
		pessoa.setNome("Juliana");
		pessoa.setEmail("juliana@test.com");
		pessoa.setIdade(33);
		pessoa.setSobrenome("Leite");
		
		//Act
		try {
			Pessoa novaPessoa = pessoaDao.updateMerge(pessoa);
			assertEquals(pessoa.getNome(), novaPessoa.getNome());
		} catch (Exception e) {
			fail("falha no salvar/atualizar o objeto");
		}
	}
	
	public Pessoa getPessoa() {
		Pessoa pessoa = new Pessoa();

		pessoa.setEmail("teste@hotmail.com");
		pessoa.setNome("Pedro");
		pessoa.setSenha("123");
		pessoa.setSobrenome("Leonardo");
		pessoa.setLogin("teste");
		pessoa.setIdade(28);
		
		return pessoa;
	}
}
