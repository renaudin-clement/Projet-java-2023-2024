
import java.util.List;
import java.util.ArrayList;

public class Athlete implements Data<Integer> {

    private static List<Integer> lesID = new ArrayList<>();

    private String nomA;
    private String prenomA;
    private char sexeA;
    private int agilite;
    private int endurance;
    private int force;
    private static int IDnext = 1;
    private int ID;


    public Athlete(String nomA, String prenomA, char sexeA, int agilite, int endurance, int force){
            //throws IDdejaExistantException {
        //if (lesID.contains(id))
        //    throw new IDdejaExistantException("cet id est déjà utilisé");
        //lesID.add(id);
        this.nomA = nomA;
        this.prenomA = prenomA;
        this.sexeA = sexeA;
        this.agilite = agilite;
        this.endurance = endurance;
        this.force = force;
        this.ID = this.IDnext;
        this.IDnext++;

        Cache.setDATA(Athlete.class, this);
    }

    


    /*
    *retourne l'identifiant 
    *@return int IDathlete
    */

    @Override
    public Integer getID() {
        return this.ID;
    }
    @Override
    public void supprID(){
        lesID.remove(ID);
    }
    public void clearID(){
        lesID = new ArrayList<>();
    }

    /*
    *retourne le nouveau identifiant 
    *@return int
    */
    public static int getNewId() {
        int i = 20000;
        while (lesID.contains(i))
            i++;
        System.out.println("nouvel ID : " + i);
        return i;
    }

    /*
    *recupere le nom de l'Athlete
    *@return String nomA
    */
    public String getNomA() {
        return nomA;
    }

    /*
    *modifie le nom de l'Athlete
    @param nomA
    */
    public void setNomA(String nomA) {
        this.nomA = nomA;
    }

    /*
    *retourne le prenom de athlete
    *@return String prenomA
    */
    public String getPrenomA() {
        return prenomA;
    }

    
    /*
    *modifie le prenom de athlete
    *@Param String prenomA
    */
    public void setPrenomA(String prenomA) {
        this.prenomA = prenomA;
    }

    /*
    *retourne le sex en character de l'athelete
    *@return char sexeA
    */
    public char getSexeA() {
        return sexeA;
    }

    /*
    *modifie le sex en character de l'athelete
    *@Param char sexeA
    */
    public void setSexeA(char sexeA) {
        this.sexeA = sexeA;
    }

    /*
    *retourne les stats de l'agiliter en entier de l'athelete
    *@return int agilite
    */
    public int getAgilite() {
        return agilite;
    }

    /*
    *modifie les stats de l'agiliter en entier de l'athelete
    *@Param int agilite
    */
    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    /*
    *retourne les stats de l'endurance en entier de l'athelete
    *@return int endurance
    */
    public int getEndurance() {
        return endurance;
    }

    
    /*
    *modifie les stats de l'endurance en entier de l'athelete
    *@Param int endurance
    */
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    /*
    *retourne les stats de la force en entier de l'athelete
    *@return int force
    */
    public int getForce() {
        return force;
    }

    
    /*
    *modifie les stats de la force en entier de l'athelete
    *@Param int force
    */
    public void setForce(int force) {
        this.force = force;
    }

    @Override

    public String toString() {
        return this.nomA + " " + this.prenomA+  " avec : " + this.agilite + " d'agilité, " + this.endurance + " d'endurance, et " + this.force + " de force.";

        /**  + " est un "+((this.sexeA == 'H')? "Homme" : "Femme")+" avec : " + this.agilite + " d'agilité, "
                    + this.endurance + " d'endurance, et " + this.force + " de force.";*/
    }
}
