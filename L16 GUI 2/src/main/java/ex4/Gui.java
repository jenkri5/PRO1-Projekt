package ex4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Boys");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<String> lvwBoys = new ListView<>();
    private final ArrayList<String> boys = new ArrayList<>();
    private final TextField txfName = new TextField();

    private void initContent(GridPane pane) {
        this.initPersons();

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 0);

        lvwBoys.setPrefSize(200, 200);
        lvwBoys.getItems().setAll(boys);
        pane.add(lvwBoys, 1, 0);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 1);

        pane.add(txfName, 1, 1);

        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(event -> addAction());
        pane.add(btnAdd,2,1);

    }

    // -------------------------------------------------------------------------

    private void initPersons() {
        boys.add("Martin");
        boys.add("Jan");
        boys.add("Bent");
        boys.add("Niels");
        boys.add("Thor");
        boys.add("Peter");
        boys.add("Finn");
        boys.add("Thomas");
        boys.add("Jan");
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        if (txfName.getText() != "") {
            boys.add(txfName.getText());
            lvwBoys.getItems().setAll(boys);
            txfName.clear();
        }
    }

}
