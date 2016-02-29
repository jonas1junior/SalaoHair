package br.com.sh.main.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SH_CLIENTE")
@NamedQueries({
	@NamedQuery(name = "Cliente.listar",
				query = "SELECT cliente FROM Cliente cliente"),
	@NamedQuery(name = "Cliente.buscarPorCodigo",
				query = "SELECT cliente FROM Cliente cliente WHERE cliente.codigo = :codigo")
})
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_CLIENTE")
	private int codigo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_PESSOA", referencedColumnName = "CD_PESSOA")
	private Pessoa pessoa;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	@Override
	public String toString() {
		return "Cliente"
				+ "\nCódigo do cliente: " + codigo + pessoa;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Cliente other = (Cliente) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}