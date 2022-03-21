package guidemo_checkbox_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CheckBoxDemo1 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Demo CheckBox");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        pane.add(txfName, 1, 0);
        txfName.setText("Mikael");
        txfName.setEditable(true);

        // CheckBox to indicate upper / lower case
        CheckBox checkBox = new CheckBox();
        checkBox.setText("Upper case");
        pane.add(checkBox, 0, 1);
        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()) {
                this.upperCaseAction();
            } else {
                this.lowerCaseAction();
            }
        });
    }

    // -------------------------------------------------------------------------

    private void upperCaseAction() {
        String name = txfName.getText().trim();
        txfName.setText(name.toUpperCase());
    }

    private void lowerCaseAction() {
        String name = txfName.getText().trim();
        txfName.setText(name.toLowerCase());
    }
}
