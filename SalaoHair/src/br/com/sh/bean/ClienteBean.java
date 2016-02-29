package br.com.sh.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.ClienteDAO;
import br.com.sh.main.negocio.Cliente;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteBean {

	private Cliente cliCadastro;
	private List<Cliente> lista;
	private List<Cliente> listaFiltro;
	private String acao;
	private int codigo;
	
	ClienteDAO cdao = new ClienteDAO();
	
	
	public Cliente getCliCadastro() {
		return cliCadastro;
	}
	public void setCliCadastro(Cliente cliCadastro) {
		this.cliCadastro = cliCadastro;
	}
	public List<Cliente> getLista() {
		return lista;
	}
	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}
	public List<Cliente> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Cliente> listaFiltro) {
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
		cliCadastro = new Cliente();
	}
	
	
	public void salvar(){
		try{
			cdao.salvar(cliCadastro);
			cliCadastro = new Cliente();
			FacesUtil.addMsgInfo("Cliente salvo com sucesso!");
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar o cliente!");
		}
	}
	
	
	public void carregaPesquisa(){
		try{
			lista = cdao.listar();
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar listar os clientes");
		}
	}
	
	
	public void carregarCadastro(){
		try{
			if (codigo <= 0) {
				cliCadastro = cdao.buscarPorCodigo(codigo);
			}else {
				cliCadastro = new Cliente();
			}
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar obter os dados do cliente!");
		}
	}
	
	
	public void excluir(){
		try{
			cdao.excluir(cliCadastro);
			FacesUtil.addMsgInfo("Cliente excluido com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar excluir o cliente!");
		}
	}
	
	
	public void editar(){
		try{
			cdao.editar(cliCadastro);
			FacesUtil.addMsgInfo("Cliente editado com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar editar o cliente!");
		}
	}
}