package br.com.sh.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.DocumentoDAO;
import br.com.sh.main.negocio.Documento;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class DocumentoBean {

	private Documento docCadastro;
	private List<Documento> lista;
	private List<Documento> listaFiltro;
	private String acao;
	private int codigo;
	
	DocumentoDAO docdao = new DocumentoDAO();
	
	
	public Documento getDocCadastro() {
		return docCadastro;
	}
	public void setDocCadastro(Documento docCadastro) {
		this.docCadastro = docCadastro;
	}
	public List<Documento> getLista() {
		return lista;
	}
	public void setLista(List<Documento> lista) {
		this.lista = lista;
	}
	public List<Documento> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Documento> listaFiltro) {
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
		docCadastro = new Documento();
	}
	
	
	public void salvar(){
		try{
			docdao.salvar(docCadastro);
			docCadastro = new Documento();
			FacesUtil.addMsgInfo("Documento salvo com sucesso!");
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar o documento!");
		}
	}
	
	
	public void carregaPesquisa(){
		try{
			lista = docdao.listar();
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar listar os documento");
		}
	}
	
	
	public void carregarCadastro(){
		try{
			
			if (codigo <= 0) {
			docCadastro = docdao.buscarPorCodigo(codigo);
			}else {
				docCadastro = new Documento();
			}
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar obter os dados do documento!");
		}
	}
	
	
	public void excluir(){
		try{
			docdao.excluir(docCadastro);
			FacesUtil.addMsgInfo("Documento excluido com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar excluir o documento!");
		}
	}
	
	
	public void editar(){
		try{
			docdao.editar(docCadastro);
			FacesUtil.addMsgInfo("Documento editado com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar editar o documento!");
		}
	}
}