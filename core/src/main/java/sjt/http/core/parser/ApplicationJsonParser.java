package sjt.http.core.parser;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

public class ApplicationJsonParser implements ContentTypeParser {
    private boolean canParse(String value) {
        JSONParser jsonParser = new JSONParser();
        try {
            jsonParser.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException("unsupported value");
        }
        return true;
    }

    @Override
    public Map<String, Object> parse(String value) {
        canParse(value);

        Map<String, Object> jsonObject = new HashMap<>();

        //parsing
        JSONParser jsonParser = new JSONParser();
        try {
            jsonObject = (Map<String, Object>) jsonParser.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
