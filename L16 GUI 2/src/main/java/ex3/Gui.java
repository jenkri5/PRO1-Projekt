package ex3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class Gui extends Application {

    PersonInputDialog dialog;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        dialog = new PersonInputDialog("Person information", stage);
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();

    private void initContent(GridPane pane) {
        this.initPersons();

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblPersons = new Label("Persons:");
        pane.add(lblPersons, 0, 0);

        lvwPersons.setPrefSize(250, 250);
        lvwPersons.getItems().setAll(persons);
        pane.add(lvwPersons, 0, 1);

        Button btnAdd = new Button("Add person");
        btnAdd.setOnAction(event -> addPersonAction());
        pane.add(btnAdd,1,1);
        pane.setValignment(btnAdd, VPos.TOP);
        pane.setMargin(btnAdd, new Insets(20, 0, 0, 0));

    }

    // -------------------------------------------------------------------------

    private void initPersons() {
        persons.add(new Person("Ulla Hansen", "Direktør", true));
        persons.add(new Person("Søren Sørensen", "Landmand",false));
        persons.add(new Person("Pia Madsen", "Mekaniker", true));
        persons.add(new Person("Hans Madsen", "Underviser", false));
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addPersonAction() {

        dialog.showAndWait();

        if (dialog.getPerson() != null) {
            persons.add(dialog.getPerson());
            lvwPersons.getItems().setAll(persons);
        }
    }

}
