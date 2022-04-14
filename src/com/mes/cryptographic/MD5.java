package com.mes.cryptographic;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MD5 implements Cryptographic{
    @Override
    public String encoding(String val) {
        String result = "";

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            messageDigest.update(val.getBytes(StandardCharsets.UTF_8));
            byte[] md5hash = messageDigest.digest();

            StringBuilder hexMD5hash = new StringBuilder();
            for(byte b : md5hash){
                String hexString = String.format("%02x",b);
                hexMD5hash.append(hexString);
                result += hexString;
            }
        } catch (Exception e){
            return "";
        }
        return result;
    }

    @Override
    public String decoding(String val) {
        return "";
    }
}
