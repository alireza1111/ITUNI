package tst;

import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

private Stage stage;

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage primaryStage) throws Exception {
    try{
        stage = primaryStage;
        stage.setTitle("Test");
        setScene();
        stage.show();
    }catch(Exception e){
        e.printStackTrace();
    }

}

private void setScene(){
    try{
        Cont controller = (Cont) changeScene("/tst/Window.fxml");
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
    Scene scene = new Scene(page, 800, 600);
    stage.setScene(scene);
    stage.sizeToScene();
    return (Initializable) loader.getController();
   }

}
