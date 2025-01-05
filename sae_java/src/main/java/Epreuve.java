import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Math;
import java.util.HashMap;

public class Epreuve implements Participation<Equipe> {

    private static List<Integer> lesID = new ArrayList<>();

    private String nomEpreuve;
    private char sexeEpreuve;

    private String categorieEpreuve;
    private String typeEpreuve;

    private List<Equipe> SavelesEquipes;
    private List<Equipe> lesEquipes;

    // Liste de match/liste d'équipe/
    private List<Match> lesMatchs;
    private HashMap<Integer, List<MatchDuel>> pallierMatch;

    // private List<Match> scoresEquipes;
    private Sport leSport;

    private double moyenneAthletique = 1.0;
    private double recordMondial = 1.0;

    private int IDepreuve;

    private List<Equipe> classement;

    
    private Double valeurAgilite;
    private Double valeurEndurance;
    private Double valeurForce;

    
    // REGLE PERSONALISE
    protected boolean hasregle;
    protected Integer nbPointVictoireTotale;
    protected Integer nbPointMiniPourVictoire;
    protected Integer ecartDePointMini;

    public Epreuve(int id, String nomEpreuve, char sexeEpreuve, String categorieEpreuve, String typeEpreuve,
            Sport sport, Double valeurAgilite, Double valeurEndurance, Double valeurForce) throws IDdejaExistantException {
        if (lesID.contains(id))
            throw new IDdejaExistantException("cet id est déjà utilisé");
        lesID.add(id);
        this.nomEpreuve = nomEpreuve;
        this.sexeEpreuve = sexeEpreuve;
        this.categorieEpreuve = categorieEpreuve;
        this.typeEpreuve = typeEpreuve;
        this.classement = new ArrayList<>();

        this.leSport = sport;
        this.valeurAgilite = valeurAgilite;
        this.valeurEndurance = valeurEndurance;
        this.valeurForce = valeurForce;

        // this.scoresEquipes = new ArrayList<>();
        this.lesEquipes = new ArrayList<>();
        this.lesMatchs = new ArrayList<>();

    }

    public Epreuve(int id, String nomEpreuve, char sexeEpreuve, String categorieEpreuve, String typeEpreuve,
            Sport sport, double moy, double rec, Double valeurAgilite, Double valeurEndurance, Double valeurForce) throws IDdejaExistantException {
        if (lesID.contains(id))
            throw new IDdejaExistantException("cet id est déjà utilisé");
        lesID.add(id);
        this.nomEpreuve = nomEpreuve;
        this.sexeEpreuve = sexeEpreuve;
        this.categorieEpreuve = categorieEpreuve;
        this.typeEpreuve = typeEpreuve;
        this.moyenneAthletique = moy;
        this.recordMondial = rec;
        this.IDepreuve = id;
        this.leSport = sport;
        this.valeurAgilite = valeurAgilite;
        this.valeurEndurance = valeurEndurance;
        this.valeurForce = valeurForce;

        // this.scoresEquipes = new ArrayList<>();
        this.lesEquipes = new ArrayList<>();
        this.lesMatchs = new ArrayList<>();

    }


    

    /*
    *retourne l'identifiant de l'epreuve
    *@return int IDepreuve
    */
    public int getID() {
        return IDepreuve;
    }


    /*
    *retourne le nouveau identifiant de l'epreuve
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
    *retourne la liste des classement de l'epreuve
    *@return List<Equipe> classement
    */
    
    public List<Equipe> getClassement() {
        return classement;
    }

    /*
    *retourne le sexe prevue pour l'epreuve
    *@@return char sexeEpreuve
    */
    
    public char getSexeEpreuve() {
        return sexeEpreuve;
    }


    /*
    *retourne le sexe prevue pour l'epreuve
    *@return String nomEpreuve
    */
    public String getNomEpreuve() {
        return this.nomEpreuve;
    }

    /*
    *modifie le nom de l'epreuve
    *@param String nomEpreuve
    */
    public void setNomEpreuve(String nomEpreuve) {
        this.nomEpreuve = nomEpreuve;
    }

    /*
    *retourne la moyenne Athletique attribuer pour l'epreuve
    *@return double moyenneAthletique
    */
    public double getMoyenneAthlet() {
        return this.moyenneAthletique;
    }

    /*
    *retourne le record Mondial attribuer a l'epreuve
    *@return double recordMondial
    */
    public double getRecordMondil() {
        return this.recordMondial;
    }

    /*
    *retourne la liste des matchs attribuer a l'epreuve
    *@return  List<Match>  lesMatchs
    */
    public List<Match> getLesMatchs() {
        return lesMatchs;
    }

    /*
    *modifie la moyenne Athletique attribuer a l'epreuve
    *@param double moye
    */    
    public void setMoyenneAthlet(double moye) {
        this.moyenneAthletique = moye;
    }


    /*
    *modifie le record Mondial de l'epreuve
    * @param double rec
    */    
    public void setRecordMondil(double rec) {
        this.recordMondial = rec;
    }

    
    /*
    *retourne la Categorie de Epreuve (les indications de la pécificité de l'epreuve sur 100m , a l'epee)
    * @return String categorieEpreuve
    */  
    public String getCategorieEpreuve() {
        return categorieEpreuve;
    }

    /*
    *modifie la Categorie de Epreuve (les indications de la pécificité de l'epreuve sur 100m , a l'epee)
    * @param String categorieEpreuve
    */  
    public void setCategorieEpreuve(String categorieEpreuve) {
        this.categorieEpreuve = categorieEpreuve;
    }

    /*
    *retourne le type de l'Epreuve
    *@return String typeEpreuve
    */  
    public String getTypeEpreuve() {
        return typeEpreuve;
    }


    /*
    *modifie le type de l'Epreuve 
    * @param  String typeEpreuve
    */  
    public void setTypeEpreuve(String typeEpreuve) {
        this.typeEpreuve = typeEpreuve;
    }

    /*
    *retourne le Sport de l'Epreuve 
    *  @return Sport leSport
    */  

    public Sport getLeSports() {
        return this.leSport;
    }
    
    /*
    *modifie le Sport de l'Epreuve 
    *  @param Sport leSport
    */  
    public void setLeSports(Sport lesSports) {
        this.leSport = lesSports;
    }


    
    /*
    *retourne la valeur Agilite pour un sport
    *@return Double valeurAgilite
    */
    public Double getValeurAgilite() {
        return valeurAgilite;
    }

     /*
    *modifie la valeur Agilite pour un sport
    *@param Double valeurAgilite
    */
    public void setValeurAgilite(Double valeurAgilite) {
        this.valeurAgilite = valeurAgilite;
    }

    /*
    *retourne la valeur Endurance pour un sport
    *@return Double valeurEndurance
    */
    public Double getValeurEndurance() {
        return valeurEndurance;
    }

    /*
    *modifie la valeur Endurance pour un sport
    *@param Double valeurEndurance
    */
    public void setValeurEndurance(Double valeurEndurance) {
        this.valeurEndurance = valeurEndurance;
    }

    /*
    *retourne la valeur Force pour un sport
    *@return Double valeurForce
    */
    public Double getValeurForce() {
        return valeurForce;
    }

    /*
    *modifie la valeur Force pour un sport
    *@param Double valeurForce
    */
    public void setValeurForce(Double valeurForce) {
        this.valeurForce = valeurForce;
    }

    /*
    *retourne vrai ou faux si lees regles special son respecter pour un sport
    *@return boolean hasregle
    */
    public boolean hasReglePersonalisee() {
        return hasregle;
    }

        /*
    *retourne vrai ou faux pour la conditionVictoire si elle est respecter pour un sport
    *@param Double a, Double b
    *@return boolean si la condition de victoire est valider
    */
    public boolean conditionVictoire(Double a, Double b) {
        if ((a >= nbPointVictoireTotale || b >= nbPointVictoireTotale) && nbPointVictoireTotale != null)
            return true;
        if (ecartDePointMini != null) {
            if (a >= nbPointMiniPourVictoire && (a - b) >= ecartDePointMini)
                return true;
            if (b >= nbPointMiniPourVictoire && (b - a) >= ecartDePointMini)
                return true;
        }
        return false;
    }

    /*
    *modifie les regle pour un sport
    *@param int nbPointVictoireTotale : le nombre de points nécessaire pour gagner sans condition
    *@param int nbPointMiniPourVictoire :  le nombre de points mini avant que la condition d'écart de points soit remplie
    *@param int ecartDePointMini : ecrat minimum de point entre joueur 1 et joueur 2
    */
    public void setRegle(int nbPointVictoireTotale, int nbPointMiniPourVictoire, int ecartDePointMini) {
        this.nbPointVictoireTotale = nbPointVictoireTotale;
        this.nbPointMiniPourVictoire = nbPointMiniPourVictoire;
        this.ecartDePointMini = ecartDePointMini;
        this.hasregle = true;
    }

    /*
    * fait participer une équipe à l'épreuve avec des conditions
    * @param  Equipe equipe soit une équipe
    */  
    @Override
    public void participer(Equipe equipe) throws Exception {
        if (equipe.estALaBonneTaille())                        // si l'epreuve est de la bonne taille
            if (equipe.getSexeEquipe() == this.sexeEpreuve)    // si l'epreuve et l'equipe est du bon sexe
                this.lesEquipes.add(equipe);
            else
                throw new PasLeBonSexeException("Le sexe des athletes ne correspond pas au type de l'épreuve");
        else
            throw new PasALaBonneTailleException("l'équipe n'a pas la bonne taille");

    }


    /*
    * fait retirer une équipe de l'épreuve 
    * @param  Equipe equipe soit une équipe
    */  
    @Override
    public void retirer(Equipe equipe) throws NoSuchElementException {
        this.lesEquipes.remove(equipe);

    }


    /*
    * affiche les équipes participant à l'épreuve
    * @return List<Equipe> lesEquipes (une liste des equipe qui participe a l'epreuve)
    */  
    public List<Equipe> afficheLesEquipes() {
        return this.lesEquipes;
    }

    /*
    * affiche les matchs de l'épreuve
    * @return List<Match> lesMatchs
    */  
    public List<Match> afficheLesMatchs() {
        return this.lesMatchs;
    }

    /* 
     * inverse le classement
     * @param List<Equipe> Classement
     * @return le List<Equipe> Classement finale
     */
    public List<Equipe> reverse(List<Equipe> Classement) {
        for (int k = 0, j = Classement.size() - 1; k < j; k++) {
            Classement.add(k, Classement.remove(j));
        }
        return Classement;

    }


    // 
    //          REFONTE DE LANCEEPREUVE
    //

    public List<Equipe> lanceEpreuve2(){
        HashMap<Integer, List<Equipe>> classementReel = new HashMap<>();
        classementReel.put(1, (List)lesEquipes);
        pallierMatch = new HashMap<>();
        
        if(typeEpreuve == "Score"){
            List<MatchScore> listScores = new ArrayList<>();
            for(Equipe equip : lesEquipes){
                
                MatchScore match = new MatchScore(this, equip, moyenneAthletique, recordMondial);
                match.deroulerMatch();
                listScores.add(match);

                if (match.getScore() > this.recordMondial) {
                    //* option de record mondial si record mondial battu */
                    System.out.println("NOUVEAU RECORD MONDIAL !!!!!!!!!");
                    this.recordMondial = match.getScore();
                }   
            }
            Comparator<MatchScore> compare = new CompareMatchScore();
            Collections.sort(listScores, compare);
            List<Equipe> res = new ArrayList<>();
            for(int z=0 ; z<listScores.size(); z++)  // A changer si le classement est inversé
            res.add(listScores.get(z).getEquipe());
            return res;
        }
        
        else if(typeEpreuve == "Duel"){
        
        while(classementReel.size()<lesEquipes.size()){
        for(int x = classementReel.size(); x>0; x--){
            List<Equipe[]> matchsAfaire = new ArrayList<>();
        for(int i = 0; i<classementReel.get(x).size(); i+=2){
            try {
                matchsAfaire.add(new Equipe[]{classementReel.get(x).get(i), classementReel.get(x).get(i+1)});
            } catch (Exception e) {break;} 
        }        
        for(Equipe[] lesEquips : matchsAfaire){
            List<MatchDuel> matchsEff = pallierMatch.get(1);
            matchsEff.add(new MatchDuel(this, lesEquips[0], lesEquips[1])); 
            matchsEff.get(matchsEff.size()-1).deroulerMatch(); 
            Equipe leGagnant = matchsEff.get(matchsEff.size()-1).getGagnant();
            classementReel.get(x).remove(leGagnant);
            if(classementReel.size()-1 == x)
            classementReel.put(x+1, Arrays.asList(leGagnant));
            else{classementReel.get(x+1).add(leGagnant);}
                    }       
                }
            }
            List<Equipe> res = new ArrayList<>();
            for(int z=classementReel.size()-1; z>0; z--)
            res.add(classementReel.get(z).get(0));
            return res;
        }
        else{
            System.err.println("Ce type de match n'est pas pris en charge");
            return new ArrayList<Equipe>();
        }
    }





    //
    //












    public List<Equipe> lanceEpreuve() {
        List<Equipe> Classement = new ArrayList<>();

        if (this.lesEquipes.size() == 0)
            return null;
        // System.out.println(this.lesEquipes);

        if (typeEpreuve == "Duel") {
            boolean resteDesMatch = true;
            Collections.shuffle(this.lesEquipes);
            HashMap<Integer, List<Equipe>> pallierEquipe = new HashMap<Integer, List<Equipe>>();
            pallierMatch = new HashMap<Integer, List<MatchDuel>>();
            pallierEquipe.put(0, this.lesEquipes);

            while (resteDesMatch == true) {
                HashMap<Integer, Equipe> pallierEquipeSansMatch = new HashMap<Integer, Equipe>();
                for (Map.Entry<Integer, List<Equipe>> entry : pallierEquipe.entrySet()) {
                    Integer cleEqip = entry.getKey();
                    List<Equipe> valeursEqip = entry.getValue(); // CREE LES MATCHDUEL
                    if (valeursEqip.size() != 0) {
                        List<MatchDuel> listematchs = new ArrayList<>();
                        for (int i = 0; i < valeursEqip.size(); i += 2) {
                            if (valeursEqip.size() == i + 1) {
                                pallierEquipeSansMatch.put(cleEqip, valeursEqip.get(i));
                                break;
                            }
                            MatchDuel match = new MatchDuel(this, valeursEqip.get(i), valeursEqip.get(i + 1));
                            match.deroulerMatch();
                            lesMatchs.add(match);
                            listematchs.add(match);
                        }
                        pallierMatch.put(cleEqip, listematchs);
                    }
                }
                List<Integer> clePallierEquipe = new ArrayList<>(pallierEquipe.keySet());
                List<Integer> clePallierMatch = new ArrayList<>(pallierMatch.keySet());
                Collections.sort(clePallierEquipe);
                Collections.sort(clePallierMatch);

                pallierEquipe.clear();

                List<MatchDuel> valeurMatchPallier0 = new ArrayList<>();
                List<MatchDuel> valeurMatchPallier1 = new ArrayList<>();

                for (Integer cleMatch : clePallierMatch) {
                    valeurMatchPallier0 = pallierMatch.get(cleMatch);
                    valeurMatchPallier1 = pallierMatch.get(cleMatch + 1);

                    // System.out.println("la cle" +cleMatch);
                    // System.out.println("m0 " +valeurMatchPallier0);
                    // System.out.println("m1 " +valeurMatchPallier1);

                    // DEBUT
                    if (cleMatch == clePallierMatch.get(0)) {
                        List<Equipe> newPallier1 = new ArrayList<>();
                        for (MatchDuel resMatchPallier0 : valeurMatchPallier0) {
                            if (resMatchPallier0.getScoreEquipe1() < resMatchPallier0.getScoreEquipe2()) { // on ajoute
                                                                                                           // le perdant
                                                                                                           // du pallier
                                newPallier1.add(resMatchPallier0.getEquipe1());
                            } else {
                                newPallier1.add(resMatchPallier0.getEquipe2());
                            }
                        }
                        if (pallierEquipeSansMatch.get(cleMatch) != null)
                            newPallier1.add(pallierEquipeSansMatch.get(cleMatch));
                        // System.out.println("aled");
                        pallierEquipe.put(cleMatch, newPallier1);

                    }

                    // MILIEU
                    List<Equipe> newPallier2 = new ArrayList<>();
                    for (MatchDuel resMatchPallier0 : valeurMatchPallier0) {
                        if (resMatchPallier0.getScoreEquipe1() < resMatchPallier0.getScoreEquipe2()) { // on ajoute le
                                                                                                       // gagnant
                            newPallier2.add(resMatchPallier0.getEquipe2());
                        } else {
                            newPallier2.add(resMatchPallier0.getEquipe1());
                        }
                    }
                    if (valeurMatchPallier1 != null) { // AFFECTE LES EQUIPE A LEUR PALLIER SELON LES MATCH
                        for (MatchDuel resMatchPallier1 : valeurMatchPallier1) {
                            if (resMatchPallier1.getScoreEquipe1() < resMatchPallier1.getScoreEquipe2()) { // on ajoute
                                                                                                           // le perdant
                                newPallier2.add(resMatchPallier1.getEquipe1());
                            } else {
                                newPallier2.add(resMatchPallier1.getEquipe2());
                            }
                        }
                        if (pallierEquipeSansMatch.get(cleMatch + 1) != null)
                            newPallier2.add(pallierEquipeSansMatch.get(cleMatch + 1));

                    }
                    pallierEquipe.put(cleMatch + 1, newPallier2);

                    // FIN

                    List<Equipe> newPallier3 = new ArrayList<>();
                    if (cleMatch + 1 == clePallierMatch.size()) {
                        if (valeurMatchPallier1 != null) {
                            for (MatchDuel resMatchPallier1 : valeurMatchPallier1) {
                                if (resMatchPallier1.getScoreEquipe1() < resMatchPallier1.getScoreEquipe2()) { // on
                                                                                                               // ajoute
                                                                                                               // le
                                                                                                               // gagnant
                                    newPallier3.add(resMatchPallier1.getEquipe2());
                                } else {
                                    newPallier3.add(resMatchPallier1.getEquipe1());
                                }
                            }
                        }
                        if (pallierEquipeSansMatch.get(cleMatch + 2) != null)
                            newPallier3.add(pallierEquipeSansMatch.get(cleMatch + 2));

                        pallierEquipe.put(cleMatch + 2, newPallier3);
                        break;
                    }
                }

                pallierMatch.clear();
                // VERIFIE SI LA BOUCLE EST FINI ET CREE LE CLASSEMENT
                resteDesMatch = false;
                for (Integer cleEquipe : clePallierEquipe) { 
                    List<Equipe> listeEquipe2 = pallierEquipe.get(cleEquipe);
                    for (Equipe equipe : listeEquipe2) {
                        if (listeEquipe2.size() == 1) {
                            Classement.add(equipe);
                        } else {
                            resteDesMatch = true;
                        }
                    }
                }

                if (resteDesMatch) {
                    Classement.clear();
                }

            }
            //* distribue les medailles */
            Classement = reverse(Classement);
            if (Classement.size() > 1)
                Classement.get(0).ajouteMedailleOr();
            if (Classement.size() > 2)
                Classement.get(1).ajouteMedailleArgent();
            if (Classement.size() > 3)
                Classement.get(2).ajouteMedailleBronze();

            this.classement = Classement;
            return Classement;
        }

        if (typeEpreuve == "Score") {
            // System.out.println(this.lesEquipes);

            // tant que il ya des joueur restant dans les.équipe
            List<MatchScore> scoresEquipes = new ArrayList<>();
            // on défini le nombre de matchs à réaliser
            int nbDeMatchs = Math.round((this.lesEquipes.size()) / 3);
            // System.out.println(nbDeMatchs);
            if (nbDeMatchs == 0) {
                nbDeMatchs = 1;
            }
            for (int i = 0; i < nbDeMatchs; i++) {
                /*
                 * on crée un match
                 * on fait jouer le match
                 * puis on compare les scores
                 * 
                 * après chaque matchs :
                 * on replace dans this.LesEquipes les scores les plus élevés sauf les 3
                 * dernier.
                 * les 3 dernier son ajouter au classement (l'idée est de simplement inverser
                 * les index de Classement pour obtenir notre vrai classement)
                 */
                scoresEquipes.clear();
                for (int j = 0; j < this.lesEquipes.size(); j++) {
                    MatchScore match = new MatchScore(this, this.lesEquipes.get(j), this.moyenneAthletique,
                            this.recordMondial);
                    match.deroulerMatch();
                    lesMatchs.add(match);
                    scoresEquipes.add(match);

                    if (match.getScore() > this.recordMondial) {
                        //* option de record mondial si record mondial battu */
                        System.out.println("NOUVEAU RECORD MONDIAL !!!!!!!!!");
                        this.recordMondial = match.getScore();
                    }

                    // System.out.println(scoresEquipes+"\n\n");
                    // System.out.println(lesEquipes.size()+"\n");
                }
                Comparator<MatchScore> compare = new CompareMatchScore();
                Collections.sort(scoresEquipes, compare);
                // System.out.println("score tri = "+scoresEquipes+"\n\n");
                this.lesEquipes.clear();

                for (int posMatch = 0; posMatch < scoresEquipes.size(); posMatch++) {
                    if (posMatch < 3) {
                        Classement.add(scoresEquipes.get(posMatch).getEquipe());
                    } else {
                        this.lesEquipes.add(scoresEquipes.get(posMatch).getEquipe());
                    }

                    // System.out.println("le classement est "+Classement+"\n\n\n");
                    // System.out.println("E contient"+this.lesEquipes+"\n\n");

                }
                // System.out.println("il reste " + i + "sur " + nbDeMatchs);
                if (this.lesEquipes.size() != 0 && i + 1 == nbDeMatchs) {
                    // System.out.println("oui je passe dans la boucle");
                    for (Equipe EquipeRestente : this.lesEquipes) {
                        Classement.add(EquipeRestente);
                    }
                }
            }
            //* distribue les medailles */
            Classement = reverse(Classement);
            if (Classement.size() > 0)
                Classement.get(0).ajouteMedailleOr();
            if (Classement.size() > 1)
                Classement.get(1).ajouteMedailleArgent();
            if (Classement.size() > 2)
                Classement.get(2).ajouteMedailleBronze();
            this.classement = Classement;
            return Classement;
        }

        else {
            System.out.println("l'épreuve à rencontrer un problème, et n'a pas pu avoir lieu");
            return Classement;
        }
    }

    @Override
    public String toString() {
        String textAgilite;
        String textForce;
        String textEndurance;

        if (valeurAgilite < 0.33)
            textAgilite = " est très demandant en agilite";

        else if (valeurAgilite < 0.66)
            textAgilite = " est assez demandant en agilite";

        else
            textAgilite = " ne demande pas d'agilite";

        if (valeurForce < 0.33)
            textForce = " est très demandant en force";

        else if (valeurForce < 0.66)
            textForce = " est assez demandant en force";

        else
            textForce = " ne demande pas de force";

        if (valeurEndurance < 0.33)
            textEndurance = " est très demandante en endurance";

        else if (valeurEndurance < 0.66)
            textEndurance = " est assez demandant en endurance";

        else
            textEndurance = " ne demande pas d'endurence";


        return "l'épreuve " + this.nomEpreuve + " pour les " + this.sexeEpreuve + "nécéssite" + textAgilite + " d'agilité, aussi elle " + textEndurance + " d'endurence, et enfin elle "
        + textForce + " de force" ;
    }
}
