package se.chalmers.fx.helloWorld.address;
	
import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import se.chalmers.fx.helloWorld.address.view.DialogController;
import se.chalmers.fx.helloWorld.address.view.UI_testController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	private Stage stage;
	private Main main;

	@Override
	public void start(Stage primaryStage) {
		try {
			stage=primaryStage;
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("/se/chalmers/fx/helloWorld/address/view/UI_test.fxml").toExternalForm());
			stage.setScene(scene);
			showUI();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
    
	/**
     * Shows UI_test layout into main.
     */
    public void showUI() {
    	try{
		    UI_testController controller = (UI_testController) 
		    		changeScene("/se/chalmers/fx/helloWorld/address/view/UI_test.fxml");
		    controller.setApp(main);	//for future use
		}catch(Exception e){
		    e.printStackTrace();
		}
    }
    public void showDialog() throws Exception{
        //Parent root;
        try {
        	DialogController dialCont= (DialogController)
        			changeScene("/se/chalmers/fx/helloWorld/address/view/Dialog.fxml");
            Stage stage = new Stage();
            stage.setTitle("Dialooooog!");

            // Hide this current window (if this is what you want)
           // ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * changeScene method always work perfect to connect fxml file to project!
     * @param fxml
     * @return
     * @throws Exception
     */
	public Initializable changeScene(String fxml) throws Exception {
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
