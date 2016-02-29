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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "SH_FUNCIONARIO")
@NamedQueries({
	@NamedQuery(name = "Funcionario.listar",
				query = "SELECT funcionario FROM Funcionario funcionario"),
	@NamedQuery(name = "Funcionario.buscarPorCodigo",
				query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.codigo = :codigo"),
	@NamedQuery(name = "Funcionario.autenticar",
				query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.pessoa.cpf = :cpf AND funcionario.senha = :senha")
})
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_FUNCIONARIO")
	private int codigo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_PESSOA", referencedColumnName = "CD_PESSOA")
	private Pessoa pessoa;
	
	@NotEmpty(message = "O campo senha é obrigatorio!")
	@Size(min = 6 , max = 32 , message = "A senha deve conter entre 6 e 8 caracteres!")
	@Column(name = "SENHA", length = 32, nullable = false)
	private String senha;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_FUNCAO", referencedColumnName = "CD_FUNCAO")
	private Funcao funcao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_DOCUMENTO", referencedColumnName = "CD_DOCUMENTO")
	private Documento documentos;
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Documento getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Documento documentos) {
		this.documentos = documentos;
	}

	
	@Override
	public String toString() {
		return  "Código: " + codigo
				+ "\n" + pessoa
				+ "\nSenha: " + senha
				+ "\nFunção: " + funcao
				+ "\nDocumentos"
				+ "\n" + documentos;
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
		Funcionario other = (Funcionario) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}