package com.example.uploader;

import java.security.SecureRandom;
import java.util.Base64;

public class AppUtils {

        public static void main(String[] args) {

            byte[] keyBytes = new byte[32];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(keyBytes);


            String signingKey = Base64.getEncoder().encodeToString(keyBytes);

            System.out.println("Signing Key: " + signingKey);
        }
    }

