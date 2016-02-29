package br.com.sh.main.negocio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "SH_PRODUTO")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_PRODUTO")
	private int codigo;

	@NotEmpty(message = "O campo descrição é obrigatorio!")
	@Size(min = 5 , max = 50 , message = "A descrição deve conter entre 5 e 50 caracteres!")
	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;
	
	@Column(name = "VALOR", precision = 8, scale = 2, length = 10, nullable = false)
	@NotNull(message = "O campo valor é obrigatorio!")
	@DecimalMin(value = "0.0" , message = "O valor deve conter um número positivo!")
	@DecimalMax(value = "99999.99", message = "O valor deve ser menor que 100.000,00!")
	@Digits(integer = 5, fraction = 2, message = "Informe um valor válido para o preço:")
	private double valor;

	@NotNull(message = "O campo quantidade é obrigatorio!")
	@Min(value = 0 , message = "A quantidade deve conter um número positivo!")
	@Max(value = 9999, message = "A quantidade deve conter um número menor que 10.000!")
	@Column(name = "QTD", nullable = false)
	private int quantidade;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "ENTRDA", nullable = false)
	private Date dtEntrada;

	@NotNull(message = "O campo fabricante é obrigatorio!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_FABRICANTE", referencedColumnName = "CD_FABRICANTE", nullable = false)
	private Fabricante fabricante;
	
	
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Date getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	
	@Override
	public String toString() {
		return "Código do produto: " + codigo
				+ "\nDescrição: " + descricao
				+ "\nPreço: " + valor 
				+ "\nQuantidade: " + quantidade
				+ "\nData deentrada: " + dtEntrada 
				+ "\nFabricante: " + fabricante;
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
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}