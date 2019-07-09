/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstFxProgram;

import java.io.FileInputStream;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author KIPTOO
 */
public class HelloEarthRise extends Application{

    public static void main(String[]args)
    {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
       String message="Earthrise at Christmas:"
               + "[Forty] year ago this Christmas, a turbulen world"
               + "looked to heavens for unique view of our home"
               + "planet. This photo of the Earthrise over the lunar horizon"
               + "was taken by the Apollo 8 crew in December 1968, showing"
               + "Earth for the first time as it appears from deep space"
               + "Astronouts Fran Borman, Jim Lovell and William Anders"
               + "had ecome the first humans to leave Earth orbit,"
               + " entering lunar orbit on Christmas Eve. IN a historic live "
               + "broadcast that night, the crew took turns reading from "
               + "the Book of Genesis, closing with a holiday wish from "
               + "Commander Borman:  \"We close with goodnight, good luck,"
               + "a Merry Christmas, and God bless all of you -- all of "
               + "you on the good Earth.\"" ;
       
       //reference to the text
        Text textRef= new Text(message);
        textRef.setLayoutY(100);
        textRef.setTextOrigin(VPos.TOP);
        textRef.setTextAlignment(TextAlignment.JUSTIFY);
        textRef.setWrappingWidth(400);
        textRef.setFill(Color.rgb(187, 195, 107));
        textRef.setFont(Font.font("SansSerif",FontWeight.BOLD,24));
        
        //Provide animated scrolling behaviour  to the text
        TranslateTransition transTransition= new TranslateTransition(new Duration(75000),
        textRef);
        transTransition.setToY(-820);
        transTransition.setInterpolator(Interpolator.LINEAR);
        transTransition.setCycleCount(Timeline.INDEFINITE);
        
        //create and image view containing the image 
        Image image= new Image("test.jpg");
        ImageView iView= new ImageView(image);
        
        //Create a group containing the text
        Group textGroup= new Group(textRef);
        textGroup.setLayoutX(50);
        textGroup.setLayoutY(180);
        textGroup.setClip(new Rectangle(430,85));
        
        
        //Combine the image view and the group
        Group root=  new Group(iView,textGroup);
        Scene scene = new Scene(root,516,387);
        
        //set up the stage 
        
           stage.setScene(scene);
           stage.setTitle("Hello Earthrise");
           stage.show();
           
           //start your animation when the screen has been shown
           transTransition.play();
        
    }
    
}
