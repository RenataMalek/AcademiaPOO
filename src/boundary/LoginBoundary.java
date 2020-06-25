package boundary;

import control.LoginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginBoundary {

    private Stage stage;

    private final LoginController loginController = new LoginController();

    private TextField acesso;

    private ComboBox<String> tipoAcesso;

    public LoginBoundary(Stage stage) {
        this.stage = stage;
        construirTela(stage);
    }

    private void construirTela(Stage stage) {
        Pane pane = new Pane();

        Scene scene = new Scene(pane, 800, 600);

        acesso = new TextField();
        acesso.relocate(300, 200);
        acesso.setMinWidth(150);

        tipoAcesso = new ComboBox<>();
        tipoAcesso.relocate(300, 300);
        tipoAcesso.setMinWidth(170);
        carregarComboTipoUsuarios();

        Button clienteButton = new Button("Logar");
        clienteButton.relocate(305, 400);
        clienteButton.setMinWidth(150);
        clienteButton.setOnMouseClicked(event -> logar());

        pane.getChildren().add(acesso);
        pane.getChildren().add(tipoAcesso);
        pane.getChildren().add(clienteButton);

        stage.setScene(scene);
        stage.setTitle("Academia Login");
        stage.show();
    }

    private void carregarComboTipoUsuarios() {
        ObservableList<String> observableList = FXCollections.observableList(loginController.buscaTiposAcesso());
        tipoAcesso.setItems(observableList);
    }

    private void logar() {
        String tipoAcessoSelecionado = tipoAcesso.getSelectionModel().getSelectedItem();
        if (!acesso.getText().equals("") && tipoAcessoSelecionado != null && !tipoAcessoSelecionado.equals("")) {
            try {
                boolean logado = loginController.logar(acesso.getText(), tipoAcessoSelecionado);
                if (logado) {
                    new ClienteBoundary(stage);
                } else {
                    System.out.println("Código de acesso invalido");
                }
            } catch (Exception exception) {
                System.out.println("Erro ao fazer login!");
            }
        } else {
            System.out.println("preencha todos os campos para logar!");
        }
    }
}
