package org.zerock.ex01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("include-hoany.asuscomm.com",9999);
        System.out.println(socket);
        InputStream in = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("c:\\zzz\\get.jpg");

        byte[] buffer = new byte[1024*8];

        while (true){
            int count = in.read(buffer);// 몇개나 새로운 데이터가 왔는가
            if(count == -1){break;}
            fos.write(buffer,0,count); //맨앞부터 새로운데이터까지
        }



      fos.close();
        socket.close();
    }
}
