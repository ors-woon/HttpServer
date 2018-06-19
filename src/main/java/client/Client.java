package main.java.client;

import java.io.*;
import java.net.Socket;

public class Client {

    private static final int PORT = 8080;
    private static final String HOST = "127.0.0.1";


    public static void main(String[] args) {
        try(Socket socket = new Socket(HOST, PORT)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str;
            while ((str = br.readLine()) != null ){
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
