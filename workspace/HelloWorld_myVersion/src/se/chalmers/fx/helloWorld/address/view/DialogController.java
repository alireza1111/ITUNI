package se.chalmers.fx.helloWorld.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import se.chalmers.fx.helloWorld.address.Main;

public class DialogController {
	
	
	@FXML
	private Label messageLabel;
	@FXML
	private Label detailsLabel;
	@FXML
	private Button actionParent;
	@FXML
	private Button actionButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button okButton;
	@FXML
	private HBox okParent;
	private Stage dialogStage;
	
	

	
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
    public void setApp(Main application){
    }

}
