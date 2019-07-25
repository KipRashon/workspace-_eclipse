/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlogin;

import java.io.File;

/**
 *
 * @author KIPTOO
 */
public class Test {
    public static void main(String args[])
    {
        File file= new File("src/fxmlogin/FXMLDocument.fxml");
        if(file.exists())
        {
            
            System.out.println("The file actually exist");
        }
        else
        {
            System.err.println("The file does not exist");
        }
    }
    
}
