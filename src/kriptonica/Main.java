package kriptonica;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
                    System.out.println(getClass().getResource("/kriptonica/views/PrincipalFXML.fxml"));
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/kriptonica/views/PrincipalFXML.fxml"));
			Scene scene = new Scene(root,1200,840);
			scene.getStylesheets().add(getClass().getResource("/kriptonica/styles/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
