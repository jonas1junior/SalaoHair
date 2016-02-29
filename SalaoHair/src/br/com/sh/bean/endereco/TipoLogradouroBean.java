package br.com.sh.bean.endereco;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.endereco.TipoLogradouroDAO;
import br.com.sh.main.endereco.TipoLogradouro;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class TipoLogradouroBean {

	private TipoLogradouro tplCadastro;
	private List<TipoLogradouro> lista;
	private List<TipoLogradouro> listaFiltro;
	private String acao;
	private int codigo;

	TipoLogradouroDAO tpldao = new TipoLogradouroDAO();
	
	
	public TipoLogradouro getTplCadastro() {
		return tplCadastro;
	}
	public void setTplCadastro(TipoLogradouro tplCadastro) {
		this.tplCadastro = tplCadastro;
	}
	public List<TipoLogradouro> getLista() {
		return lista;
	}
	public void setLista(List<TipoLogradouro> lista) {
		this.lista = lista;
	}
	public List<TipoLogradouro> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<TipoLogradouro> listaFiltro) {
		this.listaFiltro = listaFiltro;
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
		tplCadastro = new TipoLogradouro();
	}
	
	
	public void salvar() {
		try {
			tpldao.salvar(tplCadastro);
			tplCadastro = new TipoLogradouro();
			FacesUtil.addMsgInfo("Dados salvos com sucesso!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar os dados!");
		}
	}

	
	public void carregaPesquisa() {
		try {
			lista = tpldao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar listar os dados!");
		}
	}

	
	public void carregarCadastro() {
		try {

			if (codigo <= 0) {
				tplCadastro = tpldao.buscarPorCodigo(codigo);
			} else {
				tplCadastro = new TipoLogradouro();
			}
			lista = tpldao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados!");
		}
	}

	
	public void excluir() {
		try {
			tpldao.excluir(tplCadastro);
			FacesUtil.addMsgInfo("Dados excluidos com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar excluir os dados!");
		}
	}

	
	public void editar() {
		try {
			tpldao.editar(tplCadastro);
			FacesUtil.addMsgInfo("TDados editados com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar editar os dados!");
		}
	}
}