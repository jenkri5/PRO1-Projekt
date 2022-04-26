module architecture {
    requires javafx.controls;

    exports ex1.controller to javafx.graphics;
    exports ex1.gui to javafx.graphics;
    exports ex1.model to javafx.graphics;
    exports ex1.storage to javafx.graphics;
    exports example.controller to javafx.graphics;
    exports example.gui to javafx.graphics;
    exports example.model to javafx.graphics;
    exports example.storage to javafx.graphics;
}