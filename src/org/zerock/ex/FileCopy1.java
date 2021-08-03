package org.zerock.ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileCopy1 {

    //bad code
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://cdn.011st.com/11dims/resize/900x900/quality/75/11src/cat/20/4/5/7/8/8/2/FYCUv/33457882_1.jpg");
        InputStream in = url.openStream();
        System.out.println(in);
        long start = System.currentTimeMillis();
        OutputStream out = new FileOutputStream("C:\\Users\\junga\\Desktop\\copy.png");
        while (true){
            int data = in.read();

            if(data == -1){break;}  // 다 복사되면 -1값이 나옴

            out.write(data);

            long end = System.currentTimeMillis(); System.out.println(end - start);
        }



    }
}
