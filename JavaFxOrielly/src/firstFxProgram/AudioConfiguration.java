/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstFxProgram;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author KIPTOO
 */
public class AudioConfiguration extends Application{
    AudioConfigModel audioConfig= new AudioConfigModel();
    Text text,mutingText,genreText;
    Slider slider;
    CheckBox muting;
    ChoiceBox genrechoice;
    Color color= Color.color(0.66, 0.67, 0.69);
    
    public static void main(String args[])
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Text title = new Text(65,12,"Audio Configuration");
        title.setTextOrigin(VPos.TOP);
        title.setFill(Color.WHITE);
        title.setFont(Font.font("SansSerif",FontWeight.BOLD,20));
        
        text= new Text();
        text.setLayoutX(18);
        text.setLayoutY(69);
        text.setTextOrigin(VPos.TOP);
        text.setFill(Color.web("0x242C55"));
        text.setFont(Font.font("SansSerif",FontWeight.BOLD,18));
        
        mutingText= new Text(18,113,"Muting");
        mutingText.setTextOrigin(VPos.TOP);
        mutingText.setFont(Font.font("SanSerif",FontWeight.BOLD,18));
        mutingText.setFill(Color.web("0x242C55"));
        
        genreText= new Text(18,113,"Genre");
        genreText.setTextOrigin(VPos.TOP);
        genreText.setFont(Font.font("SanSerif",FontWeight.BOLD,18));
        genreText.setFill(Color.web("0x242C55"));
        
        slider= new Slider();
        slider.setLayoutX(135);
        slider.setLayoutY(69);
        slider.setPrefWidth(162);
        slider.setMin(audioConfig.minDecibels);
        slider.setMax(audioConfig.maxDecibels);
        
        muting= new CheckBox();
        muting.setLayoutX(280);
        muting.setLayoutY(113);
        
        genrechoice= new ChoiceBox();
        genrechoice.setLayoutX(204);
        genrechoice.setLayoutY(154);
        genrechoice.setPrefWidth(93);
        genrechoice.setItems(audioConfig.genres);
        Stop[] stops= new Stop[]{
            new Stop(0,Color.web("0xAEBBCC")),
            new Stop(1, Color.web("0x6D84A3"))
        };
        
        LinearGradient linearGradient= new LinearGradient(0,0,0,1,true,
                CycleMethod.NO_CYCLE,stops);
        Rectangle rectangle1 = new Rectangle(0,0,320,45);
        rectangle1.setFill(linearGradient);
        
        Rectangle rectangle2 = new Rectangle(0,43,320,300);
        rectangle2.setFill(Color.rgb(188, 206, 213));
        
        Rectangle rectangle3 = new Rectangle(8,54,300,130);
        rectangle3.setArcHeight(20);
        rectangle3.setArcWidth(20);
        rectangle3.setFill(Color.WHITE);
        rectangle3.setStroke(color);
        
        Line line1= new Line(9,97,309,97);
        line1.setStroke(color);
        
        Line line2= new Line(9,141,309,141);
        line2.setFill(color);
         Line line3= new Line(9,141,309,141);
        line3.setFill(color);
        
        Group group= new Group(rectangle1,title,rectangle2,rectangle3,
        text,slider,line1,mutingText,
                muting,line2,line3,genrechoice
        );
        
        Scene scene= new  Scene(group,320,343);
        
        text.textProperty().bind(audioConfig.selectedDbs.asString().concat("dB"));
        slider.valueProperty().bindBidirectional(audioConfig.selectedDbs);
        slider.disableProperty().bind(audioConfig.muting);
        audioConfig.genreSelectionModel= genrechoice.getSelectionModel();
        audioConfig.addListenerToGenreSelectionModel();
        audioConfig.genreSelectionModel.selectFirst();
        
        
        stage.setScene(scene);
        stage.setTitle("Audio Configuration simulator");
        stage.show();
        
        
        
    }
    
}
