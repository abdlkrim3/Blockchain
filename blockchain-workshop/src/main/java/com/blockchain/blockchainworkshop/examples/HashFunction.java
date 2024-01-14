package com.blockchain.blockchainworkshop.examples;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunction {

    public static byte[] hash(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return md.digest();
    }
}
