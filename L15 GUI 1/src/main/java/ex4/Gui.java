package ex4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise 4");
        stage.setResizable(false);
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfCelsius = new TextField(), txfCelsiusC = new TextField(), txfFahrenheit = new TextField(), txfFahrenheitC = new TextField();

    private void initContent(GridPane pane) {

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblCelsius = new Label("Celsius:");
        pane.add(lblCelsius, 0, 0);
        pane.add(txfCelsius,0,1);

        Label lblFahrenheitC = new Label("Fahrenheit:");
        pane.add(lblFahrenheitC,2,0);
        txfFahrenheitC.setEditable(false);
        pane.add(txfFahrenheitC,2,1);

        Button btnConvertC = new Button("Convert");
        btnConvertC.setOnAction(event -> this.convertCelsiusAction());
        pane.add(btnConvertC,1,1);

        Label lblFahrenheit = new Label("Fahrenheit:");
        pane.add(lblFahrenheit, 0, 2);
        pane.add(txfFahrenheit,0,3);

        Label lblCelsiusC = new Label("Celsius:");
        pane.add(lblCelsiusC,2,2);
        txfCelsiusC.setEditable(false);
        pane.add(txfCelsiusC,2,3);

        Button btnConvertF = new Button("Convert");
        btnConvertF.setOnAction(event -> this.convertFahrenheitAction());
        pane.add(btnConvertF,1,3);

    }



    // -------------------------------------------------------------------------

    private void convertCelsiusAction() {
        double celsius = Double.parseDouble(txfCelsius.getText());
        double fahrenheit = 9.0 / 5.0 * celsius + 32;
        fahrenheit = Math.round(fahrenheit*100.0)/100.0;
        txfFahrenheitC.setText(String.valueOf(fahrenheit));
    }

    private void convertFahrenheitAction() {
        double fahrenheit = Double.parseDouble(txfFahrenheit.getText());
        double celsius = 5.0 / 9.0 * (fahrenheit - 32);
        celsius = Math.round(celsius*100.0)/100.0;
        txfCelsiusC.setText(String.valueOf(celsius));
    }

}
