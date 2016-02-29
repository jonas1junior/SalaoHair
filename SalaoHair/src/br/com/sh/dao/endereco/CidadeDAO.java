package br.com.sh.dao.endereco;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.endereco.Cidade;
import br.com.sh.util.HibernateUtil;

public class CidadeDAO {

	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	List<Cidade> cidades = null;
	private Cidade cidade;
	
	public void salvar(Cidade cidade){
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(cidade);
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
	public List<Cidade> listar(){
		try {
			Query consulta = sessao.getNamedQuery("Cidade.listar");
			cidades = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return cidades;
	}
	
	public Cidade buscarPorCodigo(Long codigo) {

		try {
			Query consulta = sessao.getNamedQuery("Cidade.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			cidade = (Cidade) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return cidade;
	}

	public void excluir(Cidade cidade) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(cidade);
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
	
	public void editar(Cidade cidade) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(cidade);
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