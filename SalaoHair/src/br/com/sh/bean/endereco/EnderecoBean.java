package br.com.sh.bean.endereco;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.endereco.BairroDAO;
import br.com.sh.dao.endereco.CidadeDAO;
import br.com.sh.dao.endereco.EnderecoDAO;
import br.com.sh.dao.endereco.EstadoDAO;
import br.com.sh.dao.endereco.TipoLogradouroDAO;
import br.com.sh.main.endereco.Bairro;
import br.com.sh.main.endereco.Cidade;
import br.com.sh.main.endereco.Endereco;
import br.com.sh.main.endereco.Estado;
import br.com.sh.main.endereco.TipoLogradouro;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class EnderecoBean {

	private Endereco endCadastro;
	private List<Endereco> lista;
	private List<Endereco> listaFiltro;
	private List<TipoLogradouro> listaTipoLogradouros;
	private List<Bairro> listaBairros;
	private List<Cidade> listaCidades;
	private List<Estado> listaEstados;
	private String acao;
	private int codigo;

	EnderecoDAO enddao = new EnderecoDAO();
	
	
	public Endereco getEndCadastro() {
		return endCadastro;
	}
	public void setEndCadastro(Endereco endCadastro) {
		this.endCadastro = endCadastro;
	}
	public List<Endereco> getLista() {
		return lista;
	}
	public void setLista(List<Endereco> lista) {
		this.lista = lista;
	}
	public List<Endereco> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Endereco> listaFiltro) {
		this.listaFiltro = listaFiltro;
	}
	public List<TipoLogradouro> getListaTipoLogradouros() {
		return listaTipoLogradouros;
	}
	public void setListaTipoLogradouros(List<TipoLogradouro> listaTipoLogradouros) {
		this.listaTipoLogradouros = listaTipoLogradouros;
	}
	public List<Bairro> getListaBairros() {
		return listaBairros;
	}
	public void setListaBairros(List<Bairro> listaBairros) {
		this.listaBairros = listaBairros;
	}
	public List<Cidade> getListaCidades() {
		return listaCidades;
	}
	public void setListaCidades(List<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}
	public List<Estado> getListaEstados() {
		return listaEstados;
	}
	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	public void novo() {
		endCadastro = new Endereco();
	}
	
	
	public void salvar() {
		try {
			enddao.salvar(endCadastro);

			endCadastro = new Endereco();

			FacesUtil.addMsgInfo("Dados salvos com sucesso!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar os dados!");
		}
	}

	
	public void carregaPesquisa() {
		try {
			lista = enddao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar listar os dados");
		}
	}

	
	public void carregarCadastro() {
		try {

			if (codigo <= 0) {
				endCadastro = enddao.buscarPorCodigo(codigo);
			} else {
				endCadastro = new Endereco();
			}
			TipoLogradouroDAO tpldao = new TipoLogradouroDAO();
			listaTipoLogradouros = tpldao.listar();
			EstadoDAO esdao = new EstadoDAO();
			listaEstados = esdao.listar();
			CidadeDAO cdao = new CidadeDAO();
			listaCidades = cdao.listar();
			BairroDAO bdao = new BairroDAO();
			listaBairros = bdao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados!");
		}
	}

	
	public void excluir() {
		try {
			enddao.excluir(endCadastro);
			FacesUtil.addMsgInfo("Dados excluidos com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar excluir os dados!");
		}
	}

	
	public void editar() {
		try {
			enddao.editar(endCadastro);
			FacesUtil.addMsgInfo("Dados editado com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar editar os dados!");
		}
	}
}