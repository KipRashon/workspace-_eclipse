package Assist;

import beans.Student;
import beans.error;
import database.DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator{
    DAO dao;
    private Student investigate;
    public Validator(Student toInvestigate){
        dao= new DAO();
     this.investigate=toInvestigate;
    }
    private boolean checkAdmission(){
       for(int adm:dao.getAdmissions()){
           if(adm==investigate.getAdmission()){
               dao.insertError(new error("Admission already exists"));
               return false;
           }
       }
       if(investigate.getAdmission()<1000){
           dao.insertError((new error("Admission has to be four digits")));
           return false;
       }
        return true;
    }

    private boolean checkDate(){

        int now=Integer.parseInt((new SimpleDateFormat("yyyy").format(new Date())));
        String[] birthDay = investigate.getDateOfBirth().split("-");
        if(now-Integer.parseInt(birthDay[2])==investigate.getAge()){
            return true;
        }
        else{
            dao.insertError((new error("The birthday does not match age")));
            return false;
        }
    }

    public void processAll(){

        if(!checkAdmission()){
            return;
        }
        else if(!checkDate()){
            return;
        }

    }

}