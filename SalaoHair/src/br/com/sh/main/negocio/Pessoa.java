package br.com.sh.main.negocio;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import br.com.sh.main.endereco.Endereco;

@Entity
@Table(name = "SH_PESSOA")
@NamedQueries({
	@NamedQuery(name = "Pessoa.listar",
				query = "SELECT pessoa FROM Pessoa pessoa"),
	@NamedQuery(name = "Pessoa.buscarPorCodigo",
				query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.codigo = :codigo")
})
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_PESSOA")
	private int codigo;
	
	@NotEmpty(message = "O campo nome é obrigatorio!")
	@Size(min = 5 , max = 20 , message = "O nome deve conter entre 5 e 20 caracteres!")
	@Column(name = "NOME", length = 20, nullable = false)
	private String nome;
	
	@NotEmpty(message = "O campo sobrenome é obrigatorio!")
	@Size(min = 5 , max = 50 , message = "O sobrenome deve conter entre 5 e 50 caracteres!")
	@Column(name = "SOBRE_NOME", length = 50, nullable = false)
	private String sobreNome;
	
	@CPF(message = "O campo CPF é obrigatorio!")
	@Column(name = "CPF", length = 14, nullable = false, unique = true)
	private String cpf;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_CONTATO", referencedColumnName = "CD_CONTATO")
	private Contato contato;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_ENDERECO", referencedColumnName = "CD_ENDERECO")
	private Endereco endereco;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "FOTO")
	private byte[] foto;

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
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
		Pessoa other = (Pessoa) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return  "Foto=" + Arrays.toString(foto)
				+ "\nNome: " + nome + " " + sobreNome
				+ "\nCPF: " + cpf
				+ "\n" + contato
				+ "\nEndereço: " + endereco;
	}
}