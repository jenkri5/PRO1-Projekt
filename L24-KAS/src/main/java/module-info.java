module KAS {
    requires javafx.controls;

    exports kas.gui to javafx.graphics;
    exports kas.application.model to javafx.graphics;
    exports kas.application.controller to javafx.graphics;
    exports kas.storage to javafx.graphics;
}