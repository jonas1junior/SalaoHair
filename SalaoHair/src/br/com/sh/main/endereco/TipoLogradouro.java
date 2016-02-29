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
@Table(name = "SH_TIPO_LOGRADOURO")
@NamedQueries({
	@NamedQuery(name = "TipoLogradouro.listar",
				query = "SELECT tipoLogradouro FROM TipoLogradouro tipoLogradouro"),
	@NamedQuery(name = "TipoLogradouro.buscarPorCodigo",
				query = "SELECT tipoLogradouro FROM TipoLogradouro tipoLogradouro WHERE tipoLogradouro.codigo = :codigo")
})
public class TipoLogradouro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_TIPOLOG")
	private int codigo;
	
	@Column(name = "DESCRICAO", length = 10, nullable = false)
	private String descricao;
	

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		TipoLogradouro other = (TipoLogradouro) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return  descricao;
	}
}