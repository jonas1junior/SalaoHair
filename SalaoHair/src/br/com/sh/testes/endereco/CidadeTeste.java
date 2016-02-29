package br.com.sh.testes.endereco;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sh.dao.endereco.CidadeDAO;
import br.com.sh.dao.endereco.EstadoDAO;
import br.com.sh.main.endereco.Cidade;
import br.com.sh.main.endereco.Estado;

public class CidadeTeste {

	@Ignore
	@Test
	public void salvar() {

		EstadoDAO edao = new EstadoDAO();
		Estado estado = edao.buscarPorCodigo(1L);
		CidadeDAO cdao = new CidadeDAO();
		Cidade cidade = new Cidade();
		cidade.setDescricao("SÃO CAETANO DO SUL");
		cidade.setEstado(estado);
		cdao.salvar(cidade);

	}

	@Ignore
	@Test
	public void buscarPorCodigo() {

		CidadeDAO cdao = new CidadeDAO();
		Cidade cidade = cdao.buscarPorCodigo(6L);

		System.out.println(cidade);

	}

	@Ignore
	@Test
	public void listar() {

		CidadeDAO cdao = new CidadeDAO();
		List<Cidade> cidades = cdao.listar();

		for (Cidade cidade : cidades) {
			System.out.println(cidade);
		}
	}

	@Ignore
	@Test
	public void editar() {

		CidadeDAO cdao = new CidadeDAO();
		Cidade cidade = cdao.buscarPorCodigo(9L);
		cidade.setDescricao("VOLTA REDONDA");
		cdao.editar(cidade);

	}

	@Ignore
	@Test
	public void excluirEndereco() {

		CidadeDAO cdao = new CidadeDAO();
		Cidade cidade = cdao.buscarPorCodigo(8L);
		cdao.excluir(cidade);

	}
}
