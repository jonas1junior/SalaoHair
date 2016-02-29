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
@Table(name = "SH_LOGRADOURO")
@NamedQueries({
	@NamedQuery(name = "Logradouro.listar",
				query = "SELECT logradouro FROM Logradouro logradouro"),
	@NamedQuery(name = "Logradouro.buscarPorCodigo",
				query = "SELECT logradouro FROM Logradouro logradouro WHERE logradouro.codigo = :codigo")
})
public class Logradouro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_LOGRADOURO")
	private int codigo;
	
	@NotNull(message = "O campo Tipo de Logradouro é obrigatorio!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_TIPOLOG", referencedColumnName = "CD_TIPOLOG", nullable = false)
	private TipoLogradouro tipoLogradouro;
	
	@Column(name = "DESCRICAO", length = 30, nullable = false)
	private String descricao;
	
	@Column(name = "NUMERO", length = 8, nullable = false)
	private int numero;
	
	@Column(name = "COMPLEMENTO", length = 15)
	private String complemento;
	
	@Column(name = "REFERENCIAS", length = 100)
	private String referencias;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getReferencias() {
		return referencias;
	}
	public void setReferencias(String referencias) {
		this.referencias = referencias;
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
		Logradouro other = (Logradouro) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "\n"
				+ tipoLogradouro + " " + descricao
				+ "\nnúmero: " + numero 
				+ "\nComplemento: " + complemento
				+ "\nEeferências: " + referencias;
	}
}