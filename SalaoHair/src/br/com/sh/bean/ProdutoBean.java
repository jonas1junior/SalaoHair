package br.com.sh.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.FabricanteDAO;
import br.com.sh.dao.ProdutoDAO;
import br.com.sh.main.negocio.Fabricante;
import br.com.sh.main.negocio.Produto;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto proCadastro;
	private List<Produto> lista;
	private List<Produto> listaFiltro;
	private List<Fabricante> listaFabricantes;
	private String acao;
	private int codigo;

	ProdutoDAO pdao = new ProdutoDAO();
	
	public Produto getProCadastro() {
		return proCadastro;
	}
	public void setProCadastro(Produto proCadastro) {
		this.proCadastro = proCadastro;
	}
	public List<Produto> getLista() {
		return lista;
	}
	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	public List<Produto> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Produto> listaFiltro) {
		this.listaFiltro = listaFiltro;
	}
	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}
	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
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
		proCadastro = new Produto();
	}
	
	public void salvar() {
		try {
			pdao.salvar(proCadastro);

			proCadastro = new Produto();

			FacesUtil.addMsgInfo("Produto salvo com sucesso!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar o produto!");
		}
	}

	public void carregaPesquisa() {
		try {
			lista = pdao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar listar os produto");
		}
	}

	public void carregarCadastro() {
		try {

			if (codigo <= 0) {
				proCadastro = pdao.buscarPorCodigo(codigo);
			} else {
				proCadastro = new Produto();
			}
			FabricanteDAO fdao = new FabricanteDAO();
			listaFabricantes = fdao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados do produto!");
		}
	}

	public void excluir() {
		try {
			pdao.excluir(proCadastro);
			FacesUtil.addMsgInfo("Produto excluido com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar excluir o produto!");
		}
	}

	public void editar() {
		try {
			pdao.editar(proCadastro);
			FacesUtil.addMsgInfo("Produto editado com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar editar o produto!");
		}
	}
}