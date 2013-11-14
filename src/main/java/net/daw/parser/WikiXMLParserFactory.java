package net.daw.parser;

/**
 *
 * @author Delip Rao
 *
 */
public class WikiXMLParserFactory {
    public static WikiXMLParser getSAXParser(String fileName) {
        return new WikiXMLSAXParser(fileName);
    }

}
