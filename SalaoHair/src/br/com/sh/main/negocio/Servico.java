package br.com.sh.main.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "SH_SERVICO")
@NamedQueries({
	@NamedQuery(name = "Servico.listar",
				query = "SELECT servico FROM Servico servico"),
	@NamedQuery(name = "Servico.buscarPorCodigo",
				query = "SELECT servico FROM Servico servico WHERE servico.codigo = :codigo")
})
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_SERVICO")
	private int codigo;
	
	@NotEmpty(message = "O campo descrição é obrigatorio!")
	@Size(min = 5 , max = 50 , message = "O fabricante deve conter entre 5 e 50 caracteres!")
	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;
	
	
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
	
	
	@Override
	public String toString() {
		return "Servico [codigo=" + codigo + ", descricao=" + descricao + "]";
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
		Servico other = (Servico) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}