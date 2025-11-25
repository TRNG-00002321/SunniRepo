package com.revature.myio;

import java.io.*;

public class BufferedStreamDemo {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("example.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output3.txt"))) {
            String l = null;
            while((l = bufferedReader.readLine()) != null){
                bufferedWriter.write(l);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
