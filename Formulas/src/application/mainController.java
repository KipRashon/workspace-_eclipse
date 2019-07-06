package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class mainController implements Initializable {
	@FXML
	private  TextField distance;
	@FXML
	private  TextField firstSpeed;
	@FXML
	private  TextField secondSpeed;
	@FXML
	private  TextField startingTime;
	
	  @FXML
	    private Button finishTime;

	    @FXML
	    private TextArea textArea;

	    @FXML
	    private Button meetingDistance;

	    @FXML
	    private TextField first;

	    @FXML
	    private TextField second;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// code to handle the binding of the textfields to the text area
		
		
		meetingDistance.setOnAction(e->{
			double dist=getValue(distance);
			double spe1=getValue(firstSpeed);
			double spe2=getValue(secondSpeed);
			
			double ans=calculate(dist, spe2, spe1);
		
		});
		
	}
	private String getString(TextField first2) {
		
		return first2.getText();
	}
	//need a method to get the values from the textfields
	private static Double getValue(TextField tx) {
		double fromText=Double.parseDouble(tx.getText());
		return fromText;
	}
	//method to do the calculation
	private static double calculate(double dist,double spe2,double spe1) {
		//d/(s2/s1+1)

		
		return dist/((spe2/spe1)+1);

	}

}
