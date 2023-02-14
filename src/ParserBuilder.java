public class ParserBuilder extends Parser {
    private Parser parser = new Parser();

    public Parser build() {
        return parser;
    }

    public ParserBuilder json(JsonFactory jsonFactory) {
        parser.json = jsonFactory.getJson();
        return this;
    }

    public ParserBuilder filler(FillStrategy filler) {
        parser.filler = filler;
        return this;
    }
}
