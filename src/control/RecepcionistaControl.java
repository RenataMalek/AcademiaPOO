package control;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import academia.Cliente;
import academia.Contrato;

public class RecepcionistaControl {

	// remover iniciador quando montar o banco de dados; substituir por increment ID
	long idCli = 0;
	long idCon = 0;

	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Contrato> contratos = new ArrayList<Contrato>();

	// tratamento manter cliente

	public void novoCliente(String CPF, String nome, String email, String endereco, String telefone) {
		Cliente c = new Cliente();
		c.setId(idCli);
		c.setCPF(CPF);
		c.setNome(nome);
		c.setEmail(email);
		c.setEndereco(endereco);
		c.setTelefone(telefone);
		idCli++;
		clientes.add(c);
	}

	public void atualizarCliente(String CPF, String nome, String email, String telefone, String endereco) {
		for (Cliente c : clientes) {
			if (c.getCPF() == CPF) {
				c.setNome(nome);
				c.setEmail(email);
				c.setTelefone(telefone);
				c.setEndereco(endereco);
			}
		}
	}

	public Cliente buscarCliente(String CPF) {
		int cont = 0;
		for (Cliente c : clientes) {
			if (c.getCPF() == CPF) {
				cont++;
				return c;
			}
		}
		if (cont == 0) {
			System.out.println("Cliente n�o cadastrado");
		}
		return null;
	}

	public void mostrarTodosClientes() {
		for (Cliente c : clientes) {
			System.out.println(c);
		}
	}

	public void novoContrato(String CPF, long ID, LocalDate dataContrato, int qtdParcelas, double valorMes,
			double valorTotal) {

		try {
			Cliente cli = buscarCliente(CPF);
			Contrato con = new Contrato();
			con.setID(idCon);
			con.setCliente(cli);
			con.setDataContrato(dataContrato);
			con.setQtdParcelas(qtdParcelas);
			con.setValorMes(valorMes);
			con.setValorTotal(valorTotal);

			contratos.add(con);
			
			idCon++;
			
			ContratoControl ct = new ContratoControl();
			ct.gerarCobranca(con);

		} catch (Exception e) {
			System.out.println("CPF n�o est� cadastrado! Proceda com o cadastro do cliente e tente novamente");
		}

	}

	public void atualizarContrato(String CPF, int qtdParcelas, double valorMes, double valorTotal) {

		for (Contrato c : contratos) {
			if (c.getCliente().getCPF() == CPF) {
				c.setQtdParcelas(qtdParcelas);
				c.setValorMes(valorMes);
				c.setValorTotal(valorTotal);
			}
		}

	}

	public Contrato buscarContrato(String CPF) {
		
		int cont = 0;
		for (Contrato c : contratos) {
			if (c.getCliente().getCPF() == CPF) {
				cont++;
				return c;
			}
		}
		if(cont == 0) {
			System.out.println("Contrato n�o localizado");
		}
		return null;
	}

	public void mostrarTodosContratos() {
		for (Contrato c : contratos) {
			System.out.println(c);
		}
	}
}
