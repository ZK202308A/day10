package org.example.forture;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FortuneServer {

    //bad code
    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(5555);

        System.out.println("Ready.................");

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getInetAddress());
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String text = FortureTeller.INSTANCE.getOne();

            dataOutputStream.writeUTF(text);
            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();
        }//end while

    }
}
