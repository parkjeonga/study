package org.zerock.ex01;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileFastCopy { // 입출력 과정중 가장 중요한 코드
    public static void main(String[] args) {

try(InputStream fin = new FileInputStream("C:\\zzz\\sample.txt");
    OutputStream fos = new FileOutputStream("C:\\zzz\\copy.txt");// 자동으로 클로즈 됨
){


    byte[] arr = new byte[5];//8kb

    while(true) {
        int count = fin.read(arr); // 몇개나 새로운 데이터를 읽었나
        if (count == -1) { break; }
       //fos.write(arr, 0, count);
       fos.write(arr);  //
    }

}catch (Exception e){ e.printStackTrace();}
}
}