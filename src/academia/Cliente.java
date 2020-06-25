package academia;

public class Cliente {

	private long id;
	private String CPF;
	private String nome;
	private String email;
	private String telefone;
	private String endereco;

	public Cliente() {
	}

	public Cliente(long id, String CPF, String nome, String email, String telefone, String endereco) {
		this.id = id;
		this.CPF = CPF;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public long getId() {
		return id;
	}

	public void setId(long iD) {
		id = iD;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
