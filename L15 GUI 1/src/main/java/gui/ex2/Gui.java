package gui.ex2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise 2");
        stage.setResizable(false);
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfNumber = new TextField("0");
    private final VBox vBox = new VBox();

    private void initContent(GridPane pane) {

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblFirstName = new Label("Number:");
        pane.add(lblFirstName, 0, 0);

        txfNumber.setEditable(false);
        txfNumber.setPrefWidth(50);
        pane.add(txfNumber, 1, 0);

        Button btnIncrement = new Button("Inc");
        btnIncrement.setOnAction(event -> this.incrementAction());
        vBox.getChildren().add(btnIncrement);

        Button btnDecrement = new Button("Dec");
        btnDecrement.setOnAction(event -> this.decrementAction());
        vBox.getChildren().add(btnDecrement);

        pane.add(vBox, 2, 0);

    }

    // -------------------------------------------------------------------------

    private void incrementAction() {
        int i = Integer.parseInt(txfNumber.getText());
        i++;
        txfNumber.setText(String.valueOf(i));
        // txfName.setText(txfFirstName.getText() + " " + txfLastName.getText());
    }

    private void decrementAction() {
        int i = Integer.parseInt(txfNumber.getText());
        i--;
        txfNumber.setText(String.valueOf(i));
    }

}
