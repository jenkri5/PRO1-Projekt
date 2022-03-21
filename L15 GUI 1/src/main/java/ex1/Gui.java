package ex1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise 1");
        stage.setResizable(false);
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField(), txfFirstName = new TextField(), txfLastName = new TextField();

    private void initContent(GridPane pane) {

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblFirstName = new Label("First name:");
        pane.add(lblFirstName, 0, 0);

        Label lblLastName = new Label("Last name:");
        pane.add(lblLastName,1,0);

        pane.add(txfFirstName, 0, 1, 1, 1);

        pane.add(txfLastName, 1, 1, 1, 1);

        Label lblName = new Label("Full name:");
        pane.add(lblName,0,2);

        txfName.setEditable(false);
        pane.add(txfName, 0, 3, 2, 1);

        Button btnCombine = new Button("Combine");
        pane.add(btnCombine,1,4);

        btnCombine.setOnAction(event -> this.combineAction());
    }

    // -------------------------------------------------------------------------

    private void combineAction() {
        txfName.setText(txfFirstName.getText() + " " + txfLastName.getText());
    }

}
