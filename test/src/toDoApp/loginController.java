package toDoApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class loginController implements Initializable{
	@FXML
	private TextField loginUser;
	@FXML
	private PasswordField loginPassword;
	@FXML
	private Button LoginButton;
	@FXML
	private Button loginSignupButton;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		//the action event for the login button
		
		LoginButton.setOnAction(e ->
		{
			
			String us=loginUser.getText();
			String pwd=loginPassword.getText();
			
			DAO d= new DAO();
			if(d.checkIfExist(us, pwd)) {
				try {
					
					
					goNextPage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
			
					e1.printStackTrace();
				}
			}
			else {
				Shaker theshaker= new Shaker(loginUser);
				theshaker.Shake();
				theshaker= new Shaker(loginPassword);
				theshaker.Shake(); 
				//JOptionPane.showMessageDialog(null, "Please login with the correct details");
			}
		}
				);
		
		//the action handling for the sign up button
		loginSignupButton.setOnAction(e ->{
			//hides the current window that is being shown
			loginSignupButton.getScene().getWindow().hide();
			//refers us to the next screen
			try {
				Parent root=FXMLLoader.load(getClass().getResource("signup.fxml"));
				Scene scene= new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.showAndWait();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}


	private void goNextPage() throws IOException {
		LoginButton.getScene().getWindow().hide();
		Parent root= FXMLLoader.load(getClass().getResource("addItem.fxml"));
		Scene scene= new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}


	

}
