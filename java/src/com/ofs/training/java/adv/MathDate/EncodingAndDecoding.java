// Encoding and decoding a String. Encode a password string and decode it using Base64.

package com.ofs.training.java.adv.MathDate;

import java.util.Base64;

public class EncodingAndDecoding {

    public static void main(String[] args) {

        Base64.Encoder encoder = Base64.getEncoder();

        String str = encoder.encodeToString("hello1234".getBytes());
        System.out.println("encoded value: " +str);

        Base64.Decoder decoder = Base64.getDecoder();

        String string = new String(decoder.decode(str));
        System.out.println("decoded value: " +string);
        byte[] s = decoder.decode(str);
        System.out.println(s);
    }
}


