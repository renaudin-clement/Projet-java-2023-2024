import java.io.IOException;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class CControleurConsultation implements EventHandler<ActionEvent>{
        private VueJO vue;
    
        private Stage stage;


    public CControleurConsultation( VueJO vue){
        this.vue = vue;
       
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        Button o =(Button) actionEvent.getSource();
        String Textboutton = o.getText();

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        if (Textboutton.equals("Se déconnecter")) {
            Optional<ButtonType> rerponse = this.vue.popUpvous_deco().showAndWait();
            if (rerponse.isPresent() && rerponse.get().equals(ButtonType.YES)) {
                this.vue.modeAccueil();
                this.vue.majAffichage(stage);
            }
            else{System.out.println("OK");}

        }

        if (Textboutton.equals("Jouer les Jeux Olympique")) {
            Optional<ButtonType> reponse = this.vue.popUpvous_lancer().showAndWait();
            if (reponse.isPresent() && reponse.get().equals(ButtonType.CANCEL)){
                System.out.println("ok");
                }
            if (reponse.isPresent() && reponse.get().getText().equals("Lancer une nouvelle partie")){
                this.vue.modeconsultation();
                this.vue.majAffichage(stage);
                }
            if (reponse.isPresent() && reponse.get().getText().equals("Simuler_les_Epreuves")){
                this.vue.modeconsultation();
                this.vue.majAffichage(stage);
                }
        }

        if (Textboutton.equals("Ajouter un sport +")) {
            this.vue.modeajouter();
            //this.vue.choisir_le_bon_tab_dans_ajoute(1);
            this.vue.majAffichage(stage);

        }

        if (Textboutton.equals("Ajouter un epreuve +")) {
            this.vue.modeajouter();
            //this.vue.choisir_le_bon_tab_dans_ajoute(0);
            this.vue.majAffichage(stage);
        }

        if (Textboutton.equals("Ajouter un athlète +")) {
            this.vue.modeajouter();
            //this.vue.choisir_le_bon_tab_dans_ajoute(0);
            this.vue.majAffichage(stage);
        }

        if (Textboutton.equals("Ajouter une équipe +")) {
            this.vue.modeajouter();
            //this.vue.choisir_le_bon_tab_dans_ajoute(0);
            this.vue.majAffichage(stage);
        }

        if (Textboutton.equals("Ajouter un pays +")) {
            this.vue.modeajouter();
            //this.vue.choisir_le_bon_tab_dans_ajoute(0);
            this.vue.majAffichage(stage);
        }

        if (Textboutton.equals("Fichier")) {
            this.vue.modeajouter();
            //this.vue.choisir_le_bon_tab_dans_ajoute(0);
            this.vue.majAffichage(stage);
        }

        if (Textboutton.equals("Aide")) {
            this.vue.modeajouter();
            //this.vue.choisir_le_bon_tab_dans_ajoute(0);
            this.vue.majAffichage(stage);

        }
        
        System.out.println("joji");
    

}
}

