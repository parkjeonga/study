package org.zerock.ex01;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class OneToOneClient {

    //bad code - 나중에 톰캣에서 다처리하므러
    public static void main(String[] args) throws Exception {
        Scanner keyScanner = new Scanner(System.in);

        Socket socket = new Socket("127.0.0.1",9999);
        System.out.println("connected...");
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        Scanner inScanner = new Scanner(in);
    // 문자열을 byte[] 바꿔서 out.write(바이트배열)

        for(int i=0; i<100;i++) {
            String msg = "Client : "+ keyScanner.nextLine() + "\n";
            out.write(msg.getBytes()); // 서버에게 전달

            System.out.println("------------------------------------");
            System.out.println(inScanner.nextLine());
        }
         out.close();
        socket.close();


    }
}
