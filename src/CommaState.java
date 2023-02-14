public class CommaState implements ParseState{
    @Override
    public void doParsing(Parser parser) {
        parser.filler.fill(parser.keyCache, parser.cache);
        parser.currentChar = parser.currentChar + 1;
        parser.state = new CharState();
        parser.keyCache = "";
        parser.cache = "";
    }
}
