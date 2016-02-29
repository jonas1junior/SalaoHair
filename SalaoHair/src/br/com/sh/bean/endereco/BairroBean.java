package br.com.sh.bean.endereco;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.endereco.BairroDAO;
import br.com.sh.main.endereco.Bairro;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class BairroBean {
	
	private Bairro bairroCadastro;
	private List<Bairro> lista;
	private List<Bairro> listaFiltro;
	private String acao;
	private int codigo;
	
	BairroDAO bdao = new BairroDAO();
	
	
	public Bairro getBairroCadastro() {
		return bairroCadastro;
	}
	public void setBairroCadastro(Bairro bairroCadastro) {
		this.bairroCadastro = bairroCadastro;
	}
	public List<Bairro> getLista() {
		return lista;
	}
	public void setLista(List<Bairro> lista) {
		this.lista = lista;
	}
	public List<Bairro> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Bairro> listaFiltro) {
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
		bairroCadastro = new Bairro();
	}
	
	
	public void salvar(){
		
		try {
			bdao.salvar(bairroCadastro);
			bairroCadastro = new Bairro();
			FacesUtil.addMsgInfo("Dados salvos com sucesso!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar os dados!");
		}
	}
	
	
	public void carregaPesquisa(){
		try {
			lista = bdao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar listar os dados!");
		}
	}
	
	
	public void carregarCadastro() {
		try {

			if (codigo <= 0) {
				bairroCadastro = bdao.buscarPorCodigo(codigo);
			} else {
				bairroCadastro = new Bairro();
			}
			lista = bdao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados!");
		}
	}

	
	public void excluir() {
		try {
			bdao.excluir(bairroCadastro);
			FacesUtil.addMsgInfo("Dados excluidos com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar excluir os dados!");
		}
	}

	
	public void editar() {
		try {
			bdao.editar(bairroCadastro);
			FacesUtil.addMsgInfo("TDados editados com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar editar os dados!");
		}
	}
}