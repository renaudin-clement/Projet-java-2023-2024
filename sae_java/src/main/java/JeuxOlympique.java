import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class JeuxOlympique {

    private static List<Integer> lesID = new ArrayList<>();

    private String lieu;
    private int annee;

    private List<Pays> lesPays;
    private List<Epreuve> lesEpreuve;
    private List<Sport> lesSports;

    public JeuxOlympique(String lieu, int annee) throws IDdejaExistantException {
        if (lesID.contains(annee))
            throw new IDdejaExistantException("Des Jeux Olympiques sont déjà organisés cette année");
        lesID.add(annee);
        this.lieu = lieu;
        this.annee = annee;
        this.lesPays = new ArrayList<>();
        this.lesEpreuve = new ArrayList<>();
        this.lesSports = new ArrayList<>();
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
    *fonction executer toute les épreuve placée dans un jeuxOlympique
    */
    public void simulJO() {
        for (Epreuve epreuve : this.lesEpreuve) {
            epreuve.lanceEpreuve();
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
