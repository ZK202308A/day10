package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server1 {

    //bad code
    public static void main(String[] args) throws Exception {

        //서버소켓 5555
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Ready............");


        while (true) {
            //연결 accept()
            try(Socket socket = serverSocket.accept();
                OutputStream out = socket.getOutputStream();
                FileInputStream fin = new FileInputStream("aaa.jpg");
            ) {

                out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                out.write(new String("Cache-Control: private\r\n").getBytes());
                out.write(new String("Content-Type: image/jpg\r\n\r\n").getBytes());

                byte[] buffer = new byte[1024 * 8]; //8kb

                while(true){
                    int count = fin.read(buffer); //새로 몇 개나 채워졌나 5,5,3,-1
                    if(count == -1) break;
                    out.write(buffer,0, count); //새로 채운 만큼만 써라.
                }//end while
                //out.write(msg.getBytes(StandardCharsets.UTF_8));
            }catch(Exception e) {
                e.printStackTrace();
                continue;
            }
        }//end

    }

}
