package Code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxEffectsExample11 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the Effect
		ColorAdjust effect = new ColorAdjust();

		// Create the Image
		String file = "file:///Path-To-Your-File/JavaFx.jpg";
		Image image = new Image(file);

		// Create the ImageView
		ImageView imageView = new ImageView();
        imageView.setImage(image);
		// Set the Effect to the ImageView
        imageView.setEffect(effect);

        // Create the Sliders
		Slider hueSlider = new Slider(-1.0, 1.0, 0.0);
		Slider saturationSlider = new Slider(-1.0, 1.0, 0.0);
		Slider brightnessSlider = new Slider(-1.0, 1.0, 0.0);
		Slider contrastSlider = new Slider(-1.0, 1.0, 0.0);

		// Bind the Properties to the Effect
		effect.hueProperty().bind(hueSlider.valueProperty());
		effect.saturationProperty().bind(saturationSlider.valueProperty());
		effect.brightnessProperty().bind(brightnessSlider.valueProperty());
		effect.contrastProperty().bind(contrastSlider.valueProperty());

		// Create Array of Sliders
		Slider[] sliders = new Slider[]
		{
				hueSlider, saturationSlider,
				brightnessSlider, contrastSlider
		};

		// Define Properties for the Sliders
		for (Slider s : sliders)
		{
			s.setPrefWidth(300);
			s.setMajorTickUnit(0.10);
			s.setShowTickMarks(true);
			s.setShowTickLabels(true);
		}

		// Create the GridPane
		GridPane pane = new GridPane();
		// Set horizontal and vertical Spacing
		pane.setHgap(5);
		pane.setVgap(10);

		// Add the Children to the GridPane
		pane.addRow(0, new Label("Hue:"), hueSlider);
		pane.addRow(1, new Label("Saturation:"), saturationSlider);
		pane.addRow(2, new Label("Brightness:"), brightnessSlider);
		pane.addRow(3, new Label("Contrast:"), contrastSlider);

		// Create the BorderPane
		BorderPane root = new BorderPane();
		// Add the Children to the BorderPane
		root.setCenter(imageView);
		root.setBottom(pane);

		// Set the Padding and Border for the BorderPane
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
		stage.setTitle("An Example of the ColorAdjust Effect");
		// Display the Stage
		stage.show();
	}

}
