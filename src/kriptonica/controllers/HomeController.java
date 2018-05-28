package kriptonica.controllers;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import kriptonica.models.TabelaMoedas;

public class HomeController implements Initializable {

    @FXML
    private TableView<TabelaMoedas> tbMoedas;

    @FXML
    private TableColumn<TabelaMoedas, String> colMoeda;

    @FXML
    private TableColumn<TabelaMoedas, String> colMenorValor;

    @FXML
    private TableColumn<TabelaMoedas, String> colMaiorValor;

    @FXML
    private TableView<?> tbBuscasETC;

    @FXML
    private TableColumn<?, ?> colVendedor;

    @FXML
    private TableColumn<?, ?> colValor;

    @FXML
    private TableColumn<?, ?> colQuantMin;

    @FXML
    private TableColumn<?, ?> colQuant;

    @FXML
    private TableView<?> tbUltimasCompras;

    @FXML
    private TableColumn<?, ?> colMoedaUC;

    @FXML
    private TableColumn<?, ?> colDataHoraUC;

    @FXML
    private TableColumn<?, ?> colValorUC;

    @FXML
    private TableView<?> tbUltimosAnuncios;

    @FXML
    private TableColumn<?, ?> colMoedaUA;

    @FXML
    private TableColumn<?, ?> colDataHoraUA;

    @FXML
    private TableColumn<?, ?> colValorUA;

    @FXML
    void onActionEnviar(MouseEvent event) {
        System.out.println("Clicou no botão");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colMoeda.setCellValueFactory(
                new PropertyValueFactory<>("moeda"));
        colMaiorValor.setCellValueFactory(
                new PropertyValueFactory<>("maiorValor"));
        colMenorValor.setCellValueFactory(
                new PropertyValueFactory<>("menorValor"));
        tbMoedas.setItems(listaMoedas());
    }

    private ObservableList<TabelaMoedas> listaMoedas() { 
        return FXCollections.observableArrayList(
                new TabelaMoedas("BTC", "R$ " + String.format("%.2f", 300000.0), "R$ " + String.format("%.2f", 400000.0)),
                new TabelaMoedas("ETC", "R$ " + String.format("%.2f", 2000.0), "R$ " + String.format("%.2f", 10000.0)),
                new TabelaMoedas("XRP", "R$ " + String.format("%.2f", 2000.0), "R$ " + String.format("%.2f", 10000.0)),
                new TabelaMoedas("BCH", "R$ " + String.format("%.2f", 2000.0), "R$ " + String.format("%.2f", 10000.0)),
                new TabelaMoedas("EOS", "R$ " + String.format("%.2f", 2000.0), "R$ " + String.format("%.2f", 10000.0)),
                new TabelaMoedas("LTC", "R$ " + String.format("%.2f", 2000.0), "R$ " + String.format("%.2f", 10000.0)),
                new TabelaMoedas("ADA", "R$ " + String.format("%.2f", 2000.0), "R$ " + String.format("%.2f", 10000.0)),
                new TabelaMoedas("XLM", "R$ " + String.format("%.2f", 2000.0), "R$ " + String.format("%.2f", 10000.0)),
                new TabelaMoedas("MIOTA", "R$ " + String.format("%.2f", 2000.0), "R$ " + String.format("%.2f", 10000.0)),
                new TabelaMoedas("TRX", "R$ " + String.format("%.2f", 2000.0), "R$ " + String.format("%.2f", 10000.0))
        );
    }
}
