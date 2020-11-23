package com.company;

import java.io.*;

public class RussianInByte {
    public static void main(String [] args) throws IOException {
        File file = new File("C:\\Users\\1\\Desktop\\test.txt");
        FileInputStream i = new FileInputStream(file);
        i.read();
        i.close();
    }
}
