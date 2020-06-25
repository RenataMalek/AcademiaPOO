package boundary;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ClienteBoundary {

    public ClienteBoundary(Stage stage) {
        construirTela(stage);
    }

    private void construirTela(Stage stage) {
        Pane pane = new Pane();

        Scene scene = new Scene(pane, 800, 600);

        stage.setScene(scene);
        stage.setTitle("Tela Cliente");
        stage.show();
    }
}
