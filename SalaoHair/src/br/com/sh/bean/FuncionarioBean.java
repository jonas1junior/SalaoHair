package br.com.sh.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.sh.dao.FuncionarioDAO;
import br.com.sh.main.negocio.Funcionario;
import br.com.sh.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {

	private Funcionario funCadastro;
	private List<Funcionario> lista;
	private List<Funcionario> listaFiltro;
	private String acao;
	private int codigo;
	
	FuncionarioDAO fdao = new FuncionarioDAO();
	
	
	public Funcionario getFunCadastro() {
		return funCadastro;
	}
	public void setFunCadastro(Funcionario funCadastro) {
		this.funCadastro = funCadastro;
	}
	public List<Funcionario> getLista() {
		return lista;
	}
	public void setLista(List<Funcionario> lista) {
		this.lista = lista;
	}
	public List<Funcionario> getListaFiltro() {
		return listaFiltro;
	}
	public void setListaFiltro(List<Funcionario> listaFiltro) {
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
		funCadastro = new Funcionario();
	}
	
	
	public void salvar(){
		try{
			funCadastro.setSenha(DigestUtils.md5Hex(funCadastro.getSenha()));
			fdao.salvar(funCadastro);
			funCadastro = new Funcionario();
			FacesUtil.addMsgInfo("Funcionário salvo com sucesso!");
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar salvar o funcionário!");
		}
	}
	
	
	public void carregaPesquisa(){
		try{
			lista = fdao.listar();
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar listar os funcionário");
		}
	}
	
	
	public void carregarCadastro(){
		try{
			
			if (codigo <= 0) {
				funCadastro = fdao.buscarPorCodigo(codigo);
			}else {
				funCadastro = new Funcionario();
			}
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar obter os dados do funcionário!");
		}
	}
	
	
	public void excluir(){
		try{
			fdao.excluir(funCadastro);
			FacesUtil.addMsgInfo("Funcionário excluido com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar excluir o funcionário!");
		}
	}
	
	
	public void editar(){
		try{
			funCadastro.setSenha(DigestUtils.md5Hex(funCadastro.getSenha()));
			fdao.editar(funCadastro);
			FacesUtil.addMsgInfo("Funcionário editado com sucesso!");
		}catch(RuntimeException e){
			FacesUtil.addMsgError("Erro ao tentar editar o funcionário!");
		}
	}
}