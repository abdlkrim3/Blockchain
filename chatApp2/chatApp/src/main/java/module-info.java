module ma.enset.chatapp {
    requires javafx.controls;
    requires de.jensd.fx.glyphs.fontawesome;
    requires org.kordamp.ikonli.javafx;
    requires javafx.fxml;

    opens ma.enset.chatapp to javafx.fxml;
    exports ma.enset.chatapp.presentation.controllers to javafx.fxml;
    exports ma.enset.chatapp;
}