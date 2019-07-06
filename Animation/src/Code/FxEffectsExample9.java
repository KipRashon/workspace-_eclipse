package Code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.SepiaTone;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxEffectsExample9 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the Effect
		SepiaTone sepia = new SepiaTone();

		// Create the Text
		Text text = new Text("Sepia Tone");
		// Set Color and Font of the Text
		text.setFill(Color.GREEN);
		text.setFont(Font.font(null, FontWeight.BOLD, 36));
		// Set the Effect to the Text
		text.setEffect(sepia);

		// Create the Sliders
		Slider levelSlider = new Slider(0.0, 1.0, 0);

		// Bind the Properties to the Effect
		sepia.levelProperty().bind(levelSlider.valueProperty());

		// Create the VBox for the Slider
		VBox vbox = new VBox();
		// Add the Children to the VBox
		vbox.getChildren().addAll(new Label("Level:"), levelSlider);
		vbox.setSpacing(10);

		// Create the GridPane
		GridPane root = new GridPane();
		// Set horizontal and vertical Spacing
		root.setHgap(5);
		root.setVgap(10);

		// Add the Children to the GridPane
		root.addRow(0, text, vbox);

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
		stage.setTitle("An Example of the SepiaTone Effect");
		// Display the Stage
		stage.show();
	}

}
