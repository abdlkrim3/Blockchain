package com.blockchain.blockchainworkshop.examples;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

public class SymmetricEncryption {

    private SymmetricEncryption() {
    }

    public static Key generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom();
        keyGenerator.init(256, secureRandom);
        return keyGenerator.generateKey();
    }

    public static byte[] encrypt(byte[] plainText, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(plainText);
    }

    public static byte[] decrypt(byte[] encryptedText, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(encryptedText);
    }


}
