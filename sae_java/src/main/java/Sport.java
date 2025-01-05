import java.util.ArrayList;
import java.util.List;

public class Sport {

    protected static List<String> lesID = new ArrayList<>();

    private String nomSport;
    private int nbJoueur;
    private int nbdePointmax;



    // Sport sans points
    public Sport(String nomSport, int nbJoueur)
            throws IDdejaExistantException {
        if (lesID.contains(nomSport))
            throw new IDdejaExistantException("ce nom est déjà utilisé");
        lesID.add(nomSport);
        this.nomSport = nomSport;
        this.nbJoueur = nbJoueur;
    }

    // Sport avec points
    public Sport(String nomSport, int nbJoueur, int nbdePointmax) throws IDdejaExistantException {
        if (lesID.contains(nomSport))
            throw new IDdejaExistantException("ce nom est déjà utilisé");
        lesID.add(nomSport);
        this.nomSport = nomSport;
        this.nbJoueur = nbJoueur;
        this.nbdePointmax = nbdePointmax;
    }

    /*
    *retourne le nombre de point max d'un sport
    *@return int nbdePointmax
    */
    public int getpoint() {
        return RandomNumberInRange.getRandomInt(1, this.nbdePointmax);
    }


    /*
    *retourne le nombre de point max d'un sport
    *@return int nbdePointmax
    */
    public int getNbdePointmax() {
        return nbdePointmax;
    }
    
    /*
    *retourne le nom du sport
    *@return String nomSport
    */
    public String getNomSport() {
        return nomSport;
    }

    /*
    *modifie le nom du sport
    *@param String nomSport
    */
    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }

    /*
    *retourne le nombre de joueur pour un sport
    *@return int nbJoueur
    */
    public int getNbJoueur() {
        return nbJoueur;
    }

    /*
    *modifie le nombre de joueur pour un sport
    *@param int nbJoueur
    */
    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }




    @Override
    public String toString() {
        return "le sport " + nomSport;

    }
}
