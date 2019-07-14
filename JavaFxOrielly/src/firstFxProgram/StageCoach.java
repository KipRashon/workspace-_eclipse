/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstFxProgram;

import java.util.List;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author KIPTOO
 */
public class StageCoach extends Application {
    
    StringProperty title= new SimpleStringProperty();
    
    Text textStageX,textStageY,textStageW,textStageH,textStageF;
    CheckBox resizableBox,fullScreenBox;
    
    double dragAnchorX,dragAnchorY;
    
    public static void main(String args[])
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StageStyle stageStyle= StageStyle.DECORATED;
        List<String> unnamedParams=getParameters().getUnnamed();
        if(unnamedParams.size()>0)
        {
            String stageStyleParam= unnamedParams.get(0);
            if(stageStyleParam.equalsIgnoreCase("transparent")){stageStyle=StageStyle.TRANSPARENT;}
            else if(stageStyleParam.equalsIgnoreCase("undecorated")){stageStyle= StageStyle.UNDECORATED;}
            else if(stageStyleParam.equalsIgnoreCase("utility")){stageStyle= StageStyle.UTILITY;}
     }
        
        final Stage stageRef= stage;
        Group rootGroup;
        TextField titleField;
        Button toBack= new Button("toBack()");
        toBack.setOnAction(e->stageRef.toBack());
         Button toFront= new Button("toFront()");
        toFront.setOnAction(e->stageRef.toFront());
         Button closeButton= new Button("close()");
        closeButton.setOnAction(e->stageRef.close());
        DoubleProperty height= new SimpleDoubleProperty(350);
        DoubleProperty width= new SimpleDoubleProperty(270);
        width.bind(stageRef.widthProperty());
        height.bind(stageRef.widthProperty());
        
       
        Rectangle blue= new Rectangle(250,350,Color.SKYBLUE);
        blue.setArcHeight(50);
        blue.setArcWidth(50);
        textStageX= new Text();
        textStageX.setTextOrigin(VPos.TOP);
        textStageY= new Text();
        textStageY.setTextOrigin(VPos.TOP);
        textStageH= new Text();
        textStageH.setTextOrigin(VPos.TOP);
        textStageW= new Text();
        textStageW.setTextOrigin(VPos.TOP);
        textStageF= new Text();
        textStageF.setTextOrigin(VPos.TOP);
        
        resizableBox= new CheckBox("Resizable");
        resizableBox.setDisable(stageStyle == StageStyle.TRANSPARENT ||stageStyle ==  StageStyle.UNDECORATED);
        fullScreenBox= new CheckBox("Full Screen");
        titleField= new TextField("Stage Coach");
        Label titleLabel= new Label("Title");
        HBox titleBox= new HBox(titleLabel,titleField);
        VBox contentBox= new VBox(
                textStageX,textStageY,textStageW,textStageH,textStageF,
                resizableBox,fullScreenBox,titleBox,
                toBack,toFront,closeButton
        );
        
        contentBox.setLayoutX(30);
        contentBox.setLayoutY(20);
        contentBox.setSpacing(10);
        rootGroup= new Group(blue,contentBox);
        
        Scene scene= new Scene(rootGroup,270,370);
        scene.setFill(Color.TRANSPARENT);
        
        //When the mouse button is pressed, save the initial position of the screen
        rootGroup.setOnMousePressed((MouseEvent me)->{
            dragAnchorX=me.getSceneX()-stageRef.getX();
            dragAnchorY= me.getSceneY()-stageRef.getY();
        });
        
        //When the screen is dragged translate it accordingly
        rootGroup.setOnMouseDragEntered((MouseEvent me)->{
            stageRef.setX(me.getSceneX()-dragAnchorX);
            stageRef.setY(me.getY()- dragAnchorY);
        });
        
        //Displaying the values of the cordinates as they change 
        textStageX.textProperty().bind(new SimpleStringProperty("x: ").concat(stageRef.xProperty().asString()));
        
        textStageY.textProperty().bind(new SimpleStringProperty("y: ").concat(stageRef.yProperty().asString()));
        
        textStageW.textProperty().bind(new SimpleStringProperty("Width: ").concat(stageRef.widthProperty().asString()));
        
        textStageH.textProperty().bind(new SimpleStringProperty("Height: ").concat(stageRef.heightProperty().asString()));
        
        textStageF.textProperty().bind(new SimpleStringProperty("Focused: ").concat(stageRef.focusedProperty().asString()));
        
        stage.setResizable(true);
        resizableBox.selectedProperty().bindBidirectional(stage.resizableProperty());
        fullScreenBox.selectedProperty().addListener((ov,oldValue,newValue)->{
            stageRef.setFullScreen(fullScreenBox.selectedProperty().getValue());
        });
        title.bind(titleField.textProperty());
        
        stage.setScene(scene);
        stage.titleProperty().bind(title);
        stage.initStyle(stageStyle);
        stage.setOnCloseRequest((WindowEvent we)->System.out.println("Window Closinn!!"));
        stage.show();
        Rectangle2D primScreenBounds= Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth()-stage.getWidth())/2);
        stage.setY((primScreenBounds.getHeight()-stage.getHeight())/4);
        

    }
    
}










































































