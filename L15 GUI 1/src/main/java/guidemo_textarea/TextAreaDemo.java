package guidemo_textarea;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo TextArea");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextArea txaDescription = new TextArea();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label lblName = new Label("TextArea:");
        pane.add(lblName, 0, 0);

        pane.add(txaDescription, 0, 1);
        txaDescription.setPrefRowCount(7);
        txaDescription.setPrefWidth(270);
        txaDescription.setEditable(false);

        Button btnFill = new Button("Fill TextArea");
        pane.add(btnFill, 1, 1);
        btnFill.setOnAction(event -> this.fillAction());
    }

    // -------------------------------------------------------------------------

    public void fillAction() {
        txaDescription.setText(this.getDescription());
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("A text area is often used for output.\n");
        sb.append("This text has so many lines\n");
        sb.append("that a scrollbar is added to the right, \n");
        sb.append("as you can see for yourself.\n");
        sb.append("You will have to scroll down\n");
        sb.append("to see the last line.\n");
        sb.append("\n\n\n\n");
        sb.append("This is the last line.");
        return sb.toString();
    }
}
