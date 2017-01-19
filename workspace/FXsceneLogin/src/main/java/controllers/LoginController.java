package main.java.controllers;

import java.net.URL;
import java.util.ResourceBundle;

//import application.address.MainApp.java;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.application.Main;;

/**
	 * FXML Controller class
	 * 
	 * @author alidav
	 */
	
	public class LoginController implements Initializable {
		
		@FXML
		private Label lbl;
		@FXML
		private TextField uName;
		@FXML
		private PasswordField password;
		@FXML
		private Button btnLogin;
/*		@FXML
		private void btnLoginAction(ActionEvent action){
			//login check will be performed here!
		}*/
				
		
	    public void setApp(Main application){
	    }


		@Override
		public void initialize(URL fxmlFileLocation, ResourceBundle arg1) {
			//implement initializing values if needed
	/*	    
		    btnLogin.setOnAction(new EventHandler<ActionEvent>(){
		        @Override
		        public void handle(ActionEvent arg0) {
		            System.out.println("Hallooooo");
		        }
		    });*/

		}
	}

