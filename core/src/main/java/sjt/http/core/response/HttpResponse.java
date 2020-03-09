package sjt.http.core.response;

public class HttpResponse {
    private StartLine startLine;
    private HttpHeaders httpHeaders;

    public String toResponse() {
        return startLine.toResponse();
    }

    private HttpResponse(StartLine startLine) {
        this.startLine = startLine;
    }

    private HttpResponse(StartLine startLine, HttpHeaders httpHeaders) {
        this.startLine = startLine;
        this.httpHeaders = httpHeaders;
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

        public static StartLine ok() {
            return new StartLine(StatusCode.OK);
        }

        public static StartLine badRequest() {
            return new StartLine(StatusCode.BAD_REQUEST);
        }

        public String toResponse() {
            return protocolVersion + " " + statusCode.getCode() + " " + statusCode.getMessage();
        }
    }

    public static class HttpHeaders {

    }

}
