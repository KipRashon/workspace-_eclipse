package Assist;

import beans.Student;

import beans.error;
import database.DAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Assist {
    DAO dao= new DAO();
    public void loadWindow(String design, BorderPane sweetHome){
        Stage previous=(Stage)sweetHome.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource(design));
            Stage primaryStage= new Stage();
            Scene scene=new Scene(root);
            primaryStage.setTitle("We can Do this");
            primaryStage.setScene(scene);
            primaryStage.show();
            previous.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //method to get text from the text fields
    public Student getStudent(TextField fname, TextField lname, TextField form, TextField stream, DatePicker date,
                              ComboBox<String> gender, TextField admission, TextField age) {
        try {
            Student student = new Student(fname.getText(), lname.getText(), form.getText(), stream.getText(), date.getValue().format(DateTimeFormatter.ISO_DATE), gender.getSelectionModel().getSelectedItem(), Integer.parseInt(admission.getText()), Integer.parseInt(age.getText()));

            return student;
        }catch (
                NullPointerException ex
        ){
            DAO dao= new DAO();
            dao.insertError(new error(ex.toString()));
            return null;
        }
    }



    public boolean checkIfNull(Student student) {
        boolean tof;
        if(student==null){tof=true;}
        else{tof=false;}
        return tof;
    }

    private boolean ifInteger(String value)
    {
        try
        {
            Integer.parseInt(value);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void handleIntegerField(String fieldName, TextField textField) {
        String value=textField.getText();
        if(value.equalsIgnoreCase(""))
        {
            //handle a null field

                textField.setStyle("-fx-border-width: 6;" +
                        "-fx-border-color: red;" +
                        "-fx-background-color: #453788;" );
                textField.setText("");
                textField.setPromptText("This field cannot be null");

        }
        else
        {
            if(ifInteger(value))
            {
                //handle if the value passed is an integer
                textField.setStyle("-fx-border-width: 6;" +
                        "-fx-border-color:  #2A0D47;" +
                        "-fx-background-color: white;" );
                if(fieldName.equalsIgnoreCase("age"))
                {
                    textField.setPromptText("Age");
                }
                else {
                    int admission=Integer.valueOf(value);
                    if(dao.checkAdmission(admission))
                    {
                        textField.setStyle("-fx-border-width: 6;" +
                                "-fx-border-color: red;" +
                                "-fx-background-color: #453788;" );
                        textField.setText("");
                        textField.setPromptText("Adm: "+admission+" already exists");
                    }
                    else
                    {
                        textField.setPromptText("Admission");
                    }
                }
            }
            else
            {
                //handle if the value passed is not an integer

                textField.setStyle("-fx-border-width: 6;" +
                        "-fx-border-color: red;" +
                        "-fx-background-color: #453788;" );

                textField.setText("");
                textField.setPromptText("Has to be an integer");

            }
        }


    }

    public void sortAgeProblem()
    {

    }
    }