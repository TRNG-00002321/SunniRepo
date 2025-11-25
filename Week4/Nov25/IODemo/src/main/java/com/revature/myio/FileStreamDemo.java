package com.revature.myio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamDemo {
    public static void main(String[] args) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        try {
            fileInputStream = new FileInputStream("example.txt");
            fileOutputStream = new FileOutputStream("output1.txt");
            int c;
            while((c = fileInputStream.read()) != -1){
                System.out.write(c);
                fileOutputStream.write(c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
