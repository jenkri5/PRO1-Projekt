package ex3;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputDialog extends Stage {

    private final TextField txfName = new TextField(), txfTitle = new TextField();
    private final CheckBox cbSenior = new CheckBox("Senior");
    private Person person;

    public PersonInputDialog(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(100);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        pane.add(txfName, 1, 0);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);
        pane.add(txfTitle, 1, 1);

        pane.add(cbSenior, 1, 2);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        Button btnOk = new Button("Ok");
        btnOk.setOnAction(event -> okAction());
        hBox.getChildren().add(btnOk);
        Button btnCancel = new Button("Cancel");
        btnCancel.setOnAction(event -> cancelAction());
        hBox.getChildren().add(btnCancel);
        pane.add(hBox,1,3);
    }

    private void cancelAction() {
        txfName.clear();
        txfTitle.clear();
        cbSenior.setSelected(false);
        person = null;
        PersonInputDialog.this.hide();
    }

    private void okAction() {
        if (txfName.getText() == "" || txfTitle.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid input");
            alert.setHeaderText("Error!");
            alert.setContentText("You must type both a name and a title.");
            alert.showAndWait().filter(response -> response == ButtonType.OK).ifPresent(response -> doNothing());
        } else {
            person = new Person(txfName.getText(), txfTitle.getText(), cbSenior.isSelected());
            txfName.clear();
            txfTitle.clear();
            cbSenior.setSelected(false);
            PersonInputDialog.this.hide();
        }
    }

    private void doNothing() {

    }

    public Person getPerson() {
        return person;
    }
}
