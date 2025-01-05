import java.util.Comparator;

public class CompareMedailleOr implements Comparator<Pays>{
    
    /*
    *retourne la difference entre deux pays en terme de medailles d'or
    *@return int (si positif m1 (pay1) est au dessus de m2 (pays2) en terme de medailles d'or sinon p1 est au dessous de p2 si p1 et p2 sont egale a eux meme representer par 0  on place par ordre d'arriver
    */
    
    @Override
    public int compare(Pays p1, Pays p2){
        int m1 = p1.getmedailles_or();
        int m2 = p2.getmedailles_or();
        return m2-m1;
    }
    }
