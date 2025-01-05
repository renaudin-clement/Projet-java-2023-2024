public class MatchScore extends Match{
    private double score = 0;
    private Equipe equipe;



    public MatchScore(Epreuve epreuve, Equipe equip, double moy, double rec){
        super(epreuve, moy, rec);
        this.equipe = equip;
    }

    public double getScore(){return this.score;}

    public Equipe getEquipe(){return this.equipe;}

    @Override
    public void deroulerMatch(/*Integer tentatives*/){
        //tentatives = tentatives != null ? tentatives : 1;
        if (this.equipe.getLesAthletes().size() >= 1){
                for (Athlete athlete : this.equipe.getLesAthletes()){
                    //for (int i; i<tentatives; i++){
                    boolean inv  = this.recordMondial<this.moyenneAthletique;
                    double scoretp = 0.0;
                    if(!inv){
                    scoretp = ((this.moyenneAthletique 
                                        + (this.epreuve.getValeurAgilite()*athlete.getAgilite())/(50/this.moyenneAthletique) 
                                        + (this.epreuve.getValeurEndurance()*athlete.getEndurance()/(50/this.moyenneAthletique)) 
                                        + (this.epreuve.getValeurForce()*athlete.getForce()/(50/this.moyenneAthletique)))
                                        * RandomNumberInRange.getRandom(0.8, 1.1))*sport.getNbdePointmax();
                    } else {
                    scoretp = ((this.moyenneAthletique 
                                        - (this.epreuve.getValeurAgilite()*athlete.getAgilite())/(50/this.moyenneAthletique) 
                                        - (this.epreuve.getValeurEndurance()*athlete.getEndurance()/(50/this.moyenneAthletique)) 
                                        - (this.epreuve.getValeurForce()*athlete.getForce()/(50/this.moyenneAthletique)))
                                        * RandomNumberInRange.getRandom(0.8, 1.1))*sport.getNbdePointmax();
                    }
                    
                    if (score < scoretp){score = scoretp;}
                    //}
                }
                //score = score/equipe.size();
                
        }
    }

    @Override
    public String toString(){
        return "Le match " + this.nomMatch
                + ", fait participer l'équipe numéro : " + this.equipe.getID()
                + " et cette à réalisé un score de " + String.valueOf(this.score) + "\n";
    }
}

