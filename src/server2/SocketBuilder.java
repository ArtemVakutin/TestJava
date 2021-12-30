package server2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketBuilder {

    public static void startSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        while (true) {
        Socket socket = serverSocket.accept();
        new Thread(new SocketDispatcher(socket)).start();
        }

    }

}
