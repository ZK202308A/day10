package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

    //bad code
    public static void main(String[] args) throws Exception {

        //서버소켓 5555
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Ready............");

        //byte[] 내용물을 담기 위해서
        byte[] buffer = new byte[1024];

        while (true) {

            //연결 accept()
            Socket socket = serverSocket.accept();

            //inputStream => read(byte[])
            InputStream inputStream = socket.getInputStream();
            int len = inputStream.read(buffer);

            System.out.println(new String(buffer, 0, len));

        }//end

    }

}
