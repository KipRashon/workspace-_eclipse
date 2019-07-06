package Control;

import database.DAO;

public class Test{
    public static void main(String []arg){
        DAO d= new DAO();
        System.out.println(d.selectedStudent());
    }

}
