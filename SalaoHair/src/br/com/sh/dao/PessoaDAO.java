package br.com.sh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.negocio.Pessoa;
import br.com.sh.util.HibernateUtil;

public class PessoaDAO {

	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	List<Pessoa> pessoas = null;
	private Pessoa pessoa;
	
	public void salvar(Pessoa pessoa){
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(pessoa);
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
	public List<Pessoa> listar(){
		try {
			Query consulta = sessao.getNamedQuery("Pessoa.listar");
			pessoas = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return pessoas;
	}
	
	public Pessoa buscarPorCodigo(int codigo) {

		try {
			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			pessoa = (Pessoa) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return pessoa;
	}

	public void excluir(Pessoa pessoa) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(pessoa);
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
	
	public void editar(Pessoa pessoa) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(pessoa);
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