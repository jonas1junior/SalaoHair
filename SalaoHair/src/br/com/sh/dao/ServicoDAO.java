package br.com.sh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.negocio.Servico;
import br.com.sh.util.HibernateUtil;

public class ServicoDAO {
	
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	List<Servico> servicos = null;
	private Servico servico ;
	
	public void salvar(Servico servico){
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(servico);
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
	public List<Servico> listar(){
		try {
			Query consulta = sessao.getNamedQuery("Servico.listar");
			servicos = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return servicos;
	}
	
	public Servico buscarPorCodigo(int codigo) {

		try {
			Query consulta = sessao.getNamedQuery("Servico.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			servico = (Servico) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return servico;
	}

	public void excluir(Servico servico) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(servico);
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
	
	public void editar(Servico servico) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(servico);
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
