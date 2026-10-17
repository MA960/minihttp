
package minihttp;

public class Main {

    public static void main(String[] args) {
        ServerManager server = new ServerManager(8080);
        server.start();
    }
}
