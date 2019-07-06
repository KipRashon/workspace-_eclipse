package hello;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class javafx extends Application{

	@Override
	public void start(Stage primarystage) throws Exception {
		// first create the button and the label
		Button bt = new Button("Click me");
		Label lb=new Label();
		//create the action listener for the button here
	
		bt.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			String dontknow=	event.getSource().toString();
			System.out.println(dontknow);
				
			}
		});
		
		//create the layou here
		VBox vb= new VBox();
		vb.getChildren().addAll(lb,bt);
		
		Scene sc= new Scene(vb,400,300);
		//set the primary stage scene
		primarystage.setScene(sc);
		primarystage.show();
	}
	//create the method
	
	public static void main(String args[]) {
		launch(args);
	}
	//create the handler method here
	public void onClick() {
		System.out.println("Hello world");
	}
}
