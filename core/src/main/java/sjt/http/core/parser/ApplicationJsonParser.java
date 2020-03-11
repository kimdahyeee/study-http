package sjt.http.core.parser;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Map;

public class ApplicationJsonParser implements ContentTypeParser {
    private boolean canParse(String param) {
        JSONParser jsonParser = new JSONParser();
        try {
            jsonParser.parse(param);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public Map<String, Object> parse() {
        //canparse

        //parse logic

        return null;
    }
}
