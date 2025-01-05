import java.util.*;

public class Equipe implements Participation<Athlete> {

    private static List<Integer> lesID = new ArrayList<>();

    private int taille;

    private int nbMedailleOr = 0;
    private int nbMedailleArgent = 0;
    private int nbMedailleBronze = 0;
    private int IDequipe;

    private List<Athlete> lesAthletes;

    private char sexeEquipe;

    


    public Equipe(int id, int taille, char sexeEquipe) throws IDdejaExistantException {
        if (lesID.contains(id))
            throw new IDdejaExistantException("cet id est déjà utilisé");
        lesID.add(id);
        this.taille = taille;
        this.IDequipe = id;
        this.lesAthletes = new ArrayList<>();
        this.sexeEquipe = sexeEquipe;
    }

    /*
    *reccupere l'identifiant d
    */
    public int getID() {
        return this.IDequipe;
    }

    /*
    *RETOURNE le nouveaux dentifiant
    *@return   NewId
    */
    public static int getNewId() {
        int i = 20000;
        while (lesID.contains(i))
            i++;
        System.out.println("nouvel ID : " + i);
        return i;
    }

    public void clear(){
        this.nbMedailleArgent = 0;
        this.nbMedailleBronze = 0;
        this.nbMedailleOr = 0;
    }


     /*
    *RETOURNE UNE LISTE D'ATHELETE
    @return List<Athlete> lesAthletes
    */
    public List<Athlete> getLesAthletes() {
        return lesAthletes;
    }

         /*
    *verifie si l'equipe est de la bonne taille
    @return boolean
    */
    public boolean estALaBonneTaille() {
        if (this.lesAthletes.size() == this.taille)
            return true;
        else {
            return false;
        }
    }

          /*
    *RETOURNE LA TAILLE D'une equipeu
    @return entier this.taille
    */
    public int getTaille() {
        return this.taille;
    }

    /*
    *ajoute un athelete dans une equipe
    *@Param Athlet
    */
    public void participer(Athlete athlete) {
        if(athlete.getSexeA() == this.sexeEquipe) this.lesAthletes.add(athlete);
        else System.err.println("l'equipe "+ getID() +" ne peut pas être ajouter, le sexe ne correspond pas");
    }

    /*
    *retire un athelete dans une equipe
    *@Param Athlet
    */
    public void retirer(Athlete athlete) throws NoSuchElementException { // pensez à try catch
        this.lesAthletes.remove(athlete);
    }

        /*
    *retourn le sex d'une equipe
    *return char this.sexeEquipe
    */
    // @return sexeEquipe
    public char getSexeEquipe() {
        return this.sexeEquipe;
    }

            /*
    *retourne le nombre de medailles en or
    *@return nbMedailleOr
    */
    // @return nbMedailleOr
    public int getNbMedailleOr() {
        return nbMedailleOr;
    }

                    /*
    *ajoute de Medaille en or
    */
    public void ajouteMedailleOr() {
        this.nbMedailleOr += 1;
    }

                /*
    *retourne le nombre de Medaille en Argent
    *@return MedailleArgent
    */
    // @return nbMedailleArgent
    public int getNbMedailleArgent() {
        return nbMedailleArgent;
    }

    
                /*
    *ajoute de Medaille en Argent
    */
    public void ajouteMedailleArgent() {
        this.nbMedailleArgent += 1;
    }

                    /*
    *retourne le nombre de Medaille en Bronze
    *@return nbMedailleBronze
    */
    // @return nbMedailleBronze
    public int getNbMedailleBronze() {
        return nbMedailleBronze;
    }

                    /*
    *ajoute de Medaille en Bronze
    */
    public void ajouteMedailleBronze() {
        this.nbMedailleBronze += 1;
    }

    @Override
    public String toString() {
        return "l'équipe numéro " + this.getID();
                //+ " possède medaille d'or : " + this.getNbMedailleOr()
                //+ " possède medaille d'argent : " + this.getNbMedailleArgent()
                //+ " possède medaille de bronze : " + this.getNbMedailleBronze();
    }

}

