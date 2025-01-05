import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;

public class VueJO extends Application {
    Scene mainScene;
    BorderPane root;
    FXMLLoader loader;
  
    @Override
    public void init(){    
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        loader = new FXMLLoader(this.getClass().getResource("Acceuil-FX.fxml"));
        root = loader.load();
        mainScene = new Scene(root);
        
        stage.setScene(mainScene);
        stage.setTitle("acceuil");
        stage.setResizable(false);
        stage.show();

        //Button btest = (Button) mainScene.lookup("#monBouton");

        // Appeler ici votre controler !
        //btest.setOnAction(Event -> {btest.setText("Coucou, ça marche !");});}
    }


    public static void main(String[] args) {
        launch(args);

    

}

}