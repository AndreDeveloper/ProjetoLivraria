package entity;

public class ClienteEntity extends EnderecoEntity{
	private int CodCliente;
	private String nome;
	private String cpf;
	private String rg;
	private String sexo;
	private String email;
	private String telefone;
	private String celular;
	private String senha;
	
	
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public int getCodCliente() {
		return CodCliente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}


	@Override
	public String toString() {
		return "ClienteEntity [CodCliente=" + CodCliente + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", sexo="
				+ sexo + ", email=" + email + ", telefone=" + telefone + ", celular=" + celular + "]";
	}



	
	
}
