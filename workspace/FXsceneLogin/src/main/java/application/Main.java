package main.java.application;

import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.controllers.LoginController;

public class Main extends Application {
	
	private Stage stage;
	
	/**
	 * Command line arguments
	 * @arg args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	


	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			stage= primaryStage;
			stage.setTitle("Login...");
			stage.setAlwaysOnTop(true);

			gotoLogin();
			stage.show();
		}
		catch(Exception e){
        e.printStackTrace();
		}

	}

	
	private void gotoLogin()  {
		try{
		    LoginController controller = (LoginController) changeScene("/resources/view/Login.fxml");
		    controller.setApp(this);
		}catch(Exception e){
		    e.printStackTrace();
		}
	}



	private Initializable changeScene(String fxml) throws Exception {
	    FXMLLoader loader = new FXMLLoader();
	    InputStream in = Main.class.getResourceAsStream(fxml);
	    loader.setBuilderFactory(new JavaFXBuilderFactory());
	    loader.setLocation(Main.class.getResource(fxml));
	    AnchorPane page;
	    try {
	        page = (AnchorPane) loader.load(in);
	    } finally {
	        in.close();
	    } 
	    Scene scene = new Scene(page, 374, 276);
	    stage.setScene(scene);
	    stage.sizeToScene();
	    return (Initializable) loader.getController();
	   
	}
 	

}
