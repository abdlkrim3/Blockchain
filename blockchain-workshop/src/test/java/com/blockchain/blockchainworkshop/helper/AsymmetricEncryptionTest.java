package com.blockchain.blockchainworkshop.helper;

import com.blockchain.blockchainworkshop.examples.AsymmetricEncryption;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AsymmetricEncryptionTest {

    @Test
    public void testEncryptionAndDecryption() throws Exception {
        KeyPair keyPair = AsymmetricEncryption.generateKeyPair();

        byte[] plainText = "Hello World!".getBytes();

        byte[] encryptedText = AsymmetricEncryption.encrypt(plainText, keyPair.getPublic());

        byte[] decryptedText = AsymmetricEncryption.decrypt(encryptedText, keyPair.getPrivate());

        assertNotNull(keyPair);
        assertArrayEquals(plainText, decryptedText);
    }
}
