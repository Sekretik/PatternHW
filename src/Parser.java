import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
    private ArrayList<Subscriber> subscribers = new ArrayList<>();
    private HashMap<String,String> result = new HashMap<>();

    public FillStrategy filler;
    public int currentChar;
    public String json;
    public ParseState state;
    public boolean parsingIsEnd = false;

    public String keyCache = "";
    public String cache = "";

    public void parse() {
        currentChar = 0;
        state = new BracketState();

        while (!parsingIsEnd){
            state.doParsing(this);
        }

        result = (HashMap<String, String>) filler.getResult();
        notifySubscribers();
    }

    private void notifySubscribers() {
        for(Subscriber subscriber : subscribers) subscriber.notify(result);
    }

    public void subscribe(Subscriber subscriber){
        subscribers.add(subscriber);
    }


}
