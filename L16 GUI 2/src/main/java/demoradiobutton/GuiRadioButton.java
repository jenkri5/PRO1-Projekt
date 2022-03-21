package demoradiobutton;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GuiRadioButton extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Radiobutton Demo");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final Label lblTxt = new Label("RadioButton example");
    private final ToggleGroup group = new ToggleGroup();

    private void initContent(GridPane pane) {
        // show or hide grid lines
//        pane.setGridLinesVisible(true);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a HBox (horizontal box) to the pane (at col=0, row=0)
        HBox box = new HBox();
        pane.add(box, 0, 0);

        String[] colorStrings = { "Red", "Blue", "Green", "Black" };
        Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.BLACK };

        // add 4 radio buttons to the box
        for (int i = 0; i < colors.length; i++) {
            RadioButton rb = new RadioButton();
            box.getChildren().add(rb);
            rb.setText(colorStrings[i]);
            rb.setPrefWidth(70);
            // make the radio button remember its own color
            rb.setUserData(colors[i]);
            // ensure that only one radio button is in selected state
            rb.setToggleGroup(group);
            // set the method to execute when a radio button is selected
            rb.setOnAction(event -> this.setLabelColor());
        }

        // add a centered label to the pane (at col=0, row=1)
        pane.add(lblTxt, 0, 1);
        GridPane.setHalignment(lblTxt, HPos.CENTER);

        // select first radio button and update color of lblText
        RadioButton rb0 = (RadioButton) group.getToggles().get(0);
        rb0.setSelected(true);
        lblTxt.setTextFill(colors[0]);
    }

    // -------------------------------------------------------------------------
    // RadioButton action

    private void setLabelColor() {
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        Color color = (Color) rb.getUserData();
        lblTxt.setTextFill(color);
    }
}
