import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class VueJO extends Application {

    Requetes req ;

    Scene mainScene;
    Scene tabscene;
    BorderPane root;
    BorderPane fenetreAccueil;
    BorderPane fenetreinscription;
    TabPane fenetre_ajoute;
    //TabPane fenetre_ajoutev2;
    BorderPane Consultation;
    FXMLLoader loader;

    //*connexion */
    TextField creer_mail = new TextField();
    TextField creer_motdpass = new TextField();
    RadioButton radioboutton_visit = new RadioButton();
    RadioButton radioboutton_organisateur = new RadioButton();
    RadioButton radioboutton_admin = new RadioButton();



    //*athlète */
    TextField textFieldNomA = new TextField();
    TextField textFieldprenomA = new TextField();
    TextField textFieldAGilA = new TextField();
    TextField textFieldEndA  = new TextField();
    TextField textFieldforcA = new TextField();
    RadioButton radiobouttonHA = new RadioButton();
    RadioButton radiobouttonFA = new RadioButton();

    //*sport */
    TextField textfieldSport = new TextField();

    //*equipe */
    RadioButton radiobouttonHE = new RadioButton();
    TextField textFieldnbjoueurmax = new TextField();

    //*epreuve */
    TextField textFieldNomEP = new TextField();
    RadioButton radiobouttonHEP = new RadioButton();
    TextField textFieldCaractEP = new TextField();
    RadioButton radiobouttonFPaff = new RadioButton();
    TextField textFieldDemandeAGIL = new TextField();
    TextField textFieldDemandeEND = new TextField();
    TextField textFieldDemandeFORC = new TextField();

    //*pays */
    TextField textFieldNomP = new TextField();


    //Requetes req = new Requetes();
    //private ModelJO jo;
  
    @Override
    public void init(){ 
        
    }
    
    @Override
    public void start(Stage stage) throws IOException {
        try {
            this.req = new Requetes( new ConnexionMySql());
            req.ajouteAdmin();
            
        } catch (Exception e) {
            System.err.println("echec connexion");
        }
        loader = new FXMLLoader(this.getClass().getResource("Acceuil-FX.fxml"));
        fenetreAccueil = loader.load();
        this.mainScene = new Scene(fenetreAccueil);
        
        CControleurAcc ctrac = new CControleurAcc(this);

        try{
        Button identconnexe = (Button) this.mainScene.lookup("#connecter");
        Button motconnexe = (Button) this.mainScene.lookup("#pascompte");

        identconnexe.setOnAction(ctrac);
        motconnexe.setOnAction(ctrac);
        }
        catch (NullPointerException e) {
            // TODO: handle exception
            System.out.println("problem");
        }



        stage.setScene(this.mainScene);
        stage.setTitle("Consultation");
        stage.setResizable(true);
        stage.show();

        //Button btest = (Button) mainScene.lookup("#monBouton");

        // Appeler ici votre controler !
        //btest.setOnAction(Event -> {btest.setText("Coucou, ça marche !");});}
    }


    private Scene fenetreAccueil() throws IOException{

        loader = new FXMLLoader(this.getClass().getResource("Acceuil-FX.fxml"));
        fenetreAccueil = loader.load();
        this.mainScene = new Scene(fenetreAccueil);
        
        CControleurAcc ctrac = new CControleurAcc(this);

        try{

        TextField identifiant = (TextField) this.mainScene.lookup("#identconnexe");
        TextField mot_de_passe = (TextField) this.mainScene.lookup("#motconnexe");

        Button identconnexe = (Button) this.mainScene.lookup("#connecter");
        Button motconnexe = (Button) this.mainScene.lookup("#pascompte");

        identconnexe.setOnAction(ctrac);
        motconnexe.setOnAction(ctrac);
        }
        catch (NullPointerException e) {
            // TODO: handle exception
            System.out.println("problem");
        }

        return this.mainScene;
    }

     private Scene fenetreinscription() throws IOException {
        loader = new FXMLLoader(this.getClass().getResource("Inscription-FX.fxml"));
        fenetreinscription = loader.load();
        this.mainScene = new Scene(fenetreinscription);

        CControleurincrp ctrinc = new CControleurincrp(this, this. req);

        try{

        this.creer_mail = (TextField) this.mainScene.lookup("#creeremail");
        this.creer_motdpass = (TextField) this.mainScene.lookup("#creermdp");




        Button bouttonretour = (Button) this.mainScene.lookup("#Bretour");
        Button boutton_nouveau_compte = (Button) this.mainScene.lookup("#nouveau_compte");

        bouttonretour.setOnAction(ctrinc);
        boutton_nouveau_compte.setOnAction(ctrinc);

        //creer les toggle boutton et relier les radio boutton
        this.radioboutton_visit = (RadioButton) this.mainScene.lookup("#selectvisit");
        this.radioboutton_organisateur = (RadioButton) this.mainScene.lookup("#selectorg");
        this.radioboutton_admin = (RadioButton) this.mainScene.lookup("#selectadm");


        
        }
        catch (NullPointerException e) {
            // TODO: handle exception
            System.out.println("problem");
        }

        return this.mainScene;
     }


    private Scene fenetre_ajoute()  throws IOException {
        loader = new FXMLLoader(this.getClass().getResource("Ajouter-FX.fxml"));
        this.fenetre_ajoute = loader.load();
        //this.fenetre_ajoutev2 =loader.load();
        this.mainScene = new Scene(fenetre_ajoute);
        

        CControleurAjretour ctraj = new CControleurAjretour(this,this.req);

        try{

            // bouton retour
            Button bouttonretour1 = (Button) this.mainScene.lookup("#retour");
            Button bouttonretour2 = (Button) this.mainScene.lookup("#retour1");
            Button bouttonretour3 = (Button) this.mainScene.lookup("#retour2");
            Button bouttonretour4 = (Button) this.mainScene.lookup("#retour3");
            Button bouttonretour5 = (Button) this.mainScene.lookup("#retour4");

            bouttonretour1.setOnAction(ctraj);
            bouttonretour2.setOnAction(ctraj);
            bouttonretour3.setOnAction(ctraj);
            bouttonretour4.setOnAction(ctraj);
            bouttonretour5.setOnAction(ctraj);
            //______________________________________________________
            //! partie ajouter athlete
            this.textFieldNomA = (TextField) this.mainScene.lookup("#textFieldNomA");

            this.textFieldprenomA = (TextField) this.mainScene.lookup("#textFieldprenomA");

            this.textFieldAGilA = (TextField) this.mainScene.lookup("#textFieldAGilA");
            this.textFieldEndA = (TextField) this.mainScene.lookup("#textFieldEndA"); //textfield
            this.textFieldforcA = (TextField) this.mainScene.lookup("#textFieldforcA");

            Slider slideragA = (Slider) this.mainScene.lookup("#slideragA");
            Slider sliderendA = (Slider) this.mainScene.lookup("#sliderendA"); //slider
            Slider sliderForA = (Slider) this.mainScene.lookup("#sliderForA");

            Button bCreerA = (Button) this.mainScene.lookup("#bCreerA");

            bCreerA.setOnAction(ctraj);

            //creer les toggle boutton et relier les radio boutton
            ToggleGroup f = new ToggleGroup();
            this.radiobouttonHA = (RadioButton) this.mainScene.lookup("#radiobouttonHA");
            this.radiobouttonFA = (RadioButton) this.mainScene.lookup("#radiobouttonFA");
            radiobouttonHA.setToggleGroup(f);
            radiobouttonFA.setToggleGroup(f);

            //__________________________________________________________________________________
            //! partie ajouter sport
            this.textfieldSport = (TextField) this.mainScene.lookup("#textfieldSport");
            Button BCreerSP = (Button) this.mainScene.lookup("#BCreerSP");

            BCreerSP.setOnAction(ctraj);


            //______________________________________________________
            //! partie ajouter equipe

            this.textFieldnbjoueurmax = (TextField) this.mainScene.lookup("#textFieldnbjoueurmax");
            Button BcreerEQ = (Button) this.mainScene.lookup("#BcreerEQ");

            BcreerEQ.setOnAction(ctraj);
            
            Button BajouAdansEQ = (Button) this.mainScene.lookup("#BajouAdansEQ");
            
        

            //creer les toggle boutton et relier les radio boutton
            ToggleGroup e = new ToggleGroup();
            this.radiobouttonHE = (RadioButton) this.mainScene.lookup("#radiobouttonHE");
            RadioButton radiobouttonFE = (RadioButton) this.mainScene.lookup("#radiobouttonFE");
            radiobouttonHE.setToggleGroup(e);
            radiobouttonFE.setToggleGroup(e);

            //______________________________________________________
            //! partie ajouter Epreuve 
            this.textFieldNomEP = (TextField) this.mainScene.lookup("#textFieldNomEP");

            ChoiceBox choix_Sport_Ass = (ChoiceBox) this.mainScene.lookup("#choix_Sport_Ass");

            //creer les toggle boutton et relier les radio boutton p1
            ToggleGroup d = new ToggleGroup();
            this.radiobouttonHEP = (RadioButton) this.mainScene.lookup("#radiobouttonHEP");
            RadioButton radiobouttonFEP = (RadioButton) this.mainScene.lookup("#radiobouttonFEP");
            radiobouttonHEP.setToggleGroup(d);
            radiobouttonFEP.setToggleGroup(d);

            this.textFieldCaractEP = (TextField) this.mainScene.lookup("#textFieldCaractEP");

             //creer les toggle boutton et relier les radio boutton p2
             ToggleGroup c = new ToggleGroup();
             this.radiobouttonFPaff = (RadioButton) this.mainScene.lookup("#radiobouttonFPaff");
             RadioButton radiobouttonFPMscore = (RadioButton) this.mainScene.lookup("#radiobouttonFPMscore");
             radiobouttonFPaff.setToggleGroup(c);
             radiobouttonFPMscore.setToggleGroup(c);


             //demande agil endu force textfield
             this.textFieldDemandeAGIL = (TextField) this.mainScene.lookup("#textFieldDemandeAGIL");
             this.textFieldDemandeEND = (TextField) this.mainScene.lookup("#textFieldDemandeEND");
             this.textFieldDemandeFORC = (TextField) this.mainScene.lookup("#textFieldDemandeFORC");

            // ! à faire
            //creer les toggle boutton et relier les radio boutton p3
            ToggleGroup g = new ToggleGroup();
            RadioButton radiobouttonRPnon = (RadioButton) this.mainScene.lookup("#radiobouttonRPnon");
            RadioButton radiobouttonRPVscoreatt = (RadioButton) this.mainScene.lookup("#radiobouttonRPVscoreatt");
            RadioButton radiobouttonRPVecartscore = (RadioButton) this.mainScene.lookup("#radiobouttonRPVecartscore");
            radiobouttonRPnon.setToggleGroup(g);
            radiobouttonRPVscoreatt.setToggleGroup(g);
            radiobouttonRPVecartscore.setToggleGroup(g);

            Button BcreerEP = (Button) this.mainScene.lookup("#BcreerEP");
            BcreerEP.setOnAction(ctraj);

             //______________________________________________________
            //! partie ajouter Pays
            this.textFieldNomP = (TextField) this.mainScene.lookup("#textFieldNomP");


            Button BchoisirHymne = (Button) this.mainScene.lookup("#BchoisirHymne");
            Button Bplay = (Button) this.mainScene.lookup("#Bplay");
            Button Bchoisirdrap = (Button) this.mainScene.lookup("#Bchoisirdrap");

            ImageView imageDrapeauP = (ImageView) this.mainScene.lookup("#imageDrapeauP");

            Button BCreerP = (Button) this.mainScene.lookup("#BCreerP");
            BCreerP.setOnAction(ctraj);


            }
            catch (NullPointerException e) {
                // TODO: handle exception
                System.out.println("problem");
            }


        

        return this.mainScene;

    }
    //*__________________________________________________________
    //*Connexion */
    public String getcreer_mail(){return this.creer_mail.getText();}
    public String getcreer_motdpass(){return this.creer_motdpass.getText();}

    public boolean getradioboutton_visit() {return radioboutton_visit.isSelected();}
    public boolean radioboutton_organisateur() {return radioboutton_organisateur.isSelected();}
    public boolean radioboutton_admin() {return radioboutton_admin.isSelected();}

    //*__________________________________________________________
    //*Athlete */



    public String getTextFieldNomA(){return this.textFieldNomA.getText();}
    public String getTextFieldPrenomA(){return textFieldprenomA.getText();}
    public int getTextFieldAGilA() {return Integer.parseInt(textFieldAGilA.getText());}
    public int getTextFieldEndA() {return Integer.parseInt(textFieldEndA.getText());}
    public int getTextFieldforcA() {return Integer.parseInt(textFieldforcA.getText());}

    public char getradiobouttonFA() {
        if (radiobouttonFA.isSelected())
            return 'F';
        return 'H';
    }

    public String gettextFieldSport() {
        return textfieldSport.getText();
    }

    //*__________________________________________________________
    //*sport */
    public String gettextfieldSport() {
        return textfieldSport.getText();
    }

    //*__________________________________________________________
    //*equipe */
    public int gettextFieldnbjoueurmax() {return Integer.parseInt(textFieldnbjoueurmax.getText());}

    public char getradiobouttonHE() {
        if (radiobouttonHE.isSelected())
            return 'H';
        return 'F';
    }


    //*__________________________________________________________
    //*epreuve */
    public String gettextFieldNomEP() {return textFieldNomEP.getText();}
    public String gettextFieldCaractEP() {return textFieldCaractEP.getText();}
    public int gettextFieldDemandeAGIL() {return Integer.parseInt(textFieldDemandeAGIL.getText());}
    public int gettextFieldDemandeEND() {return Integer.parseInt(textFieldDemandeEND.getText());}
    public int gettextFieldDemandeFORC() {return Integer.parseInt(textFieldDemandeFORC.getText());}

    public char getradiobouttonHEP() {
        if (radiobouttonHEP.isSelected())
            return 'H';
        return 'F';
    }

    public String getradiobouttonFPaff() {
        if (radiobouttonFPaff.isSelected())
            return "Duel";
        return "Score";
    }

    //*__________________________________________________________
    //*pays */
    public String gettextFieldNomP() {return textFieldNomP.getText();}

     /* 
     public Scene choisir_le_bon_tab_dans_ajoute(int number){

        this.fenetre_ajoutev2.getSelectionModel().select(number);
        this.mainScene = new Scene(fenetre_ajoutev2);
        return this.mainScene;
     }
*/
/* 
    private Scene fenetre_idk() throws IOException {
        loader = new FXMLLoader(this.getClass().getResource("idk.fxml"));
        fenetre_creer_Pays = loader.load();
        this.mainScene = new Scene(fenetre_creer_Pays);

        return this.mainScene;
    }*/


    private Scene fenetre_consultation() throws IOException {
        loader = new FXMLLoader(this.getClass().getResource("Consultation-FX.fxml"));
        Consultation = loader.load();
        this.mainScene = new Scene(Consultation);
        
        CControleurConsultation ctrinc = new CControleurConsultation(this);

        try{
            Button bouttondeco = (Button) this.mainScene.lookup("#SEDECO");
            Button ajoutersport = (Button) this.mainScene.lookup("#ajSport");
            Button ajouterepreuve = (Button) this.mainScene.lookup("#ajEpreue");
            Button ajouterATHE = (Button) this.mainScene.lookup("#ajAthletes");
            Button ajouterEquipe = (Button) this.mainScene.lookup("#ajEquipe");
            Button ajouterpays = (Button) this.mainScene.lookup("#ajPays");

            Button blancerpartie = (Button) this.mainScene.lookup("#lancerJO");
    

            blancerpartie.setOnAction(ctrinc);
            bouttondeco.setOnAction(ctrinc);
            ajoutersport.setOnAction(ctrinc);
            ajouterepreuve.setOnAction(ctrinc);
            ajouterATHE.setOnAction(ctrinc);
            ajouterEquipe.setOnAction(ctrinc);
            ajouterpays.setOnAction(ctrinc);



            
            }
            catch (NullPointerException e) {
                // TODO: handle exception
                System.out.println("problem");
            }

        return this.mainScene;
     }

     public Requetes getReq() {
        return req;
    }








    public void modeAccueil()  {
        try{
            this.fenetreAccueil();
        }
        
        catch(IOException e){
            System.out.println("error");
        }
    }

    public void modeajouter()  {
        try{
            this.fenetre_ajoute();
        }
        
        catch(IOException e){
            System.out.println("error");
        }
    }

    public void modeconsultation()  {
        try{
            this.fenetre_consultation();
        }
        
        catch(IOException e){
            System.out.println("error");
        }
    }
   
    
    public void modeinscription() throws IOException {

        // A implementer
        try{
        this.fenetreinscription();
        }
            
        catch(IOException e){
            System.out.println("error");
        }
    }
    



    public void majAffichage(Stage stage){
        // A implementer
               System.out.println("MARCG");
               stage.setScene(this.mainScene);
               stage.setTitle("Consultation");
               stage.show();

    }


    public Alert popUpvous_deco(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"vous aller vous deconecter\n Etes-vous sûr vous deconecter ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }
       
    public Alert poppcompte_enregistrer(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("compte enregistrer");
        alert.setHeaderText("compte valider");
        alert.setContentText("votre compte est bien enregistrer");
        return alert;
    }

    public Alert popUpvous_lancer(){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"vous aller vous deconecter\n Etes-vous sûr vous deconecter ?",ButtonType.CANCEL,SIM,LANC);
        alert.setTitle("Attention");
        return alert;
    }

    private ButtonType SIM = new ButtonType("Simuler_les_Epreuves");
    private ButtonType LANC = new ButtonType("Lancer_les_Epreuves");

    public Alert popUpAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR,"Vous ne pouvez pas crée ceci\n assurer vous bien de remplir tout les champs", ButtonType.OK);
        alert.setTitle("Attention");
        return alert;
    }

}