package br.com.sh.dao.endereco;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.endereco.Bairro;
import br.com.sh.util.HibernateUtil;

public class BairroDAO {

	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	List<Bairro> bairros = null;
	private Bairro bairro;
	
	public void salvar(Bairro bairro){
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(bairro);
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
	public List<Bairro> listar(){
		try {
			Query consulta = sessao.getNamedQuery("Bairro.listar");
			bairros = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return bairros;
	}
	
	public Bairro buscarPorCodigo(int codigo) {

		try {
			Query consulta = sessao.getNamedQuery("Bairro.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			bairro = (Bairro) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return bairro;
	}

	public void excluir(Bairro bairro) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(bairro);
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
	
	public void editar(Bairro bairro) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(bairro);
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