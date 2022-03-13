package fig3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
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

        Circle sun = new Circle(200, 100, 40);
        pane.getChildren().add(sun);
        sun.setFill(Color.YELLOW);
        sun.setStroke(Color.BLACK);

        Rectangle house = new Rectangle(50, 200, 120, 120);
        pane.getChildren().add(house);
        house.setFill(Color.RED);

        Rectangle window = new Rectangle(70, 220, 40, 40);
        pane.getChildren().add(window);

        Polygon roof = new Polygon(30, 200, 110, 130, 190, 200);
        pane.getChildren().add(roof);
        roof.setFill(Color.GREEN);

        Line ground = new Line(30, 320, 240, 320);
        pane.getChildren().add(ground);
    }

}
