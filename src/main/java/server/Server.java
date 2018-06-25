package main.java.server;


import lombok.extern.java.Log;
import main.java.message.Request;
import main.java.message.Response;

import java.io.*;
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
            // input
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Request request = Request.init(in);
            // - input

            // output
            OutputStream out = socket.getOutputStream();
            Response response = Response.init();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeBytes(response.toString());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
