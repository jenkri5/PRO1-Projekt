package demo1listview;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiListView1 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo1");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> names = new ArrayList<>();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        // add a label to the pane (at col=0, row=1)
        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 1);
        GridPane.setValignment(lblNames, VPos.TOP);

        // add a text field to the pane (at col=1, row=0)
        pane.add(txfName, 1, 0);

        // add a listView to the pane(at col=1, row=1)
        pane.add(lvwNames, 1, 1);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);

        ChangeListener<String> listener = (ov, o, n) -> this.selectionChanged();
        lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

        this.initNames();
        lvwNames.getItems().setAll(this.initNames());
    }

    // -------------------------------------------------------------------------

    private ArrayList<String> initNames() {
        names.add("Jane");
        names.add("Eva");
        names.add("Lene");
        names.add("Mette");
        names.add("Tine");
        names.add("Line");
        names.add("Lone");
        names.add("Alberte");
        names.add("Pia");
        return names;
    }

    // -------------------------------------------------------------------------

    private void selectionChanged() {
        String selected = lvwNames.getSelectionModel().getSelectedItem();
        txfName.setText(selected);
    }
}
