package br.com.sh.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.ContatoDAO;
import br.com.sh.main.negocio.Contato;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ContatoBean {

	private Contato ctoCadastro;
	private List<Contato> lista;
	private List<Contato> listaFiltro;
	private String acao;
	private int codigo;
	
	ContatoDAO ctodao = new ContatoDAO();
	
	
	public Contato getctoCadastro() {
		return ctoCadastro;
	}
	public void setFunCadastro(Contato ctoCadastro) {
		this.ctoCadastro = ctoCadastro;
	}
	public List<Contato> getLista() {
		return lista;
	}
	public void setLista(List<Contato> lista) {
		this.lista = lista;
	}
	public List<Contato> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Contato> listaFiltro) {
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
		ctoCadastro = new Contato();
	}
	
	
	public void salvar(){
		try{
			ctodao.salvar(ctoCadastro);
			ctoCadastro = new Contato();
			FacesUtil.addMsgInfo("Contato salvo com sucesso!");
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar o contato!");
		}
	}
	
	
	public void carregaPesquisa(){
		try{
			lista = ctodao.listar();
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar listar os contato");
		}
	}
	
	
	public void carregarCadastro(){
		try{
			
			if (codigo <= 0) {
				ctoCadastro = ctodao.buscarPorCodigo(codigo);
			}else {
				ctoCadastro = new Contato();
			}
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar obter os dados do contato!");
		}
	}
	
	
	public void excluir(){
		try{
			ctodao.excluir(ctoCadastro);
			FacesUtil.addMsgInfo("Contato excluido com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar excluir o contato!");
		}
	}
	
	
	public void editar(){
		try{
			ctodao.editar(ctoCadastro);
			FacesUtil.addMsgInfo("Contato editado com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar editar o contato!");
		}
	}
}