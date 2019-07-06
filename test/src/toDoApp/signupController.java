package toDoApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.PasswordField;

import javafx.scene.control.CheckBox;

public class signupController implements Initializable {
	DAO d;
	@FXML
	private CheckBox signUpCheckBoxMale;
	@FXML
	private CheckBox signUpCheckBoxFemale;
	@FXML
	private Button signUpButton;
	@FXML
	private TextField signUpFirstname;
	@FXML
	private TextField signUpLastname;
	@FXML
	private TextField signUpLocation;
	@FXML
	private TextField signUpUsername;
	@FXML
	private PasswordField signUpPassword;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
		signUpButton.setOnAction(e->{
			insertUser();
			System.out.println("Your data may or may  not have been saved");
		});
	}
	//method to handle the saving of data from the screen
	public void insertUser() {
		String thegender;
		if(signUpCheckBoxFemale.isSelected()) {
			thegender="female";
		}
		else {
			thegender="male";
		}
		d=new DAO();
		signUpBean bean=new signUpBean();
		bean.setFirstname(signUpFirstname.getText());
		bean.setLastname(signUpLastname.getText());
		bean.setUsername(signUpUsername.getText());
		bean.setGender(thegender);
		bean.setPassword(signUpPassword.getText());
		bean.setLocation(signUpLocation.getText());
		if(bean!=null) {
			d.insertUser(bean);
		}
	}

}















