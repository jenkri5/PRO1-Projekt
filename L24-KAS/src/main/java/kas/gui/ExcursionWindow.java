package kas.gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExcursionWindow extends Stage {

    private final ConferenceWindow parent;

    public ExcursionWindow(ConferenceWindow parent) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.parent = parent;

        setTitle("Opret Udflugt");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    private final TextField txfName = new TextField();
    private final TextField txfPrice = new TextField();
    private final DatePicker dpDate = new DatePicker();
    private final Label lblError = new Label();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Navn");
        pane.add(lblName, 0, 0);

        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(150);

        Label lblPrice = new Label("Pris");
        pane.add(lblPrice, 1, 0);

        pane.add(txfPrice, 1, 1);
        txfPrice.setPrefWidth(30);

        Label lblDate = new Label("Dato");
        pane.add(lblDate, 0, 2);

        pane.add(dpDate, 0, 3, 2, 1);
        dpDate.setPrefWidth(200);
        dpDate.setEditable(false);
        dpDate.setValue(parent.getStartDate());

        Button btnCancel = new Button("Annuller");
        pane.add(btnCancel, 0, 4);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 1, 4);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        pane.add(lblError, 0, 5);
        lblError.setStyle("-fx-text-fill: red");
    }

    private void okAction() {

        lblError.setText("");

        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Udfyld navn");
            return;
        }

        double price = -1.0;
        try {
            price = Double.parseDouble(txfPrice.getText().trim());
        } catch (NumberFormatException e) {
            // do nothing
        }
        if (price < 0) {
            lblError.setText("Ugyldig pris");
            return;
        }

        if (!dpDate.getValue().isAfter(parent.getStartDate().minusDays(1)) || !dpDate.getValue().isBefore(parent.getEndDate().plusDays(1))) {
            lblError.setText("Ugyldig dato");
            return;
        }

        parent.addExcursionData(name, dpDate.getValue(), price);

        hide();

    }

    private void cancelAction() {
        hide();
    }

}
