package Code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.FloatMap;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxEffectsExample10 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the Effect
		DisplacementMap effect = new DisplacementMap();

		// Define width and height for the FloatMap
		int width = 250;
		int height = 50;

		// Create the FloatMap
		FloatMap map = new FloatMap(width, height);

		double xDisplacement = 1.0;

		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				double u = xDisplacement;

				if (j < height / 2)
				{
					// Move the top-half pixels to the right (a nagative value)
					u = -1.0 * (u * xDisplacement / width);
				}
				else
				{
					// Move the bottom-half pixels to the left (a positive value)
					u = u * xDisplacement / width;
				}

				// Set values for band 0 and 1
				map.setSamples(i, j, (float)u, 0.0f);
			}
		}

		// Create the Text
		Text text = new Text("A Displaced Text Example");
		// Set Font of the Text
		text.setFont(Font.font(null,36));
		// Set the Effect to the Text
		text.setEffect(effect);

		// Set the Map to the Effect
		effect.setMapData(map);

		// Create the HBox
		HBox root = new HBox();
		// Add the Text to the HBox
		root.getChildren().add(text);

		// Set the Padding and Border for the HBox
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root,450,150);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title of the Stage
		stage.setTitle("An Example of the DisplacementMap Effect");
		// Display the Stage
		stage.show();
	}
}
