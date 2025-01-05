import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class CControleurAcc implements EventHandler<ActionEvent>{

    private VueJO vue;
    
    private Stage stage;


    public CControleurAcc( VueJO vue){
        this.vue = vue;
       
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        Button o =(Button) actionEvent.getSource();
        String Textboutton = o.getText();

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        if (Textboutton.equals("Pas de compte?")) {

            try{ this.vue.modeinscription();
                this.vue.majAffichage(stage);
            }
            catch(IOException e){
                System.out.println("error");
            }
           
        }

        if (Textboutton.equals("Se connecter")) {
            this.vue.modeconsultation();
            this.vue.majAffichage(stage);
            
        }
        
        System.out.println("joji");
    

}
}
