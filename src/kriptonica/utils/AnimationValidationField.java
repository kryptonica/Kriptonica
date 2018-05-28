package kriptonica.utils;

import java.util.List;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Control;
import javafx.util.Duration;

public class AnimationValidationField {
	public static void start(List<Control> controles) {
		controles.forEach(controle -> {
			//controle.setStyle("-fx-border-color:red;");
			RotateTransition rotateTransition  = new RotateTransition(Duration.millis(60), controle);
			rotateTransition.setFromAngle(-4);
			rotateTransition.setToAngle(4);
			rotateTransition.setCycleCount(8);
			rotateTransition.setAutoReverse(true);
			rotateTransition.setOnFinished((ActionEvent evento) -> {
				controle.setRotate(0);
			});
			rotateTransition.play();
		});
		
		if (!controles.isEmpty()) {
			controles.get(0).requestFocus();
		}
	}
}
