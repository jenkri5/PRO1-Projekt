package opg5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {

        Circle blue = new Circle(100, 100, 30);
        pane.getChildren().add(blue);
        blue.setFill(null);
        blue.setStrokeWidth(2);
        blue.setStroke(Color.BLUE);

        Circle black = new Circle(160, 100, 30);
        pane.getChildren().add(black);
        black.setFill(null);
        black.setStrokeWidth(2);
        black.setStroke(Color.BLACK);

        Circle red = new Circle(220, 100, 30);
        pane.getChildren().add(red);
        red.setFill(null);
        red.setStrokeWidth(2);
        red.setStroke(Color.RED);

        Circle yellow = new Circle(130, 130, 30);
        pane.getChildren().add(yellow);
        yellow.setFill(null);
        yellow.setStrokeWidth(2);
        yellow.setStroke(Color.YELLOW);

        Circle green = new Circle(190, 130, 30);
        pane.getChildren().add(green);
        green.setFill(null);
        green.setStrokeWidth(2);
        green.setStroke(Color.GREEN);

    }

}
