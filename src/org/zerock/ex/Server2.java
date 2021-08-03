package org.zerock.ex;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

public class Server2 {

    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Ready..............");

        for(int i = 0; i < 10; i++) {

            // 블럭드 IO
            Socket client = serverSocket.accept();
            System.out.println(client);
           File file = new File("C:\\Users\\junga\\WebstormProjects\\w1\\list.html");
            OutputStream out = client.getOutputStream();
            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());   //응답해줘
            out.write(new String("Cache-Control: private\r\n").getBytes());
           // 단일사용자를 위한것이며 공유캐시에 저장되면 안되는 것을 가리킨다.
            out.write(new String("Content-Length: "+file.length()+"\r\n").getBytes());  //수신자에게 보냄
            out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes()); // 보내는 타입

            Files.copy(file.toPath(), out);
        } // end for
    }
}