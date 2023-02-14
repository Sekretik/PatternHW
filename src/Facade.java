import java.util.HashMap;

public class Facade implements Subscriber{
    HashMap<String,String> result;

    public HashMap<String,String> parseJson(String json){
        JsonFactory factory = new JsonFactory() {
            @Override
            public String getJson() {
                return json;
            }
        };

        FillStrategy filler = new FillStrategy() {
            HashMap<String, String> result = new HashMap();

            @Override
            public void fill(String key, String value) {
                result.put(key, value.toString());
            }

            @Override
            public Object getResult() {
                return result;
            }
        };

        Parser parser = new ParserBuilder().json(factory).filler(filler).build();

        parser.subscribe(this);

        parser.parse();

        return result;
    }

    @Override
    public void notify(Object result) {
        this.result = (HashMap<String, String>) result;
    }
}
