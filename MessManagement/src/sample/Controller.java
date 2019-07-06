package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.text.Text;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Controller {
    @FXML
    private Text source;

    @FXML
    private Text destination;

    @FXML
    private ImageView imageView;

    @FXML
    void handleDrag(DragEvent event) {
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);
        }

    }

    @FXML
    void handleDrop(DragEvent event) throws FileNotFoundException {
        List<File>files=event.getDragboard().getFiles();
        Image image= new Image(new FileInputStream(files.get(0)));
        imageView.setImage(image);
    }


    @FXML
    void handleDragText(MouseEvent event) {
        Dragboard dragboard=source.startDragAndDrop(TransferMode.ANY);
        ClipboardContent clipboardContent= new ClipboardContent();
        clipboardContent.putString(source.getText());
        dragboard.setContent(clipboardContent);
    }

    @FXML
    void handleDropText(DragEvent event) {
        String str=event.getDragboard().getString();
        destination.setText(str);
        event.consume();
    }

    @FXML
    void handleRecieveDrag(DragEvent event) {
        if(event.getDragboard().hasString()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    void handleDragDone(DragEvent event) {
        source.setText("Good Job Drag complete");
    }
}
