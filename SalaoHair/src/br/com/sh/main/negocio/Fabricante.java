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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.sh.main.endereco.Endereco;

@Entity
@Table(name = "SH_FABRICANTE")
@NamedQueries({
	@NamedQuery(name = "Fabricante.listar",
				query = "SELECT fabricante FROM Fabricante fabricante"),
	@NamedQuery(name = "Fabricante.buscarPorCodigo",
				query = "SELECT fabricante FROM Fabricante fabricante WHERE fabricante.codigo = :codigo")
})
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_FABRICANTE")
	private int codigo;
	
	@NotEmpty(message = "O campo fabricante é obrigatorio!")
	@Size(min = 5 , max = 50 , message = "O fabricante deve conter entre 5 e 50 caracteres!")
	@Column(name = "FABRICANTE", length = 50, nullable = false)
	private String descricao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_CONTATO", referencedColumnName = "CD_CONTATO")
	private Contato contato;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_ENDERECO", referencedColumnName = "CD_ENDERECO")
	private Endereco endereco;
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", descricao=" + descricao
				+ ", contato=" + contato + ", endereco=" + endereco + "]";
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
		Fabricante other = (Fabricante) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}