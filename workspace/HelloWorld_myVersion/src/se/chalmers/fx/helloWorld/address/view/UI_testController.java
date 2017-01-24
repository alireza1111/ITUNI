package se.chalmers.fx.helloWorld.address.view;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import se.chalmers.fx.helloWorld.address.Main;

public class UI_testController {
	

    @FXML
    private TextField textField;

    @FXML
    void handleBtn(ActionEvent event) {
    	textField.setText(textField.getText()+"Helloooo! ");
    }

    @FXML
    void handlebtnNew(ActionEvent event) throws IOException {

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/se/chalmers/fx/helloWorld/address/view/Dialog.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1)); 
    	stage.show();
        // Hide this current window (if this is what you want)
       // ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    

    public void setApp(Main application){
    }
	/**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Main main) {
    }

}
