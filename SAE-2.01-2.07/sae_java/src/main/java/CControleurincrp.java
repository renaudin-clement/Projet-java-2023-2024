
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class CControleurincrp implements EventHandler<ActionEvent>{

    private VueJO vue;
    
    private Stage stage;

    private Requetes req;


    public CControleurincrp( VueJO vue, Requetes req){
        this.vue = vue;
        this.req = req;
       
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        Button o =(Button) actionEvent.getSource();
        String Textboutton = o.getText();
        User user;

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        if (Textboutton.equals("retour")) {

            this.vue.modeAccueil();
            this.vue.majAffichage(stage);
        }
             
        if (Textboutton.equals("Créer un nouveau compte")) {
            try {
                String ident = this.vue.getcreer_mail();
                String mdp = this.vue.getcreer_motdpass();
                char role;
                if (this.vue.getradioboutton_visit())
                    role = 'V';
                else if (this.vue.radioboutton_organisateur())
                    role = 'O';
                else
                    role = 'A';

                user = new User(ident, mdp, role);
               // if (!(this.req.UtilisateurExist(user))){
                    try {
                        this.req.ajouterUser(user);
                        
                        System.out.println("le User a bien été ajouter");

                    }catch (SQLException e) {
                        System.err.println("erreur ici:" + e);
                    }
              //  } else {System.out.println("utilisateur déjà existant");}
                
            } catch (Exception e) {
                System.err.println("echec de l'ajout"+ e);
                this.vue.popUpAlert().showAndWait();
            }

           


            this.vue.poppcompte_enregistrer().showAndWait();
            this.vue.modeAccueil();
            this.vue.majAffichage(stage);
        }


    }
}


