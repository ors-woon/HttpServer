package main.java.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket  = new ServerSocket(PORT).accept()) {
            OutputStream stream = socket.getOutputStream();
            stream.write("helloWorld".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
