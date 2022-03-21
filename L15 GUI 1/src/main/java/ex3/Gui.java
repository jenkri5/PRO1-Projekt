package ex3;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise 3");
        stage.setResizable(false);
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfInvestment = new TextField(), txfYears = new TextField(), txfInterest = new TextField(), txfFutureValue = new TextField();

    private void initContent(GridPane pane) {

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblInvestment = new Label("Investment:");
        pane.add(lblInvestment, 0, 0);
        pane.add(txfInvestment,1,0);

        Label lblYears = new Label("Years:");
        pane.add(lblYears,0,1);
        pane.add(txfYears,1,1);

        Label lblInterest = new Label("Interest (%):");
        pane.add(lblInterest,0,2);
        pane.add(txfInterest,1,2);

        Button btnCalculate = new Button("Calculate");
        btnCalculate.setOnAction(event -> this.calculateAction());
        pane.add(btnCalculate,1,3);
        pane.setHalignment(btnCalculate, HPos.CENTER);


        Label lblFutureValue = new Label("Future value:");
        pane.add(lblFutureValue, 0, 4);
        txfFutureValue.setEditable(false);
        pane.add(txfFutureValue, 1, 4);

    }

    // -------------------------------------------------------------------------

    private void calculateAction() {
        int investment = Integer.parseInt(txfInvestment.getText());
        int years = Integer.parseInt(txfYears.getText());
        double interest = Double.parseDouble(txfInterest.getText()) / 100;
        double futureValue = investment;

        for (int i = 0; i < years; i++) {
            futureValue += futureValue * interest;
        }

        futureValue = Math.round(futureValue*100.0)/100.0;
        txfFutureValue.setText(String.valueOf(futureValue));
    }

}
