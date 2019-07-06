package Code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxEffectsExample2  extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the Effect for the Text
		InnerShadow textShadow = new InnerShadow();

		// Create the Text
		Text text = new Text("Inner Shadow");
		// Set Color and Font of the Text
		text.setFill(Color.RED);
		text.setFont(Font.font(null, FontWeight.BOLD, 36));
		// Set the Effect to the Text
		text.setEffect(textShadow);

		// Create the Rectangle
		Rectangle rectangle = new Rectangle(200, 100, Color.LIGHTGRAY);

		// Create the Sliders for the Text
		Slider textOffsetXSlider = new Slider(-200, 200, 0);
		Slider textOffsetYSlider = new Slider(-200, 200, 0);

		// Bind the Properties to the Text Effect
		textShadow.offsetXProperty().bind(textOffsetXSlider.valueProperty());
		textShadow.offsetYProperty().bind(textOffsetYSlider.valueProperty());

		// Create the Effect for the Rectangle
		InnerShadow rectangleShadow = new InnerShadow();
		rectangleShadow.setColor(Color.GRAY);

		// Create the Sliders for the Rectangle
		Slider rectangleOffsetXSlider = new Slider(-200, 200, 0);
		Slider rectangleOffsetYSlider = new Slider(-200, 200, 0);

		// Bind the Properties to the Rectangle Effect
		rectangleShadow.offsetXProperty().bind(rectangleOffsetXSlider.valueProperty());
		rectangleShadow.offsetYProperty().bind(rectangleOffsetYSlider.valueProperty());

		// Set the Effect to the Rectangle
		rectangle.setEffect(rectangleShadow);

		// Create the TextBox
		VBox textBox = new VBox();
		// Add the Children to the TextBox
		textBox.getChildren().addAll(new Label("TextOffsetX:"), textOffsetXSlider, new Label("TextOffsetY:"), textOffsetYSlider);
		textBox.setSpacing(10);

		// Create the RectangleBox
		VBox rectangleBox = new VBox();
		// Add the Children to the RectangleBox
		rectangleBox.getChildren().addAll(new Label("RectangleOffsetX:"), rectangleOffsetXSlider, new Label("RectangleOffsetY:"), rectangleOffsetYSlider);
		rectangleBox.setSpacing(10);

		// Create the GridPane
		GridPane root = new GridPane();
		// Set horizontal and vertical Spacing
		root.setHgap(5);
		root.setVgap(10);

		// Add the Children to the GridPane
		root.addRow(0, text,textBox);
		root.addRow(1, rectangle,rectangleBox);

		// Set the Padding and Border for the GridPane
		root.setStyle("-fx-padding: 10;" +
			"-fx-border-style: solid inside;" +
			"-fx-border-width: 2;" +
			"-fx-border-insets: 5;" +
			"-fx-border-radius: 5;" +
			"-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title of the Stage
		stage.setTitle("An Example of the InnerShadow Effect");
		// Display the Stage
		stage.show();
	}

}
