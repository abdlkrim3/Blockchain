package ma.enset.chatapp;

import javafx.application.Application;
import javafx.stage.Stage;
import ma.enset.chatapp.presentation.views.ViewFactory;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showChatApp();
    }

    public static void main(String[] args) {
        launch();
    }
}