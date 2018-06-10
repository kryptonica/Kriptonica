package kriptonica.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import kriptonica.Main;
import kriptonica.MetaData;
import kriptonica.ejb.UsuarioRemote;
import kriptonica.models.Usuario;
import kriptonica.utils.EnumTelas;

public class LoginController {

    @FXML
    private TextField lbEmail;

    @FXML
    private PasswordField lbSenha;

    public void entrar() {

        try {
            InitialContext context = new InitialContext();
            UsuarioRemote ejb = (UsuarioRemote) context.lookup("kriptonica.ejb.UsuarioRemote");
            Usuario usuario = ejb.buscaUsuarioPorEmail(lbEmail.getText());
            if (usuario != null && usuario.autenticar(lbSenha.getText())) {
                System.out.println(usuario);
                System.out.println("Logado com sucesso!");
                MetaData.tela = EnumTelas.TELA_HOME;
                MetaData.usuario = usuario;
                Parent root = FXMLLoader.load(getClass().getResource("/kriptonica/views/PrincipalFXML.fxml"));
                Main.stage.getScene().setRoot(root);

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Login");
                alert.setHeaderText("Falha ao logar");
                alert.setContentText("Usuário/Senha não confere!");
                alert.initOwner(lbEmail.getScene().getWindow());
                alert.show();
            }
        } catch (NamingException ex) {
            System.err.println("Erro1 na hora de logar " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Erro2 na hora de logar " + ex.getMessage());
        }

    }

    @FXML
    private void onButtomEntrar(ActionEvent event) {
        entrar();
    }

    @FXML
    private void buttomEntrar(MouseEvent event) {
        entrar();
    }

}
