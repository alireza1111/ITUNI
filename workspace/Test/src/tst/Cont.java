package tst;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class Cont implements Initializable {

@FXML
private Button btn;
@FXML
public TextArea Console;

public void setApp(Main application){
}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
    assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'Window.fxml'.";
    assert Console != null : "fx:id=\"Console\" was not injected: check your FXML file 'Window.fxml'.";

    btn.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent arg0) {
            setText("hello world");
        }
    });

}

public void setText(String text){
    Console.appendText(text+"\n");
 }

}
