package sjt.http.core.parser;

public class ContentTypeFactory {
    private ApplicationJsonParser applicationJsonParser;

    public ContentTypeParser getInstance(String mediaType) {
        ContentType contentType = ContentType.getByMediaType(mediaType);

        switch (contentType) {
            case APPLICATION_JSON:
                return applicationJsonParser;
            default:
                throw new RuntimeException("지원하지 않는 content-type입니다.");
        }
    }
}
