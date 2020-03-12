package sjt.http.core.response;

import sjt.http.core.HttpHeaders;

public class HttpResponse {
    private StartLine startLine;
    private HttpHeaders httpHeaders;
    private String body;

    public String toResponse() {
        return startLine.toResponse();
    }

    private HttpResponse(StartLine startLine) {
        this.startLine = startLine;
    }

    public static HttpResponse ok() {
        return new HttpResponse(StartLine.ok());
    }

    public static HttpResponse badRequest() {
        return new HttpResponse(StartLine.badRequest());
    }

    public static class StartLine {
        private String protocolVersion;
        private StatusCode statusCode;

        private StartLine(StatusCode statusCode) {
            this.protocolVersion = "HTTP/1.0";
            this.statusCode = statusCode;
        }

        static StartLine ok() {
            return new StartLine(StatusCode.OK);
        }

        static StartLine badRequest() {
            return new StartLine(StatusCode.BAD_REQUEST);
        }

        String toResponse() {
            return protocolVersion + " " + statusCode.getCode() + " " + statusCode.getMessage();
        }
    }
}
