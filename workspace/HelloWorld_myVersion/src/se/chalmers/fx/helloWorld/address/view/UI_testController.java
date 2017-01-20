package se.chalmers.fx.helloWorld.address.view;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import se.chalmers.fx.helloWorld.address.Main;

public class UI_testController {
	
	private Main main;
	@FXML
	private TextField textField;
	
	@FXML
	private Button btn;
	
	@FXML
	private Button btnNew;
	
	@FXML
	private void handleBtn(){
		textField.setText("Hellooooooooooooooooooo!");
	}
    /**
     * Shows the person overview inside the root layout.
     */
	@FXML
    private void handlebtnNew() {
    	try{
    		main.showDialog();
		}catch(Exception e){
		    e.printStackTrace();
		}
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
