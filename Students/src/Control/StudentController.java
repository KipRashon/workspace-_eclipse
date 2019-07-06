package Control;

import Assist.Assist;
import beans.Student;
import database.DAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {


    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private TextField stream;

    @FXML
    private TextField form;

    @FXML
    private TextField age;

    @FXML
    private TextField admission;

    @FXML
    private ComboBox<String> gender;

    @FXML
    private Button saveButton;

    @FXML
    private DatePicker date;
    @FXML
    private AnchorPane container;

    private DAO dao;
    Assist assist;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assist= new Assist();
        dao= new DAO();
        gender.getItems().addAll("Male","Female");
        saveButton.setOnAction(event -> {dao.insertNew(prepareSave());
            BorderPane sweetHome= ((BorderPane) container.getParent().getParent());
            assist.loadWindow("/View/sample.fxml",sweetHome);

        });

    }
    private Student prepareSave(){

        //String firstname, String lastname, String form, String stream, String dateOfBirth, String gender,int admission, int age
        return assist.getStudent(fname, lname, form, stream, date, gender, admission, age);

    }


}
