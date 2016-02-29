package br.com.sh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.negocio.Agendamento;
import br.com.sh.util.HibernateUtil;

public class AgendamentoDAO {

	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	List<Agendamento> agendamentos = null;
	private Agendamento agendamento ;
	
	public void salvar(Agendamento agendamento){
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(agendamento);
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
	public List<Agendamento> listar(){
		try {
			Query consulta = sessao.getNamedQuery("Servico.listar");
			agendamentos = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return agendamentos;
	}
	
	public Agendamento buscarPorCodigo(int codigo) {

		try {
			Query consulta = sessao.getNamedQuery("Servico.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			agendamento = (Agendamento) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return agendamento;
	}

	public void excluir(Agendamento agendamento) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(agendamento);
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
	
	public void editar(Agendamento agendamento) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(agendamento);
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