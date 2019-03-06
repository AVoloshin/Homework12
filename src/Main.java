public class Main {

    public static void main(String[] args) {

        ParseJSON parser = new ParseJSON();
        parser.parseJackson(parser.getFile());
        parser.parseJson(parser.parseGson(parser.getFile()));
    }
}
