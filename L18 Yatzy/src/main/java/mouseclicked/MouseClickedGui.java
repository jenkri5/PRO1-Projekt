package mouseclicked;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MouseClickedGui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Demo Mouse Clicked");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField(), txfAddress = new TextField();

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        pane.add(txfName, 1, 0);
        txfName.setText("Mikael Christensen");
        txfName.setOnMouseClicked(event -> this.mouseClicked(event));

        Label lblAddress = new Label("Name:");
        pane.add(lblAddress, 0, 1);

        pane.add(txfAddress, 1, 1);
        txfAddress.setText("Town Road 5");
        txfAddress.setOnMouseClicked(event -> this.mouseClicked(event));
    }

    private void mouseClicked(MouseEvent event) {
        TextField txf = (TextField) event.getSource();
        if (txf == txfName) {
            txf.setStyle("-fx-text-fill: red");
        }
        if (txf == txfAddress) {
            txf.setText("Clicked");
        }
    }
}
