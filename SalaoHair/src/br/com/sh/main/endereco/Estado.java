package br.com.sh.main.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SH_ESTADO")
@NamedQueries({
	@NamedQuery(name = "Estado.listar",
				query = "SELECT estado FROM Estado estado"),
	@NamedQuery(name = "Estado.buscarPorCodigo",
				query = "SELECT estado FROM Estado estado WHERE estado.codigo = :codigo")
})
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_ESTADO")
	private int codigo;
	
	@Column(name = "DESCRICAO", length = 30, nullable = false)
	private String descricao;
	
	@Column(name = "SIGLA", length = 2, nullable = false)
	private String sigla;
	
	
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	@Override
	public String toString() {
		return "Estado: " + descricao
				+ " - " + sigla;
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
		Estado other = (Estado) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}