package br.com.sh.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sh.dao.AgendamentoDAO;
import br.com.sh.main.negocio.Agendamento;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ServicoBean {

	private Agendamento svCadastro;
	private List<Agendamento> lista;
	private List<Agendamento> listaFiltro;
	private String acao;
	private int codigo;
	
	AgendamentoDAO svdao = new AgendamentoDAO();
	
	
	public Agendamento getFunCadastro() {
		return svCadastro;
	}
	public void setSvCadastro(Agendamento svCadastro) {
		this.svCadastro = svCadastro;
	}
	public List<Agendamento> getLista() {
		return lista;
	}
	public void setLista(List<Agendamento> lista) {
		this.lista = lista;
	}
	public List<Agendamento> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Agendamento> listaFiltro) {
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
		svCadastro = new Agendamento();
	}
	
	
	public void salvar(){
		try{
			svdao.salvar(svCadastro);
			svCadastro = new Agendamento();
			FacesUtil.addMsgInfo("Serviço salvo com sucesso!");
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar o serviço!");
		}
	}
	
	
	public void carregaPesquisa(){
		try{
			lista = svdao.listar();
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar listar os serviços");
		}
	}
	
	
	public void carregarCadastro(){
		try{
			
			if (codigo <= 0) {
				svCadastro = svdao.buscarPorCodigo(codigo);
			}else {
				svCadastro = new Agendamento();
			}
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar obter os dados do serviço!");
		}
	}
	
	
	public void excluir(){
		try{
			svdao.excluir(svCadastro);
			FacesUtil.addMsgInfo("Serviço excluido com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar excluir o serviço!");
		}
	}
	
	
	public void editar(){
		try{
			svdao.editar(svCadastro);
			FacesUtil.addMsgInfo("Serviço editado com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar editar o serviço!");
		}
	}
}