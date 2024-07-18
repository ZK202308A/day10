package org.example.file;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("ready...............");

        try(
            Socket socket = serverSocket.accept();
            FileInputStream fis = new FileInputStream("C:\\zzz\\M1.jpeg");
            OutputStream os = socket.getOutputStream();
        ) {        // 파일 전송
            byte[] buffer = new byte[1024 * 8];

            while (true) {
                int count = fis.read(buffer);
                if (count == -1) {
                    break;
                }
                os.write(buffer, 0, count);
            }//end while
        }catch(Exception e) {

        }

    }

}
