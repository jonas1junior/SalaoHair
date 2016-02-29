package br.com.sh.testes.endereco;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sh.dao.endereco.BairroDAO;
import br.com.sh.dao.endereco.EnderecoDAO;
import br.com.sh.dao.endereco.LogradouroDAO;
import br.com.sh.main.endereco.Bairro;
import br.com.sh.main.endereco.Endereco;
import br.com.sh.main.endereco.Logradouro;

public class EnderecoTeste {
	
	@Ignore
	@Test
	public void salvar() {
		
		BairroDAO bdao = new BairroDAO();
		Bairro bairro = bdao.buscarPorCodigo(10);
		
		LogradouroDAO ldao = new LogradouroDAO();
		Logradouro logradouro = ldao.buscarPorCodigo(12);

		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setLogradouro(logradouro);

		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.salvar(endereco);
		
	}
	
	@Ignore
	@Test
	public void buscarPorCodigo() {

		EnderecoDAO edao = new EnderecoDAO();
		Endereco endereco = edao.buscarPorCodigo(13);

		System.out.println(endereco);

	}

	@Ignore
	@Test
	public void listar() {

		EnderecoDAO edao = new EnderecoDAO();
		List<Endereco> enderecos = edao.listar();

		for (Endereco endereco : enderecos) {
			System.out.println(endereco);
		}
	}

	@Ignore
	@Test
	public void editar() {

		EnderecoDAO edao = new EnderecoDAO();
		Endereco endereco = edao.buscarPorCodigo(16);
		
//		EstadoDAO estadodao = new EstadoDAO();
//		Estado estado = estadodao.buscarPorCodigo(14);
//		endereco.setBairro(estado);
		
		edao.editar(endereco);

	}

	@Ignore
	@Test
	public void excluir() {

		EnderecoDAO edao = new EnderecoDAO();
		Endereco endereco = edao.buscarPorCodigo(15);
		edao.excluir(endereco);

	}
}