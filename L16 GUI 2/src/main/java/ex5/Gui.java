package ex5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Boys and girls");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<String> lvwChildren = new ListView<>();
    private final ArrayList<String> boys = new ArrayList<>();
    private final ArrayList<String> girls = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final ToggleGroup group = new ToggleGroup();
    private final RadioButton rbBoys = new RadioButton("Boy");
    private final RadioButton rbGirls = new RadioButton("Girl");

    private void initContent(GridPane pane) {
        this.initPersons();

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        HBox hBox = new HBox();
        rbBoys.setSelected(true);
        rbBoys.setOnAction(event -> changeView());
        rbBoys.setToggleGroup(group);
        rbGirls.setOnAction(event -> changeView());
        rbGirls.setToggleGroup(group);
        hBox.getChildren().addAll(rbBoys, rbGirls);
        pane.add(hBox, 1, 0);


        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 1);

        lvwChildren.setPrefSize(200, 200);
        lvwChildren.getItems().setAll(boys);
        pane.add(lvwChildren, 1, 1);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 2);

        pane.add(txfName, 1, 2);

        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(event -> addAction());
        pane.add(btnAdd,2,2);

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
        girls.add("Alma");
        girls.add("Agnes");
        girls.add("Ella");
        girls.add("Freja");
        girls.add("Clara");
        girls.add("Emma");
        girls.add("Sofia");
        girls.add("Karla");
        girls.add("Anna");
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        if (txfName.getText() != "") {
            if (rbBoys.isSelected()) {
                boys.add(txfName.getText());
                lvwChildren.getItems().setAll(boys);
            } else {
                girls.add(txfName.getText());
                lvwChildren.getItems().setAll(girls);
            }
            txfName.clear();
        }
    }

    private void changeView() {
        if(rbBoys.isSelected()) {
            lvwChildren.getItems().setAll(boys);
        } else {
            lvwChildren.getItems().setAll(girls);
        }
    }

}
