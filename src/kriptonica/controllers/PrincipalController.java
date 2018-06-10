package kriptonica.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import kriptonica.Main;
import kriptonica.MetaData;
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
    private HBox ultimosAnuncios;
    @FXML
    private HBox carrinho;
    @FXML
    private VBox barraLateral;
    @FXML
    private VBox barraControle;
    @FXML
    private VBox areaBuscar;

    @FXML
    void onActionBuscar(ActionEvent event) {
        MetaData.tela = EnumTelas.TELA_BUSCA;
        showView();
    }

    @FXML
    void onButtomCarrinho(MouseEvent event) {
        System.out.println("Clicou no botão Carrinho");
    }

    @FXML
    void onButtomEditarPerfil(MouseEvent event) {
        MetaData.tela = EnumTelas.TELA_EDITAR_PERFIL;
        showView();
    }

    @FXML
    void onButtomInicio(MouseEvent event) {
        MetaData.tela = EnumTelas.TELA_HOME;
        showView();
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
    void onButtomSair(MouseEvent event) throws IOException {
        MetaData.usuario = null;
        MetaData.tela = EnumTelas.TELA_HOME;
        Parent root = FXMLLoader.load(getClass().getResource("/kriptonica/views/PrincipalFXML.fxml"));
        Main.stage.getScene().setRoot(root);
    }

    @FXML
    void onButtomEntrar(MouseEvent event) {
        MetaData.tela = EnumTelas.TELA_LOGIN;
        showView();
    }

    @FXML
    void onButtomCadastrar(MouseEvent event) {
        MetaData.tela = EnumTelas.TELA_CADASTRO;
        showView();
    }

    @FXML
    void onButtomUltAnuncios(MouseEvent event) {
        MetaData.tela = EnumTelas.TELA_BUSCA;
        showView();
    }

    public void showCampos() {
        if (MetaData.usuario == null) {
            nomeUser.setText("Convidado");
            barraLateral.getChildren().remove(ultimosAnuncios);
            barraLateral.getChildren().remove(carrinho);
            barraLateral.getChildren().remove(campoUsuario);
            barraControle.getChildren().remove(sair);
            areaBuscar.getChildren().clear();
        } else {
            nomeUser.setText(MetaData.usuario.getNome());
            barraControle.getChildren().remove(cadastrar);
            barraControle.getChildren().remove(entrar);
        }
    }

    public void showView() {
        switch (MetaData.tela) {
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
            case TELA_BUSCA:
                try {

                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("/kriptonica/views/BuscaFXML.fxml"));
                    VBox infoView = (VBox) loader.load();
                    bpArea.setCenter(infoView);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case TELA_EDITAR_PERFIL:
                try {

                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("/kriptonica/views/EditarPerfilFXML.fxml"));
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
        showCampos();
        showView();
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
