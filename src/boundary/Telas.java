package boundary;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Telas extends Application {

	Stage tela;
	Scene inicio;
	Scene acesso;
	Scene cadCli;
	Scene cadCon;
	Scene cadMod;
	Scene cadAtiv;
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		tela = primaryStage;
		
		cenaInicio();
		cenaAcesso();
		
		tela.setTitle("Academia");
		tela.setScene(inicio);
		tela.show();

	}

	public void cenaInicio() {
		Button recepcionista = new Button("RECEPCIONISTA");
		recepcionista.setOnAction(e -> {
			tela.setScene(acesso);
		});
		
		Button treinador = new Button("TREINADOR");
		Button cliente = new Button("CLIENTE");

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(recepcionista, treinador, cliente);

		inicio = new Scene(box, 400, 300);
	}

	public void cenaAcesso() throws IOException {
		String arquivoCSS = getClass().getResource("/control/Login.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/control/Login.fxml");
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		acesso = new Scene(raiz, 300, 300);
		acesso.getStylesheets().add(arquivoCSS);


	}

	public static void main(String[] args) {
		launch(args);
	}

}
