
package minihttp;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ResponseUtil {

    public static void send(
            HttpExchange exchange,
            int statusCode,
            String html) throws IOException {

        byte[] responseBytes =
            html.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().set(
            "Content-Type",
            "text/html; charset=UTF-8"
        );

        exchange.sendResponseHeaders(
            statusCode,
            responseBytes.length
        );

        try (OutputStream output =
                 exchange.getResponseBody()) {
            output.write(responseBytes);
        }
    }
}
