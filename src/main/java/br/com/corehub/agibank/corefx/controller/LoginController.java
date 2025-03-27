package br.com.corehub.agibank.corefx.controller;

import br.com.corehub.agibank.corefx.beans.Usuario;
import br.com.corehub.agibank.corefx.dao.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private TextField campoApelido;

    @FXML
    private PasswordField campoSenha;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private static HomeController homeController = new HomeController();

    @FXML
    private void login(ActionEvent actionEvent) throws IOException, SQLException {
        String usuario = campoApelido.getText();
        String senha = campoSenha.getText();

        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario usuarioVerificado = usuarioDao.buscarUsuarioApelido(usuario);
        CifradorSenha cifrador = new CifradorSenha();
        Parent root;

        if (usuario == null) {
            exibirAlerta("Erro de Login", "Usuario não pode ser vazio!");
        }

        if (senha == null) {
            exibirAlerta("Erro de Login", "Senha não pode ser vazia!");
        }

        if(usuarioVerificado != null && cifrador.validarSenhaCrifrada(usuarioVerificado.getSenha(),senha)){
            root = FXMLLoader.load(getClass().getResource("/br/com/corehub/agibank/corefx/view/home.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 412, 915);
            stage.setScene(scene);
            stage.show();
        } else {
            exibirAlerta("Erro de Login", "Usuário ou Senha incorreta!");
        }
    }

    private void exibirAlerta(String titulo, String mensagem) {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
