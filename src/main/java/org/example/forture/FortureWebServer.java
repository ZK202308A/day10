package org.example.forture;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class FortureWebServer {

    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Ready.......................");

        while (true) {
            try(Socket socket = serverSocket.accept();
                OutputStream out = socket.getOutputStream();) {

                String msg = FortureTeller.INSTANCE.getOne();

                out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());

                out.write(new String("Cache-Control: private\r\n").getBytes());
                out.write(new String("Content-Length: "+msg.getBytes("UTF-8").length+"\r\n").getBytes());
                out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());

                out.write(msg.getBytes(StandardCharsets.UTF_8));

            }

        }//end while


    }
}
