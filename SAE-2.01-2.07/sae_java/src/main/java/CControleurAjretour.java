
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class CControleurAjretour implements EventHandler<ActionEvent>{

    private VueJO vue;
    
    private Stage stage;
    private Requetes req;

    public CControleurAjretour( VueJO vue, Requetes req){ //Requetes req){
        this.vue = vue;
        this.req = req;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Button o =(Button) actionEvent.getSource();
        String Textboutton = o.getText();
        Athlete athlete;
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        if (Textboutton.equals("Créer l'athlète")) {
            try {
                String nom = this.vue.getTextFieldNomA();
                String prenom = this.vue.getTextFieldPrenomA();
                char sexe = this.vue.getradiobouttonFA();
                int agilite = this.vue.getTextFieldAGilA();
                int endurance = this.vue.getTextFieldEndA();
                int force = this.vue.getTextFieldforcA();

                athlete = new Athlete(nom, prenom, sexe, agilite, endurance, force);
                try {
                    this.req.ajouterAthlete(athlete);
                    System.out.println("Athlete ajouter avec succes");
                    
                } catch (SQLException e) {
                    System.err.println("erreur :" + e);
                }
    
            } catch (Exception e) { 
                System.err.println("echec de l'ajout"+ e);
                this.vue.popUpAlert().showAndWait();
            }
        }

        else if (Textboutton.equals("Créer le Sport")){

            try {
            String nom = this.vue.gettextfieldSport();
            Sport sport = new Sport(nom);
            System.out.println(sport);

            } catch (Exception e) {
                System.err.println("nop");
                this.vue.popUpAlert().showAndWait();
            }
        }

        else if (Textboutton.equals("Créer l'Equipe")){
            System.out.println("aoui");

            try {
            int max = this.vue.gettextFieldnbjoueurmax();
            char sexe = this.vue.getradiobouttonHE();
            Equipe equipe = new Equipe(max, sexe);

            System.out.println(equipe);

            try {
                this.req.ajouterEquipe(equipe);
                System.out.println("Equipe ajouter avec succes");
                
            } catch (SQLException e) {
                System.err.println("erreur :" + e);
            }

        } catch (Exception e) { 
            System.err.println("echec de l'ajout"+ e);
            this.vue.popUpAlert().showAndWait();
        }
        }

        else if (Textboutton.equals("Créer l'Epreuve")){
            System.out.println("aoui");
        }

        else if (Textboutton.equals("Créer le Pays")){
            System.out.println("aoui");
            
        }
     
        else if (Textboutton.equals("retour")) {
            this.vue.modeconsultation();
            this.vue.majAffichage(stage);

        }
        

    }
}


