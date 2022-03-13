package fig2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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
        int x = 100;
        Color color = Color.YELLOW;

        Circle circle = new Circle(100+x, 100, 40);
        pane.getChildren().add(circle);
        circle.setFill(color);

        Rectangle rectangle = new Rectangle(60+x, 200, 80, 80);
        pane.getChildren().add(rectangle);
        rectangle.setFill(color);

        Line line = new Line(200+x, 100, 200+x, 200);
        pane.getChildren().add(line);
        line.setStrokeWidth(3);
        line.setStroke(color);

    }

}
