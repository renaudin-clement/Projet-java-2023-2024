import java.util.ArrayList;
import java.util.List;

public class Sport implements Data<String>{

    public static List<String> lesID = new ArrayList<>();

    private String nomSport;
    private int nbdePointmax = 1;



    // Sport sans points
    public Sport(String nomSport)
            throws IDdejaExistantException {
        if (lesID.contains(nomSport))
            throw new IDdejaExistantException("ce nom est déjà utilisé");
        lesID.add(nomSport);
        this.nomSport = nomSport;

        
        Cache.setDATA(Sport.class, this);
    }

    // Sport avec points
    public Sport(String nomSport, int nbdePointmax) throws IDdejaExistantException {
        if (lesID.contains(nomSport))
            throw new IDdejaExistantException("ce nom est déjà utilisé");
        lesID.add(nomSport);
        this.nomSport = nomSport;
        this.nbdePointmax = nbdePointmax;

        
        Cache.setDATA(Sport.class, this);
    }


    
    @Override
    public String getID() {
        return nomSport;
    }
    @Override
    public void supprID(){
        lesID.remove(nomSport);
    }
    public void clearID(){
        lesID = new ArrayList<>();
    }

    /*
    *retourne le nombre de point max d'un sport
    *@return int nbdePointmax
    */
    public int getpoint() {
        int val = RandomNumberInRange.getRandomInt(1, this.nbdePointmax);
        return val;
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





    @Override
    public String toString() {
        return "le sport " + nomSport;

    }
}
