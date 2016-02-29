package br.com.sh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sh.main.negocio.Documento;
import br.com.sh.util.HibernateUtil;

public class DocumentoDAO {

	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	List<Documento> documentos = null;
	private Documento documento;
	
	public void salvar(Documento documento){
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(documento);
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
	public List<Documento> listar(){
		try {
			Query consulta = sessao.getNamedQuery("Documento.listar");
			documentos = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return documentos;
	}
	
	public Documento buscarPorCodigo(int codigo) {

		try {
			Query consulta = sessao.getNamedQuery("Documento.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);

			documento = (Documento) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return documento;
	}

	public void excluir(Documento documento) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(documento);
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
	
	public void editar(Documento documento) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(documento);
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