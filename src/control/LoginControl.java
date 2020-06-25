package control;

import academia.Recepcionista;

import org.controlsfx.control.Notifications;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;

public class LoginControl {

	@FXML
	private PasswordField codigo;

	public void entrar() {

		Recepcionista r = new Recepcionista();

		boolean codigoAcesso = codigo.getText().equals(r.getCodigoAcesso());

		if (codigoAcesso) {
			Notifications.create().position(Pos.TOP_RIGHT).title("Login funcionario")
					.text("Login efetuado com sucesso!").showInformation();

		} else {
			Notifications.create().position(Pos.TOP_RIGHT).title("Login funcionario").text("Usuario e senha invalidos")
					.showError();
		}
	}
}
