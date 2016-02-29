package br.com.sh.main.negocio;

import java.util.Date;
import java.util.List;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SH_AGENDAMENTO")
@NamedQueries({
	@NamedQuery(name = "Agendamento.listar",
				query = "SELECT agendamento FROM Agendamento agendamento"),
	@NamedQuery(name = "Agendamento.buscarPorCodigo",
				query = "SELECT agendamento FROM Agendamento agendamento "
						+ "WHERE agendamento.codigo = :codigo")
})
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_AGENDAMENTO")
	private int codigo;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DT_AGENDAMENTO", nullable = false)
	private Date dtAgendamento;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DT_EXECUCAO", nullable = false)
	private Date dtExecucao;
	
	@Column(name = "VALOR", precision = 8, scale = 2, length = 10,
			nullable = false)
	private double valor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_SERVICO", referencedColumnName = "CD_SERVICO",
				nullable = false)
	private Servico servico;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_ITEM", referencedColumnName = "CD_ITEM")
	private List<Item> itens;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_FUNCIONARIO", referencedColumnName = "CD_FUNCIONARIO",
				nullable = false)
	private Funcionario funcionario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_CLIENTE", referencedColumnName = "CD_CLIENTE",
				nullable = false)
	private Cliente cliente;
	
	
	public int getCodigo() {
		return codigo;
	}
	public Date getDtAgendamento() {
		return dtAgendamento;
	}
	public void setDtAgendamento(Date dtAgendamento) {
		this.dtAgendamento = dtAgendamento;
	}
	public Date getDtExecucao() {
		return dtExecucao;
	}
	public void setDtExecucao(Date dtExecucao) {
		this.dtExecucao = dtExecucao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	@Override
	public String toString() {
		return "Código: =" + codigo
				+ "Funcionário: " + funcionario
				+ "Cliente: " + cliente
				+ "Agendamento em: " + dtAgendamento
				+ "Marcado para: " + dtExecucao
				+ "Servico: " + servico
				+ "Produtos: " + itens
				+ "Valor" + valor;
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
		Agendamento other = (Agendamento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}