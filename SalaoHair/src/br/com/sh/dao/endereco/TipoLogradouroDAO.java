package br.com.sh.dao.endereco;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.endereco.TipoLogradouro;
import br.com.sh.util.HibernateUtil;

public class TipoLogradouroDAO {
	
	public void salvar(TipoLogradouro tipoLogradouro){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(tipoLogradouro);
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
	public List<TipoLogradouro> listar(){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<TipoLogradouro> tipoLogradouros = null;
		
		try {
			Query consulta = sessao.getNamedQuery("TipoLogradouro.listar");
			tipoLogradouros = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return tipoLogradouros;
	}
	
	public TipoLogradouro buscarPorCodigo(int codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		TipoLogradouro tipoLogradouro;

		try {
			Query consulta = sessao.getNamedQuery("TipoLogradouro.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			tipoLogradouro = (TipoLogradouro) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return tipoLogradouro;
	}

	public void excluir(TipoLogradouro tipoLogradouro) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(tipoLogradouro);
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
	
	public void editar(TipoLogradouro tipoLogradouro) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(tipoLogradouro);
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