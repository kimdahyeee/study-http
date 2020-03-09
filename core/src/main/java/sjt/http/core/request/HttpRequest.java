package sjt.http.core.request;

import lombok.Getter;
import lombok.ToString;
import sjt.http.core.response.HttpMethod;

public class HttpRequest {
    private static final String SEPERATOR_START_LINE = " ";
    @Getter
    @ToString
    public static class StartLine {
        private HttpMethod httpMethod;
        private String requestTarget;
        private String protocolVersion;

        public StartLine() {
            this.protocolVersion = "HTTP/1.0";
        }

        public StartLine(String startLine) {
            String[] request = startLine.split(SEPERATOR_START_LINE);
            this.httpMethod = HttpMethod.valueOf(request[0]);
            this.requestTarget = request[1];
            this.protocolVersion = request[2];
        }
    }

    @ToString
    @Getter
    public static class HttpHeaders {
        private RequestHeaders requestHeaders;
        private GeneralHeaders generalHeaders;

        private EntityHeaders entityHeaders;
    }

    public static class RequestHeaders {
    }

    public static class GeneralHeaders {
    }

    public static class EntityHeaders {
    }
}
