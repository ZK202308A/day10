package org.example.file;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileClient {

    public static void main(String[] args) throws Exception{

        //연결
        try(Socket socket = new Socket("127.0.0.1", 5555);
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream("copy.jpeg");
        ) {//파일 저장
            byte[] buffer = new byte[100];

            while (true) {
                int count = is.read(buffer);
                if (count == -1) {
                    break;
                }
                fos.write(buffer, 0, count);
            }//end while
        }

    }
}
