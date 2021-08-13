package com.alex.marvel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

@Service
public class CharactersService {

    @Value("${mrv.publicKey}")
    String publicKey;

    @Value("${mrv.privateKey}")
    String privateKey;

    long ts = System.currentTimeMillis();
    int limit = 5;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    String id = "";

    RestTemplate restTemplate = new RestTemplate();

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

    byte[] md5InBytes = CharactersService.digest(stringToHash.getBytes(UTF_8));
    //    String hash = bytesToHex(md5InBytes);
    String hash = DigestUtils.md5DigestAsHex(md5InBytes);

    String allCharactersUrl = String.format("https//gateway.marvel.com/v1/public/characters?ts=%d&apikey=%s&hash=%s&limit=%d", ts, publicKey, hash, limit);
    String characterUrl = String.format("https//gateway.marvel.com/v1/public/characters/%d?ts=%s&apikey=%s&hash=%s&limit=%d",id, ts, publicKey, hash, limit);

    private List<Characters> characters = Arrays.asList(
            new Characters("1011334", "3-D Man", "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784"),
            new Characters("1017100", "A-Bomb (HAS)","http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16")
    );

    public List<Characters>getAllCharacters(){
        return characters;
    }

    public Characters getCharacter(String id){
        return characters.stream().filter(t ->t.getId().equals(id)).findFirst().get();
    }

}

