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
@Table(name = "SH_BAIRRO")
@NamedQueries({
	@NamedQuery(name = "Bairro.listar",
				query = "SELECT bairro FROM Bairro bairro"),
	@NamedQuery(name = "Bairro.buscarPorCodigo",
				query = "SELECT bairro FROM Bairro bairro WHERE bairro.codigo = :codigo")
})
public class Bairro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_BAIRRO")
	private int codigo;
	
	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;

	@NotNull(message = "O campo Cidade é obrigatorio!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_CIDADE", referencedColumnName = "CD_CIDADE", nullable = false)
	private Cidade cidade;
	
	
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
	@Override
	public String toString() {
		return "Bairro: " + descricao
				+ "\n" + cidade;
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
		Bairro other = (Bairro) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}