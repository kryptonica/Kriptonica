/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptonica.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Mathe
 */
public class AlterarSenhaController implements Initializable {

    @FXML
    private PasswordField tfSenhaAtual;
    @FXML
    private PasswordField tfNovaSenha;
    @FXML
    private PasswordField tfConfirmarNovaSenha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onPressedEnviar(KeyEvent event) {
    }

    @FXML
    private void onActionEnviar(MouseEvent event) {
    }
    
}
