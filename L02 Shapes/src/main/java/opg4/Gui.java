package opg4;

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

        Circle circle4 = new Circle(200, 200, 100);
        pane.getChildren().add(circle4);
        circle4.setFill(Color.BLACK);
        circle4.setStroke(Color.BLACK);

        Circle circle3 = new Circle(200, 200, 80);
        pane.getChildren().add(circle3);
        circle3.setFill(Color.WHITE);
        circle3.setStroke(Color.WHITE);

        Circle circle2 = new Circle(200, 200, 60);
        pane.getChildren().add(circle2);
        circle2.setFill(Color.BLACK);
        circle2.setStroke(Color.BLACK);

        Circle circle1 = new Circle(200, 200, 40);
        pane.getChildren().add(circle1);
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.WHITE);

        Circle circle = new Circle(200, 200, 20);
        pane.getChildren().add(circle);
        circle.setFill(Color.BLACK);
        circle.setStroke(Color.BLACK);

    }

}
