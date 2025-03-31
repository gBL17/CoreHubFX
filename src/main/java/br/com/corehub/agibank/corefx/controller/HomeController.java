package br.com.corehub.agibank.corefx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HomeController {

    @FXML
    public Label labelNomeUsuario;


    public void navegarTransacao(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/corehub/agibank/corefx/view/tipoTransacao.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 412, 915);
        stage.setScene(scene);
        stage.show();
    }

    //@FXML
//    private VBox containerContas; // O container do ScrollPane
//
//    @FXML
//    public void initialize() {
//
//    }
//
//    private void carregarContas(ArrayList<Conta> contas) throws IOException {
//        for (int i = 0; i < contas.toArray().length; i++) {
//            // Carrega o .fxml da conta
//            Pane contaView = FXMLLoader.load(getClass().getResource("/br/com/corehub/agibank/corefx/view/" + fxml));
//            containerContas.getChildren().add(contaView); // Adiciona ao VBox
//        }
//    }
}