package database;
import beans.History;
import beans.Student;
import beans.error;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAO {
    private Connection conn;

    public DAO() {
        conn = new ConnectionProvider().getConnected();
    }

    //method to insert new student into the database
    public void insertNew(Student st) {
        try {
            PreparedStatement pt = conn.prepareStatement("insert into students values (?,?,?,?,?,?,?,?)");
            setStudentToStatement(st, pt);
            //insert the action into history
            insertHistory(new History("Inserted a new Student"+st.getFirstname()+" "+st.getLastname()+" into database"));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void insertSelected(Student st) {
        deleteFromSelected("selected");
        try {
            PreparedStatement pt = conn.prepareStatement("insert into selected values (?,?,?,?,?,?,?,?)");
            setStudentToStatement(st, pt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setStudentToStatement(Student st, PreparedStatement pt) {
        try {
            pt.setString(1, st.getFirstname());
            pt.setString(2, st.getLastname());
            pt.setString(3, st.getStream());
            pt.setString(4, st.getForm());
            pt.setInt(5, st.getAdmission());
            pt.setInt(6, st.getAge());
            pt.setString(7, st.getDateOfBirth());
            pt.setString(8, st.getGender());
            pt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Student> selectAll() {

        ObservableList<Student> students = FXCollections.observableArrayList();
        String query = "select * from students order by admission desc";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                //String firstname, String lastname, String form, String stream, String dateOfBirth, String gender,int admission, int age
                Student student = new Student(rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("form"), rs.getString("stream"), rs.getString("birth"), rs.getString("gender"),
                        rs.getInt("admission"), rs.getInt("age")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student selectedStudent() {
        Student student = new Student();
        String query = "select * from selected order by admission desc LIMIT 1";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                //String firstname, String lastname, String form, String stream, String dateOfBirth, String gender,int admission, int age
                student = new Student(rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("form"), rs.getString("stream"), rs.getString("birth"), rs.getString("gender"),
                        rs.getInt("admission"), rs.getInt("age")
                );

                deleteFromSelected("selected");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return student;
    }

    private void deleteFromSelected(String table) {
        String delete = "DELETE FROM "+table;
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(delete);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

//method to update an existing student
public void updateStudent(Student newStudent,Student previous){
        String stmt="update students set firstname=?,lastname=?,stream=?," +
                "form =?,admission =?,age =?,birth =?," +
                "gender =? where admission=?";

    try {
        PreparedStatement pt=conn.prepareStatement(stmt);
        pt.setInt(9,previous.getAdmission());
        setStudentToStatement(newStudent,pt);

        insertHistory(new History("Updated an existing student from "+previous.getFirstname() +" to "+previous.getFirstname()));
    } catch (SQLException e) {
        e.printStackTrace();
    }

}
//method to delete the existing student from the database
    public void deleteStudent(Student tobeDeleted){


            String query="delete from students where admission=? and age=?";
            try {
                PreparedStatement pt= conn.prepareStatement(query);
                pt.setInt(1,tobeDeleted.getAdmission());
                pt.setInt(2,tobeDeleted.getAge());
                pt.executeUpdate();
                JOptionPane.showMessageDialog(null,tobeDeleted.getFirstname()+" "+tobeDeleted.getLastname()+" deleted","Warning",JOptionPane.INFORMATION_MESSAGE);
            //method to insert the actoin
                insertHistory(new History("Deleted the "+ tobeDeleted.getFirstname()+" from the database"));
            } catch (SQLException e) {
                e.printStackTrace();
            }


    }
    //method to return all the admissions in the database
    public List<Integer> getAdmissions(){

        List<Integer>admission=new ArrayList<>();
        String query="select admission from students ";
        try {
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                admission.add(rs.getInt("admission"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admission;
    }

    //method to insert the error message
    public void insertError(error err){
        try {
            PreparedStatement pt=conn.prepareStatement("insert into errorlog values(?,?,?)");
            pt.setString(1,err.getDate());
            pt.setString(2,err.getTime());
            pt.setString(3,err.getMessage());
            pt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //method to get all the errors
    public List<String> getAllErrors(){
        List<String>messages= new ArrayList<>();
       String query="select * from errorlog order by date desc,time desc";
        try {
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                messages.add(rs.getString("error"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
    public void insertHistory(History bean)
    {
        try {
            PreparedStatement st= conn.prepareStatement("insert into history values (?,?,?)");
            st.setString(1,bean.getDate());
            st.setString(2,bean.getTime());
            st.setString(3,bean.getAction());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //method to select everything from the history table
    public ResultSet selectHistory()
    {
        String query="SELECT * FROM history  ORDER BY date DESC,time DESC";
        try {
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //method to check if the customer exists in the database
    public boolean checkAdmission(int admission)
    {
        boolean tof=false;
        try {
            PreparedStatement preparedStatement= conn.prepareStatement("SELECT * FROM students where admission=?");
            preparedStatement.setInt(1,admission);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next())
            {
              tof=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tof;
    }
}
