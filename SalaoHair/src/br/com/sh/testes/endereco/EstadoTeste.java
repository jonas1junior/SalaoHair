package br.com.sh.testes.endereco;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sh.dao.endereco.EstadoDAO;
import br.com.sh.main.endereco.Estado;

public class EstadoTeste {
	
	@Ignore
	@Test
	public void salvar() {

		EstadoDAO edao = new EstadoDAO();
		Estado estado = new Estado();
		estado.setDescricao("BAHIA");
		estado.setSigla("BA");
		edao.salvar(estado);

	}

	@Ignore
	@Test
	public void buscarPorCodigo() {

		EstadoDAO edao = new EstadoDAO();
		Estado estado = edao.buscarPorCodigo(11L);

		System.out.println(estado);

	}

	@Ignore
	@Test
	public void listar() {

		EstadoDAO edao = new EstadoDAO();
		List<Estado> estados = edao.listar();

		for (Estado estado : estados) {
			System.out.println(estado);
		}
	}

	@Ignore
	@Test
	public void editar() {

		EstadoDAO edao = new EstadoDAO();
		Estado estado = edao.buscarPorCodigo(1L);
		estado.setSigla("BA");
		edao.editar(estado);

	}

	@Ignore
	@Test
	public void excluirEndereco() {

		EstadoDAO edao = new EstadoDAO();
		Estado estado = edao.buscarPorCodigo(1L);
		edao.excluir(estado);

	}
}
