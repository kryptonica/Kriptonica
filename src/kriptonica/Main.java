package kriptonica;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import kriptonica.utils.EnumTelas;

public class Main extends Application {

    public static Stage stage = null;

    @Override

    public void start(Stage primaryStage) {
        try {
            MetaData.tela = EnumTelas.TELA_HOME;
            Parent root = FXMLLoader.load(getClass().getResource("/kriptonica/views/PrincipalFXML.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/kriptonica/styles/application.css").toExternalForm());
//            stage.initStyle(StageStyle.UNDECORATED);
            stage = primaryStage;
            stage.setTitle("Kriptonica");
            stage.setMaximized(true);
            stage.setScene(scene);
            MetaData.parent = root;
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
