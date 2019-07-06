package toDoApp;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shaker {
	private TranslateTransition animate;
	public Shaker(Node node) {
		animate= new TranslateTransition(Duration.millis(300),node);
	
		animate.setFromX(0f);
		animate.setByX(30f);
		animate.setByY(50f);
		animate.setByZ(100f);
		animate.setAutoReverse(true);
		animate.setCycleCount(4);
	}
	public void Shake() {
		animate.playFromStart();
	}
}
