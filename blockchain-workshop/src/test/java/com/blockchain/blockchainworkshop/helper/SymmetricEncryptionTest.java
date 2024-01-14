package com.blockchain.blockchainworkshop.helper;

import com.blockchain.blockchainworkshop.examples.SymmetricEncryption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import java.security.Key;

public class SymmetricEncryptionTest {

    private static final String PLAIN_TEXT = "Hello, world!";
    private Key key;

    @BeforeEach
    public void setUp() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        key = keyGenerator.generateKey();
    }

    @Test
    public void testEncryptDecrypt() throws Exception {
        byte[] encrypted = SymmetricEncryption.encrypt(PLAIN_TEXT.getBytes(), key);
        byte[] decrypted = SymmetricEncryption.decrypt(encrypted, key);
        Assertions.assertEquals(PLAIN_TEXT, new String(decrypted));
    }

    @Test
    public void testGenerateKey() throws Exception {
        Key key = SymmetricEncryption.generateKey();
        Assertions.assertEquals("AES", key.getAlgorithm());
        Assertions.assertEquals(256, key.getEncoded().length * 8);
    }

    @Test
    public void testDecryptWithWrongKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        Key wrongKey = keyGenerator.generateKey();

        byte[] encrypted = SymmetricEncryption.encrypt(PLAIN_TEXT.getBytes(), key);
        byte[] decrypted = SymmetricEncryption.decrypt(encrypted, wrongKey);
        Assertions.assertNotEquals(PLAIN_TEXT, new String(decrypted));
    }
}
