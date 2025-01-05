
import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc {
    public static void main(String[] args) {
        
      try {
        System.out.println("gfsg");
        ConnexionMySql truc = new ConnexionMySql();
        System.out.println("conn");
      } catch (Exception e) {
        System.out.println("marche pas " + e);
      }  

    }
}
