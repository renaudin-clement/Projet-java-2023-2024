import java.util.Comparator;
    
public class CompareMedailleArgent implements Comparator<Pays>{

    /*
    *retourne la difference entre deux pays en terme de medailles dargent 
    *@return int (si positif m1 (pay1) est au dessus de m2 (pays2) en terme de medailles sinon p1 est au dessous de m2 si m1 et m2 sont egale a eux meme representer par 0  on place par ordre d'arriver
    */
    @Override
    public int compare(Pays p1, Pays p2){
        int m1 = p1.getmedailles_argent();
        int m2 = p2.getmedailles_argent();
        return m2-m1;
    }
}
