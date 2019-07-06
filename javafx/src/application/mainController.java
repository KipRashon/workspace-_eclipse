package application;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

import javafx.scene.control.Pagination;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class mainController implements Initializable{


	@FXML
	private Dialog<String> dialog;
	@FXML
	private Pagination page;
	@FXML
	private Label lb;
	@FXML
	private TextField name;
	@FXML
	private PasswordField pass;

	public void onAction(ActionEvent event) {
		String thename=name.getText();
		lb.setText("Welcome   "+thename+ " You are succesfully logged in"+"\n your password is: "+pass.getText());
		name.setText("");
		pass.setText("");
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
}
