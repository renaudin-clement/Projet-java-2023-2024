import java.util.Comparator;

public class CompareMedailleTotal implements Comparator<Pays>{


    /*
    *retourne la difference entre deux pays via leur nombre total de medailles
    *@return int (si positif m1 (pay1) est au dessus de m2 (pays2) en terme de nombre de medailles 
    *sinon p1 est au dessous de p2 si p1 et p2 sont egale a eux meme representer par 0  on place par ordre d'arriver
    */
    
    @Override
    public int compare(Pays p1, Pays p2){
        int m1 = p1.getmedailles_total();
        int m2 = p2.getmedailles_total();
        return m2-m1;
    }
}
