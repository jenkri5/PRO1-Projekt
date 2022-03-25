package ex1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField(), txfTitle = new TextField();
    private final CheckBox cbSenior = new CheckBox("Senior");
    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();

    private void initContent(GridPane pane) {
        this.initPersons();

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        pane.add(txfName,1,0);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);
        pane.add(txfTitle,1,1);

        pane.add(cbSenior,1,2);
        Button btnAdd = new Button("Add person");
        btnAdd.setOnAction(event -> addPersonAction());
        pane.add(btnAdd,2,2);

        Label lblPersons = new Label("Persons:");
        pane.add(lblPersons, 0, 3);
        pane.setValignment(lblPersons, VPos.TOP);
        lvwPersons.setPrefSize(250, 250);
        lvwPersons.getItems().setAll(persons);
        pane.add(lvwPersons, 1, 3);

    }

    // -------------------------------------------------------------------------

    private void initPersons() {
        persons.add(new Person("Jan Peteresen", "Doktor", true));
        persons.add(new Person("Hans Madsen", "Underviser", false));
        persons.add(new Person("Pia Madsen", "Mekaniker", true));
        persons.add(new Person("Søren Sørensen", "Landmand",false));
        persons.add(new Person("Birgitte Jensen", "Politimand", false));
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addPersonAction() {
        persons.add(new Person(txfName.getText(), txfTitle.getText(), cbSenior.isSelected()));
        txfName.clear();
        txfTitle.clear();
        cbSenior.setSelected(false);
        lvwPersons.getItems().setAll(persons);
    }

}
