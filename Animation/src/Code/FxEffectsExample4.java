package Code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxEffectsExample4 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the Effect
		GaussianBlur effect = new GaussianBlur();

		// Create the Text
		Text text = new Text("Gaussian Blur");
		// Set the Font for the Text
		text.setFont(Font.font(null, FontWeight.BOLD, 36));
		// Add the Effect to the Text
		text.setEffect(effect);

		// Create the Sliders
		Slider radiusSlider = new Slider(0.0, 30.0, 0.0);
		radiusSlider.setMajorTickUnit(10);
		radiusSlider.setShowTickLabels(true);

		// Bind the Properties to the Effect
		effect.radiusProperty().bind(radiusSlider.valueProperty());

		// Create the HBox for the Sliders
		HBox hbox = new HBox(10);
		// Add the Children to the HBox
		hbox.getChildren().addAll(new Label("Radius:"), radiusSlider);

		// Create the BorderPane
		BorderPane root = new BorderPane();
		// Add the Text and the HBox to the BorderPane
		root.setCenter(text);
		root.setBottom(hbox);

		// Set the Padding and Border for the BorderPane
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root,400,150);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title of the Stage
		stage.setTitle("An Example of the GaussianBlur Effect");
		// Display the Stage
		stage.show();
	}

}
