package com.ikats.passwordsaver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Encryption {

    public static String Encrypt(String value){}

    public static String Decrypt(String value){}

    public static String GetKey(File file){

        String key = null;

        BufferedReader brTest = null;
        try {
            brTest = new BufferedReader(new FileReader(file));
            key = brTest.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return key;
    }
}
