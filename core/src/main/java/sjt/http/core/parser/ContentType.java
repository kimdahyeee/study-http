package sjt.http.core.parser;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ContentType {
    APPLICATION_JSON("Applcation/json"), TEXT_PLAIN("text/plain");

    String mediaType;

    ContentType(String mediaType) {
        this.mediaType = mediaType;
    }

    public static ContentType getByMediaType(final String mediaType) {
        return Arrays.stream(ContentType.values())
                .filter(contentType -> contentType.getMediaType().equals(mediaType))
                .findAny()
                .orElseThrow(() -> new RuntimeException("사용할 수 없는 content-type"));
    }
}
