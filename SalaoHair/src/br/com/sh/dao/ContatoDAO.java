package br.com.sh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.negocio.Contato;
import br.com.sh.util.HibernateUtil;

public class ContatoDAO {

	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	List<Contato> contatos = null;
	private Contato contato;
	
	public void salvar(Contato contato){
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(contato);
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
	public List<Contato> listar(){
		try {
			Query consulta = sessao.getNamedQuery("Contato.listar");
			contatos = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return contatos;
	}
	
	public Contato buscarPorCodigo(int codigo) {

		try {
			Query consulta = sessao.getNamedQuery("Contato.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			contato = (Contato) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return contato;
	}

	public void excluir(Contato contato) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(contato);
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
	
	public void editar(Contato contato) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(contato);
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