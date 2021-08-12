package com.alex.marvel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class CharactersController {

    @Value("${mrv.publicKey}")
    String publicKey;

    @Value("${mrv.privateKey}")
    String privateKey;

    long ts = System.currentTimeMillis();
    int limit = 5;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    String stringToHash = ts + privateKey + publicKey;

    private static byte[] digest(byte[] input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }
/*    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }*/

    byte[] md5InBytes = CharactersController.digest(stringToHash.getBytes(UTF_8));
//    String hash = bytesToHex(md5InBytes);
    String hash = DigestUtils.md5DigestAsHex(md5InBytes);

    String url = String.format("https//gateway.marvel.com/v1/public/characters?ts=%d&apikey=%s&hash=%s&limit=%d", ts, publicKey, hash, limit);
//    String output = new
}
