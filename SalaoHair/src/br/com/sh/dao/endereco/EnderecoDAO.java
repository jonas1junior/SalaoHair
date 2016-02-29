package br.com.sh.dao.endereco;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.endereco.Endereco;
import br.com.sh.util.HibernateUtil;

public class EnderecoDAO {

	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	List<Endereco> enderecos = null;
	private Endereco endereco;
	
	public void salvar(Endereco endereco){
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(endereco);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Endereco> listar(){
		try {
			Query consulta = sessao.getNamedQuery("Endereco.listar");
			enderecos = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return enderecos;
	}
	
	public Endereco buscarPorCodigo(int codigo) {

		try {
			Query consulta = sessao.getNamedQuery("Endereco.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			endereco = (Endereco) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return endereco;
	}

	public void excluir(Endereco endereco) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(endereco);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}

	}
	
	public void editar(Endereco endereco) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(endereco);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}
}