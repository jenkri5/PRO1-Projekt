package ex1.ex6;

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
		// Line
		gc.strokeLine(0, 180, 180, 180);
		// Arrow
		gc.strokeLine(180, 180, 180 - 10, 180 + 4);
		gc.strokeLine(180, 180, 180 - 10, 180 - 4);

		for(int i = 10; i <= 160; i = i + 15) {
			if(i == 10) {
				gc.strokeLine(i, 175, i, 185);
				gc.fillText("0", i, 198);
			} else if(i == 85) {
				gc.strokeLine(i, 175, i, 185);
				gc.fillText("5", i, 198);
			} else if(i == 160) {
				gc.strokeLine(i, 175, i, 185);
				gc.fillText("10", i, 198);
			} else
				gc.strokeLine(i, 177, i, 183);
		}

	}
}
