package Code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxEffectsExample8 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the Effect
		Reflection reflection = new Reflection();

		// Create the Text
		Text text = new Text("Reflection");
		// Set Color and Font of the Text
		text.setFill(Color.BLACK);
		text.setFont(Font.font(null, FontWeight.BOLD, 36));
		// Set the Effect to the Text
		text.setEffect(reflection);

		// Create the Sliders
		Slider topOffsetSlider = new Slider(0.0, 1.0, 0);
		Slider fractionSlider = new Slider(0.0, 1.0, 0);
		Slider topOpacitySlider = new Slider(0.0, 1.0, 0);
		Slider bottomOpacitySlider = new Slider(0.0, 1.0, 0);

		// Bind the Properties to the Effect
		reflection.topOffsetProperty().bind(topOffsetSlider.valueProperty());
		reflection.fractionProperty().bind(fractionSlider.valueProperty());
		reflection.topOpacityProperty().bind(topOpacitySlider.valueProperty());
		reflection.bottomOpacityProperty().bind(bottomOpacitySlider.valueProperty());

		// Create the VBox for the Slider
		VBox vbox = new VBox();
		// Add the Children to the VBox
		vbox.getChildren().addAll(new Label("TopOffset:"), topOffsetSlider,new Label("Fraction:"), fractionSlider,
				new Label("TopOpacity:"), topOpacitySlider,new Label("BottomOpacity:"), bottomOpacitySlider);
		vbox.setSpacing(10);

		// Create the GridPane
		GridPane root = new GridPane();
		// Set horizontal and vertical Spacing
		root.setHgap(5);
		root.setVgap(10);

		// Add the Children to the GridPane
		root.addRow(0, text, vbox);

		// Set the Padding and Border for the GridPane
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root,400,250);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title of the Stage
		stage.setTitle("An Example of the Reflection Effect");
		// Display the Stage
		stage.show();
	}
}
