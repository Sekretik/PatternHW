import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();

        HashMap<String, String> result = facade.parseJson("{key1:value1,key2:value2}");

        for(String key : result.keySet()) {
            System.out.println(key + ": " + result.get(key));
        }
    }
}
