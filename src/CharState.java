public class CharState implements ParseState{
    @Override
    public void doParsing(Parser parser) {
        char currentChar = parser.json.charAt(parser.currentChar);
        if(currentChar == ',') {
            parser.state = new CommaState();
            return;
        }

        if(currentChar == '}') {
            parser.state = new BracketState();
            return;
        }

        parser.currentChar += 1;

        if(currentChar == ':') {
            parser.keyCache = parser.cache;
            parser.cache = "";
            return;
        }

        parser.cache = parser.cache + currentChar;
    }
}
