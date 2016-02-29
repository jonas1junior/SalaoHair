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
@Table(name = "SH_CIDADE")
@NamedQueries({
	@NamedQuery(name = "Cidade.listar",
				query = "SELECT cidade FROM Cidade cidade"),
	@NamedQuery(name = "Cidade.buscarPorCodigo",
				query = "SELECT cidade FROM Cidade cidade WHERE cidade.codigo = :codigo")
})
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_CIDADE")
	private int codigo;
	
	@Column(name = "DESCRICAO", length = 30, nullable = false)
	private String descricao;

	@NotNull(message = "O campo Bairro é obrigatorio!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_ESTADO", referencedColumnName = "CD_ESTADO", nullable = false)
	private Estado estado;
	
	
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	@Override
	public String toString() {
		return "Cidade: " + descricao
				+ "\n" + estado;
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
		Cidade other = (Cidade) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}