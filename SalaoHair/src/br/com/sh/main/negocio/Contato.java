package br.com.sh.main.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SH_CONTATO")
@NamedQueries({
	@NamedQuery(name = "Contato.listar",
				query = "SELECT contato FROM Contato contato"),
	@NamedQuery(name = "Contato.buscarPorCodigo",
				query = "SELECT contato FROM Contato contato WHERE contato.codigo = :codigo")
})
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_CONTATO")
	private int codigo;
	
	@Column(name = "DDD", length = 2)
	private int ddd;
	
	@Column(name = "CELULAR", length = 9)
	private int celular;
	
	@Column(name = "TRABALHO", length = 9)
	private int trabalho;
	
	@Column(name = "RESIDENCIAL", length = 8, nullable = false)
	private int residencial;
	
	@Column(name = "EMAIL", length = 40)
	private String email;
	
	@Column(name = "SOCIAL", length = 40)
	private String social;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public int getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(int trabalho) {
		this.trabalho = trabalho;
	}
	public int getResidencial() {
		return residencial;
	}
	public void setResidencial(int residencial) {
		this.residencial = residencial;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSocial() {
		return social;
	}
	public void setSocial(String social) {
		this.social = social;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + celular;
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (celular != other.celular)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Contatos"
				+ "\nDDD" + ddd
				+ "\nCelular: " + celular
				+ "\nTrabalho: " + trabalho
				+ "\nResidencial: " + residencial
				+ "\nE-mail: " + email
				+ "\nRede social: " + social;
	}
}