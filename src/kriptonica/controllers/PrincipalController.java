package kriptonica.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import kriptonica.utils.EnumTelas;

public class PrincipalController implements Initializable {

    @FXML
    private BorderPane bpArea;

    @FXML
    private TextField lbBuscar;

    @FXML
    private Text nomeUser;

    @FXML
    private VBox campoUsuario;

    @FXML
    private HBox entrar;

    @FXML
    private HBox cadastrar;

    @FXML
    private HBox sair;

    @FXML
    void onActionBuscar(ActionEvent event) {
        System.out.println("Clicou no botão Buscar com o item: " + lbBuscar.getText());
    }

    @FXML
    void onButtomCarrinho(MouseEvent event) {
        System.out.println("Clicou no botão Carrinho");
    }

    @FXML
    void onButtomEditarPerfil(MouseEvent event) {
        System.out.println("Clicou no botão Editar Perfil");
    }

    @FXML
    void onButtomInicio(MouseEvent event) {
        System.out.println("Clicou no botão Inicio");
    }

    @FXML
    void onButtomMeusAnuncios(MouseEvent event) {
        System.out.println("Clicou no botão Meus Anuncios");
    }

    @FXML
    void onButtomMinhasCompras(MouseEvent event) {
        System.out.println("Clicou no botão Minhas Compras");
    }

    @FXML
    void onButtomMinhasVendas(MouseEvent event) {
        System.out.println("Clicou no botão Minhas Vendas");
    }

    @FXML
    void onButtomPerfil(MouseEvent event) {
        System.out.println("Clicou no botão Perfil");
    }

    @FXML
    void onButtomSair(MouseEvent event) {
        System.out.println("Clicou no botão Sair");
    }

    @FXML
    void onButtomEntrar(MouseEvent event) {
        showView(EnumTelas.TELA_LOGIN);
    }

    @FXML
    void onButtomCadastrar(MouseEvent event) {
        showView(EnumTelas.TELA_CADASTRO);
    }

    @FXML
    void onButtomUltAnuncios(MouseEvent event) {
        System.out.println("Clicou no botão Ultimos Anuncios");
    }

    public void showView(EnumTelas view) {
        switch (view) {
            case TELA_LOGIN:
                try {
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("/kriptonica/views/LoginFXML.fxml"));
                    VBox infoView = (VBox) loader.load();
                    bpArea.setCenter(infoView);

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case TELA_CADASTRO:
                try {

                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("/kriptonica/views/CadastrarFXML.fxml"));
                    VBox infoView = (VBox) loader.load();
                    bpArea.setCenter(infoView);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case TELA_HOME:
                try {

                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("/kriptonica/views/HomeFXML.fxml"));
                    VBox infoView = (VBox) loader.load();
                    bpArea.setCenter(infoView);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showView(EnumTelas.TELA_HOME);
        // try {
        // FXMLLoader loader =
        // FXMLLoader.load(getClass().getResource("/view/teste.fxml"));
        // AnchorPane box = (AnchorPane) loader.load();
        // apPainelPrincipal.getChildren().add(box);

        // FXMLLoader loader = new
        // FXMLLoader(getClass().getResource("/view/LoginFXML.fxml"));
        // VBox infoView = (VBox) loader.load();
        // vbPainelPrincipal.getChildren().add(infoView);
        // } catch (IOException e) {
        // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
    }

}
