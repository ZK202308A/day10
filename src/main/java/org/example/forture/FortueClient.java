package org.example.forture;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class FortueClient {

    //bad code
    public static void main(String[] args)throws Exception {

        Socket socket = new Socket("127.0.0.1", 5555);

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        String str = dis.readUTF();

        System.out.println(str);

    }
}
