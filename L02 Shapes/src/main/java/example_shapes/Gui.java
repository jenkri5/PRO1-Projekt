package example_shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
        // Circle center at (70,70) and radius 30
        Circle circle = new Circle(70, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.CORNFLOWERBLUE);
        circle.setStroke(Color.BLACK);

        // Line from (70,70) to (100,70)
        Line line = new Line(70, 70, 100, 70);
        pane.getChildren().add(line);

        // Rectangle, upper left corner at (100,40), width 75, height 25
        Rectangle rektangel = new Rectangle(100, 40, 75, 25);
        pane.getChildren().add(rektangel);
        rektangel.setFill(Color.CORAL);

        // Polygon with 3 points (100,100), (200,100) and (150,150)
        Polygon polygon = new Polygon(100, 100, 200, 100, 150, 150);
        pane.getChildren().add(polygon);
        polygon.setFill(Color.PINK);

        // Ellipse with center at (70,230), major axis 100/2 and minor axis 200/2
        Ellipse ellipse = new Ellipse(70, 230, 50, 100);
        pane.getChildren().add(ellipse);
        ellipse.setFill(Color.YELLOW);
        ellipse.setStroke(Color.GREEN);
        ellipse.setStrokeWidth(5);

        // Arc with center at (200,230), major axis 200/2 and minor axis 120/2,
        // start angle 90 degrees, length 45 degrees
        Arc arc = new Arc(300, 300, 100, 60, 90, 45);
        pane.getChildren().add(arc);
        arc.setFill(Color.GREEN);
        arc.setType(ArcType.ROUND);
        // arc.setType(ArcType.OPEN);
        // arc.setType(ArcType.CHORD);

        // Text placed at (100,350)
        Text text = new Text(100, 350, "Computer Science");
        text.setFill(Color.BLUEVIOLET);
        pane.getChildren().add(text);
    }

}
