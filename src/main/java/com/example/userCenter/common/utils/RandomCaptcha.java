package com.example.userCenter.common.utils;

import java.util.Random;

public class RandomCaptcha {

    private static char[] randString = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B','C', 'D', 'E',
            'F', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public static String get() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        int count = 0;
        int seed = randString.length;
        while (count < 4) {
            builder.append(randString[random.nextInt(seed)]);
            count++;
        }
        return builder.toString();
    }
}
