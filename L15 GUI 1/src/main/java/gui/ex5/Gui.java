package gui.ex5;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise 5");
        stage.setResizable(false);
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextArea txaNames = new TextArea();

    private void initContent(GridPane pane) {

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        pane.add(txfName,0,1);

        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(event -> this.addAction());
        pane.add(btnAdd,0,2);
        pane.setHalignment(btnAdd, HPos.CENTER);

        txaNames.setPrefWidth(200);
        txaNames.setEditable(false);
        pane.add(txaNames, 0, 3);

    }



    // -------------------------------------------------------------------------

    private void addAction() {
        txaNames.setText(txaNames.getText() + txfName.getText() + "\n");
    }

}
