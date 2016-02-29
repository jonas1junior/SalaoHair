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
@Table(name = "SH_ITEM")
@NamedQueries({
	@NamedQuery(name = "Item.listar",
				query = "SELECT item FROM Item item"),
	@NamedQuery(name = "Item.buscarPorCodigo",
				query = "SELECT item FROM Item item WHERE item.codigo = :codigo")
})
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_ITEM")
	private int codigo;

	@Column(name = "SUB_TOTAL", precision = 8, scale = 2, nullable = false)
	private double subTotal;

	@Column(name = "QTD_ITEM", nullable = false)
	private int quantidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_PRODUTO", referencedColumnName = "CD_PRODUTO", nullable = false)
	private Produto produto;

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	@Override
	public String toString() {
		return "Item [codigo=" + codigo + ", subTotal=" + subTotal
				+ ", quantidade=" + quantidade + ", produto=" + produto + "]";
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
		Item other = (Item) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}