package opg3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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

        Circle face = new Circle(200, 200, 70);
        pane.getChildren().add(face);
        face.setFill(null);
        face.setStroke(Color.BLACK);

        Circle eyeLeft = new Circle(180, 180, 10);
        pane.getChildren().add(eyeLeft);
        eyeLeft.setFill(null);
        eyeLeft.setStroke(Color.BLACK);

        Circle eyeRight = new Circle(220, 180, 10);
        pane.getChildren().add(eyeRight);
        eyeRight.setFill(null);
        eyeRight.setStroke(Color.BLACK);

        Line mouth = new Line(170, 230, 230, 230);
        pane.getChildren().add(mouth);

    }

}
