package br.com.sh.dao.endereco;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.endereco.Logradouro;
import br.com.sh.util.HibernateUtil;

public class LogradouroDAO {
	
	public void salvar(Logradouro logradouro){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(logradouro);
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
	public List<Logradouro> listar(){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Logradouro> logradouros = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Logradouro.listar");
			logradouros = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return logradouros;
	}
	
	public Logradouro buscarPorCodigo(int codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Logradouro logradouro;

		try {
			Query consulta = sessao.getNamedQuery("Logradouro.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			logradouro = (Logradouro) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return logradouro;
	}

	public void excluir(Logradouro logradouro) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(logradouro);
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
	
	public void editar(Logradouro logradouro) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(logradouro);
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