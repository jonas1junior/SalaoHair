package br.com.sh.main.endereco;

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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SH_ENDERECO")
@NamedQueries({
	@NamedQuery(name = "Endereco.listar",
				query = "SELECT endereco FROM Endereco endereco"),
	@NamedQuery(name = "Endereco.buscarPorCodigo",
				query = "SELECT endereco FROM Endereco endereco "
						+ "WHERE endereco.codigo = :codigo")
})
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_ENDERECO")
	private int codigo;
	
	@NotNull(message = "O campo Bairro é obrigatorio!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_BAIRRO", referencedColumnName = "CD_BAIRRO",
				nullable = false)
	private Bairro bairro;
	
	@NotNull(message = "O campo Logradouro é obrigatorio!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_LOGRADOURO", referencedColumnName = "CD_LOGRADOURO",
				nullable = false)
	private Logradouro logradouro;
	
	
	public int getCodigo() {
		return codigo;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public Logradouro getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
	
	
	@Override
	public String toString() {
		return "Endereco"
				+ "\n" + logradouro
				+ "\n" + bairro;
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
		Endereco other = (Endereco) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}