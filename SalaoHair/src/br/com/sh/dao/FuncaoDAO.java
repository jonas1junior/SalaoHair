package br.com.sh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.negocio.Funcao;
import br.com.sh.util.HibernateUtil;

public class FuncaoDAO {

	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	List<Funcao> funcoes = null;
	private Funcao funcao;
	
	public void salvar(Funcao funcao){
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(funcao);
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
	public List<Funcao> listar(){
		try {
			Query consulta = sessao.getNamedQuery("Funcao.listar");
			funcoes = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return funcoes;
	}
	
	public Funcao buscarPorCodigo(int codigo) {

		try {
			Query consulta = sessao.getNamedQuery("Funcao.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			funcao = (Funcao) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return funcao;
	}

	public void excluir(Funcao funcao) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(funcao);
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
	
	public void editar(Funcao funcao) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(funcao);
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