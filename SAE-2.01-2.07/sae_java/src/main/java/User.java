import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String mail;
    private String mdp;
    private char role;


    public User(String mail, String mdp, char role){
        this.mail = mail;
        this.mdp = User.crypteMDP(mdp);
        this.role = role;
    }

    public static String crypteMDP(String mdp){
        String res = "";
        for(char cha : mdp.toCharArray()){
            cha = (char)(cha*2);
            res+=cha;
            Random r = new Random();
            res+=(char)(r.nextInt(26) + 'a');
        }
        return res;
    }
    public static String decrypteMDP(String mdp){
        String res = "";
        for(int i = 0; i<mdp.length()-1; i+=2){
            char cha = mdp.charAt(i);
            cha = (char)(cha/2);
            res+=cha;  
        }
        return res;
    }
    private static final String EMAIL_MODELTYPE =
    "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_MODELTYPE);
    public static boolean mailConforme(String mail){
        if (mail == null) {
        return false;
        }
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }


    public char getRole(){
        return role;
    }

    public boolean estAutorise(char droit){
        if(this.role == droit)
        return true;
        return false;
    }


    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return this.mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public void setRole(char role) {
        this.role = role;
    }

}
