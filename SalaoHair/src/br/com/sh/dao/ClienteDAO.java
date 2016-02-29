package br.com.sh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.negocio.Cliente;
import br.com.sh.util.HibernateUtil;

public class ClienteDAO {

	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	List<Cliente> clientes = null;
	private Cliente cliente;
	
	public void salvar(Cliente cliente){
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(cliente);
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
	public List<Cliente> listar(){
		try {
			Query consulta = sessao.getNamedQuery("Cliente.listar");
			clientes = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return clientes;
	}
	
	public Cliente buscarPorCodigo(int codigo) {

		try {
			Query consulta = sessao.getNamedQuery("Cliente.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			cliente = (Cliente) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return cliente;
	}

	public void excluir(Cliente cliente) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(cliente);
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
	
	public void editar(Cliente cliente) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(cliente);
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