package com.revature.myio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamDemo {
    public static void main(String[] args) {

        try(FileReader fileReader = new FileReader("example.txt");
            FileWriter fileWriter = new FileWriter("output2.txt")) {
            int c;
            while((c = fileReader.read()) != -1){
                fileWriter.write(c);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
