package com.ikats.passwordsaver;

import java.util.Random;

public class Encryption {

    public static String Encrypt(String key, String value){

        int magic = -1;
        while (magic < 0)
            magic = new Random().nextInt() % 256;

        char arr[] = value.toCharArray();

        for(int i=0; i<key.length(); i++){

            for(int j=0; j<value.length(); j++){

                arr[j] = (char) (arr[j] + magic * key.charAt(i) + key.length() + value.length());
                while(arr[j] >= 256)
                    arr[j] -= 256;

            }

        }

        String m = String.format("%02X", magic);

        StringBuilder builder = new StringBuilder();

        builder.append(m.charAt(0));

        for(char s : arr) {
            builder.append(String.format("%02X", (int) s));
        }

        for(int i=0; i<3; i++){

            int n = (new Random().nextInt()) % 16;
            while(n < 0)
                n = (new Random().nextInt()) % 16;

            builder.append(String.format("%01X", n));

        }

        builder.append(m.charAt(1));

        String result = builder.toString();

        return result;
    }

    public static String Decrypt(String key, String value) {

        char[] m = new char[2];
        m[0] = value.charAt(0);
        m[1] = value.charAt(value.length()-1);

        int magic = Integer.parseInt(new String(m), 16);

        char[] arr = new char[(value.length() - 4) / 2];

        for(int i=1; i<value.length()-4; i+=2){

            String s = new StringBuilder().append(value.charAt(i)).append(value.charAt(i+1)).toString();
            arr[i/2] = (char) Integer.parseInt(s, 16);

        }

        for(int i=0; i<key.length(); i++){

            for(int j=0; j<arr.length; j++){

                int c = (arr[j] - (magic * key.charAt(i) + key.length() + (value.length() - 4) / 2));
                while(c < 0)
                    c += 256;
                arr[j] = (char) c;

            }

        }

        StringBuilder builder = new StringBuilder();

        for (char c : arr) {
            builder.append(c);
        }

        String result = builder.toString();

        return result;
    }
}
