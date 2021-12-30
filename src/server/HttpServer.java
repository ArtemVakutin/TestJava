package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {


    public static void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        String htmlpage =
                "<html>" +
                "\n" +
                "<head>\n" +
                "\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title> Пример простой страницы html</title>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "Пример простой страницы - для того, чтобы посмотреть код, нажмите ctrl + U\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>\n";
        String header = "HTTP/1.1 200 OK\n" + "Content-Type: text/html\n" + "Content-Length: " + htmlpage.length() + "\n"
                + "Connection: close\n\n";

        String result = header + htmlpage;
        outputStream.write(result.getBytes());


        serverSocket.close();


    }



}
