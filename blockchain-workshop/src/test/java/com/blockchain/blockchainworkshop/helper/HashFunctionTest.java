package com.blockchain.blockchainworkshop.helper;
import com.blockchain.blockchainworkshop.examples.HashFunction;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HashFunctionTest {

    @Test
    void testHash() throws NoSuchAlgorithmException {
        String data = "hello, world!";
        byte[] expectedHash = {104, -26, 86, -78, 81, -26, 126, -125, 88, -66, -8, 72, 58, -80, -43, 28, 102, 25, -13, -25, -95, -87, -16, -25, 88, 56, -44, 31, -13, 104, -9, 40};
        byte[] actualHash = HashFunction.hash(data);
        assertArrayEquals(expectedHash, actualHash);
    }
}





