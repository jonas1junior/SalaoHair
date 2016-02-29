package br.com.sh.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.PessoaDAO;
import br.com.sh.main.negocio.Pessoa;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class PessoaBean {
	
	private Pessoa psCadastro;
	private List<Pessoa> lista;
	private List<Pessoa> listaFiltro;
	private String acao;
	private int codigo;
	
	PessoaDAO pdao = new PessoaDAO();
	
	
	public Pessoa getPsCadastro() {
		return psCadastro;
	}
	public void setPsCadastro(Pessoa psCadastro) {
		this.psCadastro = psCadastro;
	}
	public List<Pessoa> getLista() {
		return lista;
	}
	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}
	public List<Pessoa> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Pessoa> listaFiltro) {
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
		psCadastro = new Pessoa();
	}
	
	
	public void salvar(){
		try{
			pdao.salvar(psCadastro);
			psCadastro = new Pessoa();
			FacesUtil.addMsgInfo("Pessoa salvo com sucesso!");
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar a pessoa!");
		}
	}
	
	
	public void carregaPesquisa(){
		try{
			lista = pdao.listar();
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar listar as pessoas");
		}
	}
	
	
	public void carregarCadastro(){
		try{
			if (codigo <= 0) {
				psCadastro = pdao.buscarPorCodigo(codigo);
			}else {
				psCadastro = new Pessoa();
			}
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar obter os dados da pessoa!");
		}
	}
	
	
	public void excluir(){
		try{
			pdao.excluir(psCadastro);
			FacesUtil.addMsgInfo("Pessoa excluido com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar excluir s pessoa!");
		}
	}
	
	
	public void editar(){
		try{
			pdao.editar(psCadastro);
			FacesUtil.addMsgInfo("Pessoa editado com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar editar a pessoa!");
		}
	}
}