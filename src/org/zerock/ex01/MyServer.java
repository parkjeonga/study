package org.zerock.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    //bad code close 철저히
    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Ready...");

        while(true){

            Socket client = serverSocket.accept();
            System.out.println(client);

            OutputStream out = client.getOutputStream();

            File file = new File("C:\\zzz\\food.jpg");

            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: "+file.length()+"\r\n").getBytes());
            out.write(new String("Content-Type: image/jpeg\r\n\r\n").getBytes());

            //out.write(97);
            InputStream fin = new FileInputStream("C:\\zzz\\food.jpg");

            byte[] buffer = new byte[1024*8];

            while(true){
                int count = fin.read(buffer); // 새로운 코드를 읽어랑
                if(count == -1){ break; }
                out.write(buffer,0,count); // 맨앞부터 새로운코드까지

            }//end while

            //fin.close();

            //out.close();
            //client.close();

        }//end while

    }
}