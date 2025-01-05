import java.util.Comparator;
public class CompareMatchScore implements Comparator<MatchScore> {

/*
*retourne la difference entre deux matche score via un entier 
*@return int (si positif m1 est gagnant sinon m1 est perdant si 0 m1 et m2 on le meme scoredonc ce'st par ordre d'arriver
*/
@Override
public int compare(MatchScore m1, MatchScore m2) {
double malo1 = m1.getScore()*1000;
double malo2 = m2.getScore()*1000;
return (int)(malo1 - malo2);
}

}

