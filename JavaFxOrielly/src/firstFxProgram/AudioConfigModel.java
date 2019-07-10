/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstFxProgram;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author KIPTOO
 */
public class AudioConfigModel {
    //minimum audio volume in decibels
    public double minDecibels= 0.0;
    public double maxDecibels=160.0;//max audio volume in decibels
    //the selected audio volume in decibels
    public IntegerProperty selectedDbs= new SimpleIntegerProperty(0);
    
    
    public BooleanProperty muting= new SimpleBooleanProperty(false);
    
    //list of musical genres 
    public ObservableList genres= FXCollections.observableArrayList(
            "Chamber",
            "Country",
            "Cowbell",
            "Polka",
            "Rock"
    );
    
    //a reference to the selection model by slider 
    public SingleSelectionModel genreSelectionModel;
    //adds a change to the listener to the selection model of the choice box and contains
    //code that executes when the selection in the choice box changes 
    
    public void addListenerToGenreSelectionModel()
    {
        genreSelectionModel.selectedIndexProperty().addListener((Observable o)->{
            int selectedIndex= genreSelectionModel.selectedIndexProperty().getValue();
            switch(selectedIndex)
            {
                case 0:
                    selectedDbs.setValue(80);
                    break;
                case 1:
                    selectedDbs.setValue(100);
                    break;
                case 2:
                    selectedDbs.setValue(150);
                    break;
                case 3:
                    selectedDbs.setValue(140);
                    break;
                case 4:
                    selectedDbs.setValue(120);
                    break;
                case 5:
                    selectedDbs.setValue(130);
                    break;
                    
                    
                    
            }
        
        });
    }
}
