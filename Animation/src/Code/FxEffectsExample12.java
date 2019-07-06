package Code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FxEffectsExample12 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the ColorInputs
		ColorInput topInput = new ColorInput(0, 0, 100, 50, Color.LIGHTGREEN);
		ColorInput bottomInput = new ColorInput(50, 25, 100, 50, Color.PURPLE);

		// Create the Effect
		Blend effect = new Blend();
		// Add the ColorInputs to the Effect
		effect.setTopInput(topInput);
		effect.setBottomInput(bottomInput);

		// Create the Rectangle
		Rectangle rect = new Rectangle(150, 75);
		// Set the Effect to the Rectangle
		rect.setEffect(effect);

		// Create the ComboBox for the BlendModes
		ComboBox<BlendMode> blendModeList = new ComboBox<>();
		blendModeList.setValue(effect.getMode());
		blendModeList.getItems().addAll(BlendMode.values());

		// Create the Slider
		Slider opacitySlider = new Slider (0, 1.0, 1.0);
		opacitySlider.setMajorTickUnit(0.10);
		opacitySlider.setShowTickMarks(true);
		opacitySlider.setShowTickLabels(true);

		// Bind the Properties to the Effect
		effect.modeProperty().bind(blendModeList.valueProperty());
		effect.opacityProperty().bind(opacitySlider.valueProperty());

		// Create the GridPane
		GridPane pane = new GridPane();
		// Set horizontal and vertical Spacing
		pane.setHgap(5);
		pane.setVgap(10);

		// Add the Children to the GridPane
		pane.addRow(0, new Label("Blend Mode:"), blendModeList);
		pane.addRow(1, new Label("Opacity:"), opacitySlider);

		// Create the HBox
		HBox root = new HBox();
		// Add Rectangle and GridPane to the HBox
		root.getChildren().addAll(rect, pane);
		// Define Spacing
		root.setSpacing(30);

		// Set the Padding and Border for the HBox
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
		stage.setTitle("An Example of the Blend Effect");
		// Display the Stage
		stage.show();
	}

}
