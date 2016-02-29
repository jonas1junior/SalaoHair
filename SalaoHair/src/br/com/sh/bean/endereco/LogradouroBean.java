package br.com.sh.bean.endereco;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.endereco.LogradouroDAO;
import br.com.sh.main.endereco.Logradouro;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class LogradouroBean {
	
	private Logradouro logradouroCadastro;
	private List<Logradouro> lista;
	private List<Logradouro> listaFiltro;
	private String acao;
	private int codigo;
	
	LogradouroDAO ldao = new LogradouroDAO();
	
	
	public Logradouro getLogradouroCadastro() {
		return logradouroCadastro;
	}
	public void setLogradouroCadastro(Logradouro logradouroCadastro) {
		this.logradouroCadastro = logradouroCadastro;
	}
	public List<Logradouro> getLista() {
		return lista;
	}
	public void setLista(List<Logradouro> lista) {
		this.lista = lista;
	}
	public List<Logradouro> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Logradouro> listaFiltro) {
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
	
	
	public void novo(){
		logradouroCadastro = new Logradouro();
	}
	
	
	public void salvar(){
		
		try {
			ldao.salvar(logradouroCadastro);
			logradouroCadastro = new Logradouro();
			FacesUtil.addMsgInfo("Dados salvos com sucesso!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar os dados!");
		}
	}
	
	
	public void carregaPesquisa(){
		try {
			lista = ldao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar listar os dados!");
		}
	}
	
	
	public void carregarCadastro() {
		try {

			if (codigo <= 0) {
				logradouroCadastro = ldao.buscarPorCodigo(codigo);
			} else {
				logradouroCadastro = new Logradouro();
			}
			lista = ldao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados!");
		}
	}

	
	public void excluir() {
		try {
			ldao.excluir(logradouroCadastro);
			FacesUtil.addMsgInfo("Dados excluidos com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar excluir os dados!");
		}
	}

	
	public void editar() {
		try {
			ldao.editar(logradouroCadastro);
			FacesUtil.addMsgInfo("TDados editados com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar editar os dados!");
		}
	}
}