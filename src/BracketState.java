public class BracketState implements ParseState{
    @Override
    public void doParsing(Parser parser) {
        char c = parser.json.charAt(parser.currentChar);

        if(c == '{') {
            parser.state = new CharState();
            parser.currentChar = parser.currentChar + 1;
            return;
        } else {
            parser.filler.fill(parser.keyCache, parser.cache);
            parser.parsingIsEnd = true;
        }
    }
}
