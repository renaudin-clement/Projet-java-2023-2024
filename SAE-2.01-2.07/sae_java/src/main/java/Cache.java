import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cache {

    public static HashMap<Class, List<Data>> DONNEES = new HashMap<>();

    public static <T> List<Data> getDATA(Class<T> nom){
        if(DONNEES.get(nom) != null) return DONNEES.get(nom);
        else return new ArrayList<>();
    }

    public static <T extends Data> List<T> getDATAAs(Class<T> type) {
        List<Data> rawDataList = DONNEES.get(type);
        List<T> typedDataList = new ArrayList<>();
        
        if (rawDataList != null) {
            for (Data<T> data : rawDataList) {
                if (type.isInstance(data)) {
                    typedDataList.add(type.cast(data));
                }
            }
        }
        return typedDataList;
    }

    public static <T> void setDATA(Class<T> class1, Data data){
        if(!DONNEES.containsKey(class1)){
            DONNEES.put(class1, new ArrayList<Data>());
        }
        DONNEES.get(class1).add(data);
    }

    public static <T> boolean containDATA(Class<T> nom, Data data){
        if(!DONNEES.containsKey(nom)){
            if(DONNEES.get(nom).contains(data)) return true;
        }
        return false;
    }

    public static <T extends Data> void removeDATA(Class<T> nom, Data data){
        if(!DONNEES.containsKey(nom)){
            DONNEES.get(nom).remove(data);
            data.supprID();
            
        }
    }

    public static void clearCACHE(){
        DONNEES = new HashMap<>();
    }
}