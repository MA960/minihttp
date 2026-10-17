
package minihttp;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.util.*;

public class RequestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();

        System.out.println(method + " " + path);

        if (!method.equals("GET")) {
            ResponseUtil.send(
                exchange,
                405,
                "<h1>405 - Method Not Allowed</h1>"
            );
            return;
        }

        switch (path) {
            case "/":
                ResponseUtil.send(
                    exchange,
                    200,
                    "<h1>Welcome to Mini HTTP Server!</h1>"
                    + "<p>Your Java server is working.</p>"
                );
                break;

            case "/hello":
                ResponseUtil.send(
                    exchange,
                    200,
                    "<h1>Hello, World!</h1>"
                );
                break;

            case "/about":
                ResponseUtil.send(
                    exchange,
                    200,
                    "<h1>About This Project</h1>"
                    + "<p>A beginner Java HTTP server.</p>"
                );
                break;

            default:
                ResponseUtil.send(
                    exchange,
                    404,
                    "<h1>404 - Page Not Found</h1>"
                );
                break;
        }
    }
}
