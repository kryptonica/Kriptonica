/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptonica.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mathe
 */
public class EditarPerfilController implements Initializable {

    @FXML
    private VBox area;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfEmail;
    @FXML
    private DatePicker tfDataNasc;
    @FXML
    private TextArea taSobre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onActionAlterarSenha(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/kriptonica/views/AlterarSenhaFXML.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/kriptonica/styles/application.css").toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("Alterar senha");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EditarPerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onPressedEnviar(KeyEvent event) {
    }

    @FXML
    private void onActionEnviar(MouseEvent event) {
    }

}
