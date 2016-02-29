package br.com.sh.testes.endereco;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sh.dao.endereco.BairroDAO;
import br.com.sh.dao.endereco.CidadeDAO;
import br.com.sh.main.endereco.Bairro;
import br.com.sh.main.endereco.Cidade;

public class BairroTeste {
	
	@Ignore
	@Test
	public void salvar() {
		
		CidadeDAO cdao = new CidadeDAO();
		Cidade cidade = cdao.buscarPorCodigo(6L);
		BairroDAO bdao = new BairroDAO();
		Bairro bairro = new Bairro();
		bairro.setCidade(cidade);
		bairro.setDescricao("DEMARCHI");
		bdao.salvar(bairro);
		
	}

	@Ignore
	@Test
	public void buscarPorCodigo(){
		
		BairroDAO bdao = new BairroDAO();
		Bairro bairro = bdao.buscarPorCodigo(3);
		
		System.out.println(bairro);
		
	}
	
	@Ignore
	@Test
	public void listar(){
		
		BairroDAO bdao = new BairroDAO();
		List<Bairro> bairros = bdao.listar();
		
		for (Bairro bairro : bairros) {
			System.out.println(bairro);
		}
	}
	
	@Ignore
	@Test
	public void editar(){
		
		BairroDAO bdao = new BairroDAO();
		Bairro bairro = bdao.buscarPorCodigo(3);
		bairro.setDescricao("ALVARENGA");
		bdao.editar(bairro);
		
	}
	
	@Ignore
	@Test
	public void excluirEndereco(){

		BairroDAO bdao = new BairroDAO();
		Bairro bairro = bdao.buscarPorCodigo(5);
		bdao.excluir(bairro);
		
	}
}
