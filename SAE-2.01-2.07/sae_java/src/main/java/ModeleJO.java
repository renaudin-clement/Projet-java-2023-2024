import java.sql.SQLException;

public class ModeleJO {
    private User utilisateur;
    private Requetes request;



    ////////////////////////////////////////
    // GESTION DE L'UTILISATEUR

    public ModeleJO(Requetes req){
        this.request = req;
    }

    public void createUser(String ID, String MDP, String cle, char role) throws IdentifiantNonValideException, MDPNonValideException, CLENonValideException{
        String resTxtFieldID = ID;
        String resTxtFieldMDP = MDP;
        String cleActivation = cle;
        char roleChoisit = role;


        // resTxtFieldID = "lol@gmail.com";
        // resTxtFieldMDP = "QuoicouFeur69";
        // cleActivation = "123";
        // roleChoisit = 'V';

        if(!User.mailConforme(resTxtFieldID)) throw new IdentifiantNonValideException("l'adresse mail n'est pas conforme");
        if(resTxtFieldMDP.length()<6) throw new MDPNonValideException("Le mot de passe doit faire au minimum 6 caractères");

        if(!cleActivation.equals("") && cleActivation!=null && roleChoisit!='v'){
            if(!request.cleExiste(roleChoisit, cleActivation)){
                throw new CLENonValideException("Cette clé d'activation n'existe pas, si vous pensez que c'est une erreur merci de nous conctacter");
            }
        }
        utilisateur = new User(resTxtFieldID, resTxtFieldMDP, roleChoisit);
        request.newUser(utilisateur);
    }

    public void connexionUser(String ID, String MDP) throws IdentifiantNonValideException, MDPNonValideException, SQLException{
        String resTxtFieldID = ID;
        String resTxtFieldMDP = MDP;

        // resTxtFieldID = "lol@gmail.com";
        // resTxtFieldMDP = "QuoicouFeur69";

        User co = new User(resTxtFieldID, resTxtFieldMDP, 'V');

        if(!request.UtilisateurExist(co)) throw new IdentifiantNonValideException("Cette adresses mail n'existe pas !");
        if(request.LoginCorrect(co)) throw new MDPNonValideException("Votre mot de passe est incorrect !");

        this.utilisateur = new User(resTxtFieldID, resTxtFieldMDP, co.getRole());
    }

    public void deconnecter(){
        utilisateur = null;
    }

    public void modifierMDP(String newMDP) throws MDPNonValideException{
        if(newMDP.length()<6) throw new MDPNonValideException("Le mot de passe doit faire au minimum 6 caractères");
        User editedUser = utilisateur;
        editedUser.setMdp(newMDP);
        request.editUser(utilisateur, editedUser);
        utilisateur = editedUser;
    }

    /////////////////



}
