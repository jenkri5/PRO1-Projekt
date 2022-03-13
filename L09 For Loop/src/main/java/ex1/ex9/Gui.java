package ex1.ex9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {
		int x = 180;
		int temp1 = x/5, temp2 = x/2;
		int y1 = 100-temp1;
		int y2 = 100 + temp2;
		while(x >= 5) {
			gc.strokeLine(x, y1, x, y2);
			x = (int)Math.round(x*0.75);
			temp1 = x/5;
			temp2 = x/2;
			y1 = 100-temp1;
			y2 = 100+temp2;
		}
    }
}
