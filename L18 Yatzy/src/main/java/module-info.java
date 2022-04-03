module yatzy {
    requires javafx.controls;

    exports gui to javafx.graphics;
    exports model to javafx.graphics;
    exports mouseclicked to javafx.graphics;
}