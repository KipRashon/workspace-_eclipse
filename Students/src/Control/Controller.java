package Control;

import Assist.Assist;
import beans.Student;
import beans.error;
import database.DAO;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


import javax.swing.*;
import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Controller implements Initializable {
    private Assist assist;
    private DAO dao;
    private String action="";

    @FXML
    private TextArea historyLog,errorLog;

    @FXML
    private BorderPane sweetHome;

    @FXML
    private Button home,newButton,update,delete,exit,buttonSave;


    @FXML
    private Tab history;

    @FXML
    private TableView<Student> table;

    @FXML
    private VBox updateNew;

    @FXML
    private TextField firstName,lastName,stream,form,admission,age,birth,gender;

    @FXML
    private Tab errorTab;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dao=new DAO();
        assist= new Assist();
        prepareTable();

        updateNew.setOnMouseEntered(event -> increaseDecrease("i"));
        updateNew.setOnMouseExited(event -> increaseDecrease("d"));
        newButton.setOnAction(event -> loadAnotherWindow());
        home.setOnAction(event -> loadHomeWindow());
        exit.setOnAction(event -> handleExit());
        update.setOnAction(event -> handleUpdate());
        prepareHistory();
        history.setOnSelectionChanged(event -> {
                    history.setStyle("-fx-background-color:blue");
                    errorTab.setStyle("-fx-background-color: grey");
                }
        );

        errorTab.setOnSelectionChanged(event -> {
          historyLog.setOpacity(0.5);
          errorLog.setOpacity(1.0);

        });
       table.setOnMouseClicked(event -> handleText());
       delete.setOnAction(event -> handleDelete());
        buttonSave.setOnAction(event -> saveData());

    }

    private void prepareHistory() {
        ResultSet rs = dao.selectHistory();
        historyLog.setText("");
        try {
              while(rs.next())
              {
                  String message=String.format("%s\t%s\t%s\n",rs.getString("date"),rs.getString("time"),rs.getString("action"));
                  historyLog.setText(historyLog.getText()+message);
              }
            } catch (SQLException e) {
                e.printStackTrace();
            }


    }

    //save the data from the text fields
    private void saveData() {
        try {
            Student student = new Student(firstName.getText(), lastName.getText(),
                    form.getText(), stream.getText(), birth.getText(),
                    gender.getText(), Integer.parseInt(admission.getText()),
                    Integer.parseInt(age.getText()));


            if (action.equalsIgnoreCase("new") && !assist.checkIfNull(student)) {

                dao.insertNew(student);
                JOptionPane.showMessageDialog(null, "Student saved !", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else if (action.equalsIgnoreCase("update") && !assist.checkIfNull(student)) {
                dao.updateStudent(student, getSelected());
                JOptionPane.showMessageDialog(null, "Student Updated !", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

            prepareTable();
            prepareHistory();
            buttonSave.setVisible(false);
            admission.setEditable(true);
        }catch (Exception e)
        {}
    }

    public void prepareTable(){
        // private String firstname,lastname,form,stream,dateOfBirth,gender;
        //    private int age ,admission;

        TableColumn<Student, String> firstNameCol = new TableColumn<>("FirstName");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));

        TableColumn<Student, String> lastNameCol = new TableColumn<>("LastName");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));

        TableColumn<Student, String> formCol = new TableColumn<>("Form");
        formCol.setMinWidth(100);
        formCol.setCellValueFactory(new PropertyValueFactory<>("form"));

        TableColumn<Student, String> streamCol = new TableColumn<>("Stream");
        streamCol.setMinWidth(100);
        streamCol.setCellValueFactory(new PropertyValueFactory<>("stream"));

        TableColumn<Student, String> dateOfBirthCol = new TableColumn<>("Favorite Game");
        dateOfBirthCol.setMinWidth(100);
        dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        TableColumn<Student, String> genderCol = new TableColumn<>("Gender");
        genderCol.setMinWidth(100);
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<Student, Integer> ageCol = new TableColumn<>("age");
        ageCol.setMinWidth(100);
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Student, Integer> admissionCol = new TableColumn<>("Admission");
        admissionCol.setMinWidth(100);
        admissionCol.setCellValueFactory(new PropertyValueFactory<>("admission"));


        table.getColumns().addAll(admissionCol,firstNameCol,lastNameCol,formCol,streamCol,dateOfBirthCol,genderCol,ageCol);
        table.setItems(dao.selectAll());

    }
    public void loadAnotherWindow(){
        setFieldsEmpty();
        action="new";
        increaseDecrease("i");
        admission.setOnMouseExited(event -> assist.handleIntegerField("admission", admission));
        age.setOnMouseExited(event -> assist.handleIntegerField("age", age));
        admission.setOnMouseEntered(event -> admission.setPromptText("Admission"));
        age.setOnMouseEntered(event -> age.setPromptText("Age"));

    }

    private void setFieldsEmpty() {
        ObservableList<?>fields= updateNew.getChildren();
       for (int i=0;i<fields.size();i++)
       {
           try {
               ((TextField) fields.get(i)).setText("");
               ((TextField)fields.get(i)).setEditable(true);

               buttonSave.setVisible(true);
           }
           catch (Exception e)
           {

           }
       }

    }

    public void loadHomeWindow(){
        assist.loadWindow("/View/sample.fxml",sweetHome);

    }

    //action listener for exit button
    public void handleExit(){
        if(JOptionPane.showConfirmDialog(null,"Do you really wanna exit","Confirm",JOptionPane.WARNING_MESSAGE,
                JOptionPane.YES_OPTION)==JOptionPane.YES_OPTION){System.exit(0);}
        else{
            return;
        }



    }
   // Action listener for the update button
    public void handleUpdate(){
        increaseDecrease("i");
        action="update";
        buttonSave.setVisible(true);
        admission.setEditable(false);

    }
    public Student getSelected(){
       return (Student) table.getSelectionModel().getSelectedItem();
    }



    public void handleText(){
        try {
            Student student = (Student) table.getSelectionModel().getSelectedItem();
            firstName.setText(student.getFirstname());
            lastName.setText(student.getLastname());
            stream.setText(student.getStream());
            form.setText(student.getForm());
            admission.setText(String.valueOf(student.getAdmission()));
            age.setText(String.valueOf(student.getAge()));
            birth.setText(student.getDateOfBirth());
            gender.setText(student.getGender());
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Select the correct student");
        }
    }
    public void handleDelete(){
        Student toBeDeleted=(Student)table.getSelectionModel().getSelectedItem();
        if(toBeDeleted==null){JOptionPane.showMessageDialog(null,"Please select the student first","Error",JOptionPane.WARNING_MESSAGE);
        return;
        }
        if(JOptionPane.showConfirmDialog(null,"Do you realy want to delete the student?","Confirm",JOptionPane.WARNING_MESSAGE,
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            dao.deleteStudent(toBeDeleted);
            prepareHistory();
            prepareTable();
        }
        else{
            return;
        }


    }



    //method to increase the opacity
    public void increaseDecrease(String toDo)
    {

       ObservableList<?>fields= updateNew.getChildren();
       for(int i=0;i<fields.size();i++)
       {
           if(toDo.equals("i")) {
               for(int k=0;k<=100;k++) {
                   slowMotion(fields, i, k);
               }
           }
           else if(toDo.equalsIgnoreCase("d"))
           {
               for(int k=100;k>=0;k--) {
                   slowMotion(fields, i, k);
               }
           }
       }
    }

    private void slowMotion(ObservableList<?> fields, int i, int k) {
        try{
        ((TextField) fields.get(i)).setOpacity(k * 0.01);


            TimeUnit.MICROSECONDS.sleep(40);
        } catch (Exception e) {

        }
    }
}
