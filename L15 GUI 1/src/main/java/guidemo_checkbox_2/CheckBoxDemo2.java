package guidemo_checkbox_2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CheckBoxDemo2 extends Application {

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
    private final CheckBox cbx = new CheckBox();

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

        pane.add(cbx, 1, 1);
        cbx.setText("Allow name change");
        cbx.setSelected(true);
        cbx.setOnAction(event -> this.checkBoxAction());
    }

    // -------------------------------------------------------------------------

    private void checkBoxAction() {
        if (cbx.isSelected())
            txfName.setEditable(true);
        else
            txfName.setEditable(false);
    }
}
