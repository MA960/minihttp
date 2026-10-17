
package minihttp;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerManager {

    private final int port;
    private HttpServer server;

    public ServerManager(int port) {
        this.port = port;
    }

    public void start() {
        try {
            server = HttpServer.create(
                new InetSocketAddress(port), 0
            );

            server.createContext("/", new RequestHandler());

            server.start();

            System.out.println(
                "Server running at http://localhost:" + port
            );

        } catch (IOException e) {
            System.out.println("Could not start the server.");
            e.printStackTrace();
        }
    }

    public void stop() {
        if (server != null) {
            server.stop(0);
            System.out.println("Server stopped.");
        }
    }
}
