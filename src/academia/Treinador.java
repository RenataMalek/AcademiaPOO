package academia;

public class Treinador {

	private long id;
	private String nome;
	private String CPF;
	private String telefone;
	private String codigoAcesso;

	public Treinador() {
	}

	public Treinador(long id, String nome, String CPF, String telefone, String codigoAcesso) {
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.telefone = telefone;
		this.codigoAcesso = codigoAcesso;
	}

	public long getId() {
		return id;
	}

	public void setId(long iD) {
		id = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCodigoAcesso() {
		return codigoAcesso;
	}

	public void setCodigoAcesso(String codigoAcesso) {
		this.codigoAcesso = codigoAcesso;
	}

}
