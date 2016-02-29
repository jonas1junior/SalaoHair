package br.com.sh.testes.endereco;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sh.dao.endereco.LogradouroDAO;
import br.com.sh.dao.endereco.TipoLogradouroDAO;
import br.com.sh.main.endereco.Logradouro;
import br.com.sh.main.endereco.TipoLogradouro;

public class LogradouroTeste {
	
	@Ignore
	@Test
	public void salvar(){
		
		Logradouro l = new Logradouro();
		
		TipoLogradouro tpl = new TipoLogradouro();
		TipoLogradouroDAO tpldao = new TipoLogradouroDAO();
		tpl.setDescricao("RUA");
		tpldao.salvar(tpl);
		
		l.setTipoLogradouro(tpl);
		l.setDescricao("ODIMIR FARINA");
		l.setNumero(126);
		
		LogradouroDAO ldao = new LogradouroDAO();
		ldao.salvar(l);
		
	}
	
	@Ignore
	@Test
	public void buscarPorCodigo(){
		
		LogradouroDAO ldao = new LogradouroDAO();
		Logradouro l1 = ldao.buscarPorCodigo(2);
		
		System.out.println(l1);
	}
	
	@Ignore
	@Test
	public void listar(){
		
		LogradouroDAO ldao = new LogradouroDAO();
		List<Logradouro> logradouros = ldao.listar();
		
		for (Logradouro logradouro : logradouros) {
			System.out.println(logradouro);
		}
	}
	
	@Ignore
	@Test
	public void editar(){

		TipoLogradouroDAO tpldao = new TipoLogradouroDAO();
		TipoLogradouro tpl = tpldao.buscarPorCodigo(3);
		tpl.setDescricao("TRAVESSA");
		tpldao.editar(tpl);
		
		LogradouroDAO ldao = new LogradouroDAO();
		Logradouro l1 = ldao.buscarPorCodigo(4);
		l1.setDescricao("MANTIQUEIRAS");
		l1.setTipoLogradouro(tpl);
		ldao.editar(l1);
		
	}
	
	@Ignore
	@Test
	public void excluir(){
		
		LogradouroDAO ldao = new LogradouroDAO();
		Logradouro l1 = ldao.buscarPorCodigo(6);
		ldao.excluir(l1);
		
	}
}