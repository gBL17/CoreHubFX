package br.com.corehub.agibank.corefx;

import br.com.corehub.agibank.corefx.beans.Usuario;
import br.com.corehub.agibank.corefx.dao.UsuarioDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/br/com/corehub/agibank/corefx/view/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 412, 915);
        stage.setTitle("CoreHub");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}