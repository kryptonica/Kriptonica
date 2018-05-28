package kriptonica.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField lbEmail;

    @FXML
    private PasswordField lbSenha;

    @FXML
    void onButtomEntrar(MouseEvent event) {
    	System.out.println("Entrou: " + lbEmail.getText() + " - " + lbSenha.getText());
    }

}
