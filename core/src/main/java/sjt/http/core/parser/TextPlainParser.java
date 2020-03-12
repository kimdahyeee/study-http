package sjt.http.core.parser;

import java.util.Map;

public class TextPlainParser implements ContentTypeParser {
    @Override
    public Map<String, Object> parse(String value) {
        // text/plain map return ?
        return null;
    }
}
