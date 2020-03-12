package sjt.http.core.parser;

import java.util.Map;

public interface ContentTypeParser {
    // todo map return ok ?
    public Map<String, Object> parse(String value);
}
