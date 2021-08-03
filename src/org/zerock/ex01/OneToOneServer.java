package org.zerock.ex01;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class OneToOneServer {

    //bad code
    public static void main(String[] args) throws Exception {
        Scanner keyScanner = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Ready...");
        Socket client = serverSocket.accept();
        System.out.println("client connected...");

        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();
        Scanner sc = new Scanner(in);

        for(int i=0; i<100;i++) {

            String line = sc.nextLine();
            System.out.println(line);

            String msg = "SERVER : "+keyScanner.nextLine() + "\n";  // 메세지 전달
            out.write(msg.getBytes());  //client 메세지

        }
        sc.close();
        in.close();
        client.close();
        serverSocket.close();

    }
}
