package br.com.sh.bean.endereco;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.endereco.EstadoDAO;
import br.com.sh.main.endereco.Estado;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class EstadoBean {
	
	private Estado estadoCadastro;
	private List<Estado> lista;
	private List<Estado> listaFiltro;
	private String acao;
	private Long codigo;
	
	EstadoDAO edao = new EstadoDAO();
	
	
	public Estado getEstadoCadastro() {
		return estadoCadastro;
	}
	public void setEstadoCadastro(Estado estadoCadastro) {
		this.estadoCadastro = estadoCadastro;
	}
	public List<Estado> getLista() {
		return lista;
	}
	public void setLista(List<Estado> lista) {
		this.lista = lista;
	}
	public List<Estado> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Estado> listaFiltro) {
		this.listaFiltro = listaFiltro;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
	public void novo(){
		estadoCadastro = new Estado();
	}
	
	
	public void salvar(){
		try {
			EstadoDAO edao = new EstadoDAO();
			edao.salvar(estadoCadastro);
			estadoCadastro = new Estado();
			FacesUtil.addMsgInfo("Dados salvos com sucesso!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar os dados!");
		}
	}
	
	
	public void carregaPesquisa(){
		try {
			lista = edao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar listar os dados!");
		}
	}
	
	
	public void carregarCadastro() {
		try {
			if (codigo != null) {
				EstadoDAO edao = new EstadoDAO();
				estadoCadastro = edao.buscarPorCodigo(codigo);
			} else {
				estadoCadastro = new Estado();
			}
			lista = edao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados!");
		}
	}

	
	public void excluir() {
		try {
			edao.excluir(estadoCadastro);
			FacesUtil.addMsgInfo("Dados excluidos com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar excluir os dados!");
		}
	}

	
	public void editar() {
		try {
			edao.editar(estadoCadastro);
			FacesUtil.addMsgInfo("TDados editados com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar editar os dados!");
		}
	}
}