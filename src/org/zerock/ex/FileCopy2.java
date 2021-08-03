package org.zerock.ex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCopy2 {
    //bad code
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        File file = new File("C:\\Users\\junga\\Desktop\\aaa.png");
        Path filePath = file.toPath();
        OutputStream out = new FileOutputStream("C:\\Users\\junga\\Desktop\\copy2.png");
        Files.copy(filePath, out);
      //  out.write(data);

        long end = System.currentTimeMillis(); System.out.println(end - start);
    }
}
