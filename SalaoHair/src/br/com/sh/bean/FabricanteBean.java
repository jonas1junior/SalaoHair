package br.com.sh.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.FabricanteDAO;
import br.com.sh.main.negocio.Fabricante;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {
	
	private Fabricante fabCadastro;
	private List<Fabricante> lista;
	private List<Fabricante> listaFiltro;
	private String acao;
	private int codigo;

	FabricanteDAO fdao = new FabricanteDAO();
	
	
	public Fabricante getFabCadastro() {
		return fabCadastro;
	}
	public void setFabCadastro(Fabricante fabCadastro) {
		this.fabCadastro = fabCadastro;
	}
	public List<Fabricante> getLista() {
		return lista;
	}
	public void setLista(List<Fabricante> lista) {
		this.lista = lista;
	}
	public List<Fabricante> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Fabricante> listaFiltro) {
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
		fabCadastro = new Fabricante();
	}
	
	
	public void salvar(){
		try{
			fdao.salvar(fabCadastro);
			fabCadastro = new Fabricante();
			FacesUtil.addMsgInfo("Fabricante salvo com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar salvar o fabricante!");
		}
	}
	
	
	public void carregaPesquisa(){
		try{
			lista = fdao.listar();
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar listar os fabricantes");
		}
	}
	
	
	public void carregarCadastro(){
		try{
			
			if (codigo <= 0) {
				fabCadastro = fdao.buscarPorCodigo(codigo);
			}else {
				fabCadastro = new Fabricante();
			}
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar obter os dados do fabricante!");
		}
	}
	
	
	public void excluir(){
		try{
			fdao.excluir(fabCadastro);
			FacesUtil.addMsgInfo("Fabricante excluido com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar excluir o fabricante!");
		}
	}
	
	
	public void editar(){
		try{
			fdao.editar(fabCadastro);
			FacesUtil.addMsgInfo("Fabricante editado com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar editar o fabricante!");
		}
	}
}