package sjt.http.server;

import lombok.extern.slf4j.Slf4j;
import sjt.http.core.request.HttpRequest;
import sjt.http.core.response.HttpResponse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class SjtWebServer {

    public static final String ACCEPT_CRLF = "\r\n";

    public static void main(String[] args) throws IOException {
        // 서버 생성을 위한 serversocket
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            while (true) {
                try (
                        Socket client = serverSocket.accept(); // client와 통신하기 위한 socket, client 접속 대기
                        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())))) {

                    HttpRequest httpRequest = new HttpRequest();
                    String request = in.readLine();
                    parse(request);

                    String header;
                    while (!(header = in.readLine()).equals("")) {
                            out.write(parse(request));
                    }
                }
            }
        }
    }

    private static String parse(String request) {
        try {
            HttpRequest.StartLine startLine = new HttpRequest.StartLine(request);
            log.info("client request: " + startLine.toString());
            return HttpResponse.ok().toResponse();
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            return HttpResponse.badRequest().toResponse();
        }
    }
}