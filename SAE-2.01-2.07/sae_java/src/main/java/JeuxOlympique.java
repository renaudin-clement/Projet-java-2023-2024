import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class JeuxOlympique implements Data {

    private static List<String> lesID = new ArrayList<>();

    private String nomJO;
    private String lieu;
    private int annee;

    private List<Pays> lesPays;
    private List<Epreuve> lesEpreuve;
    private List<Sport> lesSports;

    public JeuxOlympique(String nom, String lieu, int annee) throws IDdejaExistantException {
        if (lesID.contains(nom))
            throw new IDdejaExistantException("Ces Jeux Olympiques Existent déjà");
        lesID.add(nom);
        this.nomJO = nom;
        this.lieu = lieu;
        this.annee = annee;
        this.lesPays = new ArrayList<>();
        this.lesEpreuve = new ArrayList<>();
        this.lesSports = new ArrayList<>();
        
        Cache.setDATA(JeuxOlympique.class, this);
    }


    
    @Override
    public String getID() {
        return nomJO;
    }

    @Override
    public void supprID() {
        lesID.remove(nomJO);
    }

    /*
    *retourne le Lieu des jo
    *@return String lieu
    */
    public String getLieu() {
        return lieu;
    }
    
    /*
    *modifie le Lieu des jo
    *@param String lieu
    */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    /*
    *modifie le nom des jo
    *@param String nom
    */
    public void setNom(String nom) {
        lesID.remove(this.nomJO);
        lesID.add(nom);
        this.nomJO = nom;
    }

    /*
    *retourne le nom des jo
    *@return String nom
    */
    public String getNom() {
        return nomJO;
    }

    

    /*
    *retourne l'annee des jo
    *@return int annee
    */
    public int getAnnee() {
        return annee;
    }

    /*
    *modifie l'annee des jo
    *@param int annee
    */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /*
    *ajoute un sport pour les jo
    *@param  Sport sport
    */
    public void ajouteSport(Sport sport) {
        this.lesSports.add(sport);

    }

    /*
    *ajoute une epreuve pour les jo
    *@param  Epreuve epreuve
    */
    public void ajouteEpreuve(Epreuve epreuve) {
        this.lesEpreuve.add(epreuve);

    }

    /*
    *retire un sport pour les jo
    *@param  Sport sport
    */
    public void retireSport(Sport sport) {
        this.lesSports.remove(sport);

    }

    /*
    *retire une epreuve pour les jo
    *@param  Epreuve epreuve
    */
    public void retireEpreuve(Epreuve epreuve) {
        this.lesEpreuve.remove(epreuve);

    }

    /*
    *ajoute un Pays pour les jo
    *@param  Pays pays
    */
    public void ajoutePays(Pays pays) {
        this.lesPays.add(pays);

    }

    /*
    *retire un Pays pour les jo
    *@param  Pays pays
    */
    public void retirePays(Pays pays) {
        this.lesPays.add(pays);

    }

    
    /*
    *fonction simuler toute les épreuve placée dans un jeuxOlympique
    */
    public void simulJO() {
        for (Epreuve epreuve : this.lesEpreuve) {
            epreuve.lanceEpreuve2(false);
        }
    }

        /*
    *fonction executer toute les épreuve placée dans un jeuxOlympique
    */
    public void execJO() {
        for (Epreuve epreuve : this.lesEpreuve) {
            epreuve.lanceEpreuve2(true);
        }
    }

    /*
    *elle classe les pays via un comparateur en fonction des medailles
    *@return List<Pays> classement d'une liste des pays
    */
    public List<Pays> classement(Comparator<Pays> compare) {
        Collections.sort(this.lesPays, compare);
        return this.lesPays;
    }

    @Override
    public String toString() {
        return "les JO de " + this.lieu + " de " + this.annee;
    }

}
