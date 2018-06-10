/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptonica.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.CheckComboBox;

/**
 * FXML Controller class
 *
 * @author Mathe
 */
public class BuscaController implements Initializable {

    @FXML
    private VBox area;
    @FXML
    private TextField lbBuscar1;
    @FXML
    private ChoiceBox<String> classificarPor;
    private CheckComboBox<String> tipoMoeda;
    @FXML
    private HBox barraFerramentas;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        classificarPor.getItems().add("Data mais antiga");
        classificarPor.getItems().add("Data mais recente");
        classificarPor.getItems().add("Maior preço");
        classificarPor.getItems().add("Menor preço");
        classificarPor.getItems().add("Maior quantidade");
        classificarPor.getItems().add("Menor quantidade");
        classificarPor.setValue("Data mais antiga");
        
        // create the data to show in the CheckComboBox 
        final ObservableList<String> strings = FXCollections.observableArrayList();
        strings.add("Bitcoin");
        strings.add("Ethereum");
        strings.add("Ripple");
        strings.add("Bitcoin Cash");
        strings.add("EOS");
        strings.add("Litecoin");
        strings.add("Cardano");
        strings.add("Stellar");
        strings.add("IOTA");
        strings.add("TRON");

        // Create the CheckComboBox with the data 
        tipoMoeda = new CheckComboBox<>(strings);

        // and listen to the relevant events (e.g. when the selected indices or 
        // selected items change).
        tipoMoeda.getCheckModel().getCheckedItems().addListener((ListChangeListener.Change<? extends String> c) -> {
            System.out.println(tipoMoeda.getCheckModel().getCheckedItems());
        });
        
        barraFerramentas.getChildren().add(tipoMoeda);
    }

    @FXML
    private void onActionBuscar(ActionEvent event) {
    }

}
