package demotwowindows;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiTwoWindows extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo input window");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        movieWindow = new MovieInputWindow("Create a movie", stage);
    }

    // -------------------------------------------------------------------------

    private final TextField txfResult = new TextField();
    private MovieInputWindow movieWindow;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Movie:");
        pane.add(lblName, 0, 0);

        pane.add(txfResult, 1, 0, 2, 1);
        txfResult.setEditable(false);

        Button btnCreateMovie = new Button("Create movie");
        pane.add(btnCreateMovie, 1, 1);
        GridPane.setMargin(btnCreateMovie, new Insets(10, 10, 0, 10));
        btnCreateMovie.setOnAction(event -> this.createMovieAction());

    }

    // -----------------------------------------------------
    // Button action

    private void createMovieAction() {
        movieWindow.showAndWait();

        // wait for the dialog to close ...

        if (movieWindow.getActualMovie() != null) {
            Movie movie = movieWindow.getActualMovie();
            txfResult.setText(movie.toString());
        }
    }
}
