package se.chalmers.fx.helloWorld.address.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import se.chalmers.fx.helloWorld.address.Main;

public class DialogController {
	
	   @FXML
	    private Label messageLabel;

	    @FXML
	    private Label detailsLabel;

	    @FXML
	    private HBox actionParent;

	    @FXML
	    private Button actionButton;

	    @FXML
	    private Button cancelButton;

	    @FXML
	    private HBox okParent;

	    @FXML
	    private Button CloseAppbtn;
	    

	    /**
	     * to close the application the following method should be used!
	     * @param event
	     */
	    @FXML
	    void CloseApp(ActionEvent event) {
	    	Platform.exit();

	    }

	    @FXML
	    void Dialogcancel(ActionEvent event) {
	    	((Node)(event.getSource())).getScene().getWindow().hide();

	    }

	
	

	
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */

    public void setApp(Main application){
    }

}
