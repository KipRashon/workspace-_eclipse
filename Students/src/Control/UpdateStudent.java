package Control;

import Assist.*;
import beans.Student;

import database.DAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateStudent implements Initializable {
    Assist assist;
    DAO dao;
    Student previous;
    Validator validator;

    BorderPane sweetHome;

    @FXML
    private TextField fname;


    @FXML
    private AnchorPane container;

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
    private Button save;

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<String> gender;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        dao= new DAO();
         previous = dao.selectedStudent();
        assist= new Assist();
//        assist.setUpFields(fname, lname, form, stream, date, admission, age,previous);
        gender.getItems().addAll("Male","Female");
        save.setOnAction(event ->handleSave());

    }
    //method to prepare save and exit the window
    private void handleSave(){
        Student newStudent=assist.getStudent(fname, lname, form, stream, date, gender, admission, age);
        if(newStudent!=null) {
            Validator validator = new Validator(newStudent);
            validator.processAll();
            sweetHome = ((BorderPane) container.getParent().getParent());

            dao.updateStudent(newStudent, previous);
            assist.loadWindow("/View/sample.fxml", sweetHome);
        }
    }


}
