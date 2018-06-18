package main.java.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept(); // block
            try {
                OutputStream stream = socket.getOutputStream();
                stream.write("helloWorld".getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
