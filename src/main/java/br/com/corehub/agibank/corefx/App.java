package br.com.corehub.agibank.corefx;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/br/com/corehub/agibank/corefx/view/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 412, 915);
        stage.setTitle("CoreHub");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}