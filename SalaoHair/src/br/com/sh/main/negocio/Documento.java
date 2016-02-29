package br.com.sh.main.negocio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SH_DOCUMENTO")
@NamedQueries({
	@NamedQuery(name = "Documento.listar",
				query = "SELECT documento FROM Documento documento"),
	@NamedQuery(name = "Documento.buscarPorCodigo",
				query = "SELECT documento FROM Documento documento WHERE documento.codigo = :codigo")
})
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_DOCUMENTO")
	private int codigo;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "ENTRDA", nullable = false)
	private Date dtEntrada;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "SAIDA")
	private Date dtSaida;
	
	@Column(name = "NUNERO_CT", length = 10, nullable = false)
	private String nmCarteira;
	
	@Column(name = "SERIE_CT", length = 10, nullable = false)
	private String nmSerie;
	
	@Column(name = "RG", length = 15, nullable = false)
	private String rg;
	
	@Column(name = "CNH", length = 15)
	private String cnh;
	
	@Column(name = "TILULO_ELEITOR", length = 15)
	private String tituloEleitor;
	
	@Column(name = "PIS", length = 20)
	private String pis;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	public Date getDtSaida() {
		return dtSaida;
	}
	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}
	public String getNmCarteira() {
		return nmCarteira;
	}
	public void setNmCarteira(String nmCarteira) {
		this.nmCarteira = nmCarteira;
	}
	public String getNmSerie() {
		return nmSerie;
	}
	public void setNmSerie(String nmSerie) {
		this.nmSerie = nmSerie;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getTituloEleitor() {
		return tituloEleitor;
	}
	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}
	public String getPis() {
		return pis;
	}
	public void setPis(String pis) {
		this.pis = pis;
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
		Documento other = (Documento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "\nDocumentos" 
				+ "\nData de admição: " + dtEntrada
				+ "\nData de demição: " + dtSaida
				+ "\nNº da carteira de trabalho: " + nmCarteira
				+ "\nSérie da carteira de trabalho: " + nmSerie
				+ "\nNúmero do RG: " + rg
				+ "\nNúmero da CNH: " + cnh
				+ "\nNúmero do Titulo de eleitor: " + tituloEleitor
				+ "\nNúmero do PIS: " + pis;
	}
}