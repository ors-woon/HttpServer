package main.java.server;


import lombok.extern.java.Log;
import main.java.message.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Log
public class Server {

    private static final int PORT = 8080;

    public static void main(String[] args) {

        connetClient();
    }

    private static void connetClient() {
        try (Socket socket = new ServerSocket(PORT).accept()) {
            OutputStream out = socket.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Request request = Request.init(in);
            System.out.println(request.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
