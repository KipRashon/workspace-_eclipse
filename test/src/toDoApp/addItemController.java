package toDoApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class addItemController implements Initializable {
	@FXML
	private ImageView addButton;
	@FXML
    private Label notasklabel;
	  @FXML
	    private AnchorPane pane;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//add a mouse event into the add button which is the mouse clickedevent
	addButton.addEventHandler(MouseEvent.MOUSE_CLICKED , e->{
		Shaker shaker=new Shaker(addButton);
		shaker.Shake();
		
		System.out.println("You clicked the add button which is an image form");
	transist(addButton);
	transist(notasklabel);
	//please do this if and only you are done transisting
	try {
		AnchorPane thepane=FXMLLoader.load(getClass().getResource("addItemForm.fxml"));
	     animate(thepane);
		pane.getChildren().setAll(thepane);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	});
	}
	private void animate(AnchorPane thepane) {
		FadeTransition transist= new FadeTransition(Duration.millis(4100),thepane);
		transist.setFromValue(0f);
		transist.setToValue(1f);
		transist.setAutoReverse(false);
		transist.setCycleCount(1);
		transist.play();
		
	}
	private void transist(Node node) {
	node.relocate(0, 10);
	node.setOpacity(0);	
	FadeTransition fade=new FadeTransition(Duration.millis(2000),node);
	fade.setFromValue(1f);
	fade.setToValue(0f);
	fade.setCycleCount(2);
	fade.setAutoReverse(false);
	fade.play();
	
	}

}
