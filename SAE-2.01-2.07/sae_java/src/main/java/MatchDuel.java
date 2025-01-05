public class MatchDuel extends Match{
    private double score1 = 0;
    private double score2 = 0;
    private Equipe equipe1;
    private Equipe equipe2;


    public MatchDuel(Epreuve epreuve, Equipe equip1, Equipe equip2){
        super(epreuve);
        this.equipe1 = equip1;
        this.equipe2 = equip2;
        this.score1 = 0;    
        this.score2 = 0;    
    }


    public double getScoreEquipe1() {return score1;}
    
        
    public double getScoreEquipe2() {return score2;}


    public Equipe getEquipe1() {return equipe1;}

    public Equipe getEquipe2() {return equipe2;}


    @Override
    public void deroulerMatch(/*Integer tentatives*/){
        if (this.equipe1.getLesAthletes().size() >= 1 && this.equipe2.getLesAthletes().size() >= 1){
            if (this.epreuve.hasReglePersonalisee()){
                while (!this.epreuve.conditionVictoire(score1, score2)){      // AJOUTER LES 2 METHODES UTILISEE A SPORT 
                    scoreBase();
                }
            }
            else{
                deroulementDefault();
            }
        }
    }

    private void deroulementDefault(){
        for (int i = 0; i<Math.round(RandomNumberInRange.getRandom(4, 12)); i++){
            scoreBase();
        }
        if (score1-score2 == 0){

            // Mort subite du match, point de la victoire

            double actionFinaleEquipe1 = 0;
            double actionFinaleEquipe2 = 0;
            for (Athlete athlete : this.equipe1.getLesAthletes()){
                actionFinaleEquipe1 += (this.epreuve.getValeurAgilite()*athlete.getAgilite() + this.epreuve.getValeurEndurance()*athlete.getEndurance() + this.epreuve.getValeurForce()*athlete.getForce())*RandomNumberInRange.getRandom(0.6, 1.2);
            }
            for (Athlete athlete : this.equipe2.getLesAthletes()){
                actionFinaleEquipe2 += (this.epreuve.getValeurAgilite()*athlete.getAgilite() + this.epreuve.getValeurEndurance()*athlete.getEndurance() + this.epreuve.getValeurForce()*athlete.getForce())*RandomNumberInRange.getRandom(0.6, 1.2);
            }
            double res = actionFinaleEquipe1-actionFinaleEquipe2;
            if (res < 0)
                this.score2 += this.sport.getpoint();
            else {if (res>0){this.score1 += this.sport.getpoint();}}
        }
    }

    private void scoreBase(){

        // Test des équipes pour ajouter le point

        double actionEquipe1 = 0;
        double actionEquipe2 = 0;
        for (Athlete athlete : this.equipe1.getLesAthletes()){
            actionEquipe1 += (this.epreuve.getValeurAgilite()*athlete.getAgilite() + this.epreuve.getValeurEndurance()*athlete.getEndurance() + this.epreuve.getValeurForce()*athlete.getForce())*RandomNumberInRange.getRandom(0.6, 1.2);
        }
        for (Athlete athlete : this.equipe2.getLesAthletes()){
            actionEquipe2 += (this.epreuve.getValeurAgilite()*athlete.getAgilite() + this.epreuve.getValeurEndurance()*athlete.getEndurance() + this.epreuve.getValeurForce()*athlete.getForce())*RandomNumberInRange.getRandom(0.6, 1.2);
        }
        double res = actionEquipe1-actionEquipe2;
                    // Afin de laisser une chance de défense, il y a un pallier de 10% afin de marquer le point, l'obtention du nombre de point est définie dans sport

                    // AJOUTER LA METHODE GETPOINT A SPORT (c'est une liste de score possible selon le sport donné, si il y en a plusieurs cela en renvoit un random/ ou presque)
  

        if (res < 0-(actionEquipe1/10))
            this.score2 += this.sport.getpoint();
        else{if (res > 0+(actionEquipe2/10)){this.score1 += this.sport.getpoint();}} 


    }

    public Equipe getGagnant(){
        if(score1>score2) return equipe1;
        else return equipe2;
    }    
    

    @Override
    public String toString(){
        String text;
        text = "Le match " + this.nomMatch + ": " + this.equipe1 + " / " + this.equipe2 + " ; " + this.score1 + " / " + this.score2 + "\n";
        /*text += ", fait participer l'équipe : " + this.equipe;
        text += " et cette à réalisé un score de " + this.score;*/
        return text;
    }


}