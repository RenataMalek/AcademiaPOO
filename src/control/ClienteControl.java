package control;

import academia.Contrato;

public class ClienteControl extends RecepcionistaControl {

	public boolean entrarAcademia(long CPF) {

		Contrato c = buscarContrato(CPF);

		ContratoControl cc = new ContratoControl();

		if (cc.permitirEntrada(c)) {
			return true;
		} else {
			return false;
		}

	}

}
