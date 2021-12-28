package com.example.demo.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static String getMD5(String info) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(info.getBytes());
            byte[] digest = md5.digest();
            StringBuilder builder = new StringBuilder();
            int curr;
            for (int i = 0; i < digest.length; i++) {
                curr = digest[i];
                if (curr < 0) {
                    curr += 256;
                } else {
                    builder.append(0);
                }
                builder.append(Integer.toHexString(curr));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
