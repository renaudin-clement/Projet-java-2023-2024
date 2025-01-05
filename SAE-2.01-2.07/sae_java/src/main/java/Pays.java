
import java.util.ArrayList;
import java.util.List;

public class Pays implements Participation<Equipe>, Data<String> {

    public static List<String> lesID = new ArrayList<>();

    private String Nompays;
    private List<Equipe> lesEquipes;

    public Pays(String nomPays) throws IDdejaExistantException {
        if (lesID.contains(nomPays))
            throw new IDdejaExistantException("ce nom est déjà utilisé");
        lesID.add(nomPays);
        this.Nompays = nomPays;
        this.lesEquipes = new ArrayList<>();

        Cache.setDATA(Pays.class, this);
    }



    @Override
    public String getID() {
        return Nompays;
    }
    @Override
    public void supprID(){
        lesID.remove(Nompays);
    }
    public void clearID(){
        lesID = new ArrayList<>();
    }

    /*
    *affiche Les Equipes d'un pays
    *@return List<Equipe> lesEquipes
    */
    public List<Equipe> afficheLesEquipes() {
        return this.lesEquipes;
    }

    /*
    *ajoute une Equipes dans les Equipes d'un pays
    *@param Equipe equip 
    */
    @Override
    public void participer(Equipe equip) {
        lesEquipes.add(equip);
    }

    /*
    *retire une Equipes dans les Equipes d'un pays
    *@param Equipe equip 
    */
    @Override
    public void retirer(Equipe equip) {
        lesEquipes.remove(equip);
    }

    /*
    *retourne le nom d'un pays
    *@return String Nompays
    */
    public String getNompays() {
        return Nompays;
    }

    /*
    *modifie le nom d'un pays
    *@param String Nompays
    */
    public void setNompays(String nompays) {
        Nompays = nompays;
    }

    /*
    *retourne les medailles d'or d'un pays
    *@return int nbmedaille_or
    */
    public int getmedailles_or() {
        int nbmedaille_or = 0;
        for (Equipe groupes : this.lesEquipes) {
            nbmedaille_or += groupes.getNbMedailleOr();
        }
        return nbmedaille_or;
    }

    
    /*
    *retourne les medailles d'argent d'un pays
    *@return int nbmedaille_argent
    */
    public int getmedailles_argent() {
        int nbmedaille_Argent = 0;
        for (Equipe groupes : this.lesEquipes) {
            nbmedaille_Argent += groupes.getNbMedailleArgent();
        }
        return nbmedaille_Argent;
    }

    /*
    *retourne les medailles de bronze d'un pays
    *@return int nbmedaille_bronze
    */
    public int getmedailles_bronze() {
        int nbmedaille_bronze = 0;
        for (Equipe groupes : this.lesEquipes) {
            nbmedaille_bronze += groupes.getNbMedailleBronze();
        }
        return nbmedaille_bronze;
    }

    
    /*
    *retourne la totaliter medailles d'un pays
    *@return int nbmedaille
    */
    public int getmedailles_total() {
        int nbmedaille = 0;
        for (Equipe groupes : this.lesEquipes) {
            nbmedaille += groupes.getNbMedailleBronze();
            nbmedaille += groupes.getNbMedailleArgent();
            nbmedaille += groupes.getNbMedailleOr();
        }
        return nbmedaille;
    }

    public String toString() {
        return this.Nompays;
        // + " possede "
        // + String.valueOf(this.getmedailles_bronze()) +" de medailles bronze , "
        // + String.valueOf(this.getmedailles_argent()) + " de medailles argent et "
        // + String.valueOf(this.getmedailles_or()) + " de medailles d'Or" ;
    }

}
