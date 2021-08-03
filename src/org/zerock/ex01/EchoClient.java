package org.zerock.ex01;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws Exception{
        Scanner keysc = new Scanner(System.in);

        while (true){
            System.out.println("Input your Message");
            String msg = keysc.nextLine();

            if(msg.equalsIgnoreCase("exit")){break;}

            Socket socket = new Socket("127.0.0.1",9999);
            InputStream in = socket.getInputStream();
            Scanner insc = new Scanner(in);
            OutputStream out = socket.getOutputStream();


            String sneMsg = msg + "\n";
            out.write(sneMsg.getBytes());
            System.out.println(msg);

            out.close();
            insc.close();
            in.close();
            socket.close();


        }//end while



    }
}
