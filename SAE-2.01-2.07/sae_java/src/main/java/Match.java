public class Match {
    protected Epreuve epreuve;
    protected Sport sport;

    protected String nomMatch;



    private static int numMatch;

    protected double moyenneAthletique = 1;
    protected double recordMondial = 1;


    public Match(Epreuve epreuve, double moy, double rec){
        this.epreuve = epreuve;
        this.moyenneAthletique = moy;
        this.recordMondial = rec;
        this.sport = epreuve.getLeSports();

        Match.numMatch+=1;

        this.nomMatch = this.epreuve.getNomEpreuve() + " Match n°" + numMatch;
    }

    public Match(Epreuve epreuve){
        this.epreuve = epreuve;
        this.sport = epreuve.getLeSports();

        Match.numMatch+=1;

        this.nomMatch = this.epreuve.getNomEpreuve() + " Match n°" + numMatch;
    }

    public double getRecordMondial() {
        return this.recordMondial;   
    }

    public static void clearNum(){ Match.numMatch=0;};

    public void deroulerMatch(){}


}
