package kriptonica.controllers;

import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import kriptonica.utils.AnimationValidationField;
import javafx.scene.control.Control;
import kriptonica.Main;
import kriptonica.MetaData;
import kriptonica.ejb.UsuarioRemote;
import kriptonica.models.Usuario;
import kriptonica.utils.EnumTelas;

public class CadastrarController {

    @FXML
    private TextField lbNome;

    @FXML
    private TextField lbEmail;

    @FXML
    private DatePicker lbDataNasc;

    @FXML
    private PasswordField lbSenha;

    @FXML
    private PasswordField lbSenhaConfirmacao;

    @FXML
    void acao(ActionEvent event) throws Exception {
        enviar();
    }

    @FXML
    void onActionEnviar(MouseEvent event) throws Exception {
        enviar();
    }

    private void enviar() throws Exception {
        java.util.List<Control> controles = new ArrayList<>();
        StringBuilder error = new StringBuilder();
        if (lbNome.getText().isEmpty()) {
            error.append("O campo Nome é obrigatório.\n");
            controles.add(lbNome);
        }
        if (lbEmail.getText().isEmpty()) {
            error.append("O campo Email é obrigatório.\n");
            controles.add(lbEmail);
        }
        if (lbDataNasc.getValue() == null) {
            error.append("O campo Data de Nascimento é obrigatório.\n");
            controles.add(lbDataNasc);
        }
        if (lbSenha.getText().isEmpty()) {
            error.append("O campo Senha é obrigatório.\n");
            controles.add(lbSenha);
        }
        if (lbSenhaConfirmacao.getText().isEmpty()) {
            error.append("O campo Confirmar Senha é obrigatório.\n");
            controles.add(lbSenhaConfirmacao);
        }
        if (!lbSenha.getText().equals(lbSenhaConfirmacao.getText())) {
            error.append("As senhas não conferem.\n");
            controles.add(lbSenha);
            controles.add(lbSenhaConfirmacao);
        }
        if (!error.toString().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validação");
            alert.setHeaderText("Erros encontrados");
            alert.setContentText(error.toString());
            alert.initOwner(lbNome.getScene().getWindow());
            alert.setOnHidden((DialogEvent evento) -> {
                AnimationValidationField.start(controles);
            });
            alert.show();
        } else {

            InitialContext context;
            try {
                context = new InitialContext();
                UsuarioRemote ejb = (UsuarioRemote) context.lookup("kriptonica.ejb.UsuarioRemote");
                Usuario usuario = new Usuario(lbNome.getText(), Date.from(lbDataNasc.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), lbEmail.getText(), lbSenha.getText());
                ejb.salvar(usuario);

//                Usuario usuario = ejb.consultarPorID(6L);
                System.out.println(usuario);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastrar Usuário");
                alert.setHeaderText("Sucesso");
                alert.setContentText("Usuário cadastrado!");
                alert.initOwner(lbNome.getScene().getWindow());
                alert.show();
                MetaData.tela = EnumTelas.TELA_LOGIN;
                Parent root = FXMLLoader.load(getClass().getResource("/kriptonica/views/PrincipalFXML.fxml"));
                Main.stage.getScene().setRoot(root);
            } catch (NamingException e) {

                // TODO Auto-generated catch block
                System.err.println("Erro na hora de salvar " + e.getMessage());
            }
        }
    }
}
