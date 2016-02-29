package br.com.sh.bean.endereco;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.endereco.CidadeDAO;
import br.com.sh.main.endereco.Cidade;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CidadeBean {
	
	private Cidade cidadeCadastro;
	private List<Cidade> lista;
	private List<Cidade> listaFiltro;
	private String acao;
	private Long codigo;
	
	CidadeDAO cdao = new CidadeDAO();
	
	
	public Cidade getCidadeCadastro() {
		return cidadeCadastro;
	}
	public void setCidadeCadastro(Cidade cidadeCadastro) {
		this.cidadeCadastro = cidadeCadastro;
	}
	public List<Cidade> getLista() {
		return lista;
	}
	public void setLista(List<Cidade> lista) {
		this.lista = lista;
	}
	public List<Cidade> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Cidade> listaFiltro) {
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
		cidadeCadastro = new Cidade();
	}
	
	
	public void salvar(){
		
		try {
			cdao.salvar(cidadeCadastro);
			cidadeCadastro = new Cidade();
			FacesUtil.addMsgInfo("Dados salvos com sucesso!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar os dados!");
		}
	}
	
	
	public void carregaPesquisa(){
		try {
			lista = cdao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar listar os dados!");
		}
	}
	
	
	public void carregarCadastro() {
		try {
			if (codigo != null) {
				cidadeCadastro = cdao.buscarPorCodigo(codigo);
			} else {
				cidadeCadastro = new Cidade();
			}
			lista = cdao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados!");
		}
	}

	
	public void excluir() {
		try {
			cdao.excluir(cidadeCadastro);
			FacesUtil.addMsgInfo("Dados excluidos com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar excluir os dados!");
		}
	}

	
	public void editar() {
		try {
			cdao.editar(cidadeCadastro);
			FacesUtil.addMsgInfo("TDados editados com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar editar os dados!");
		}
	}
}