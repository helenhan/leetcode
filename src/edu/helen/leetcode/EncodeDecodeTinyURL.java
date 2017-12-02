package edu.helen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://discuss.leetcode.com/topic/82273/three-different-approaches-in-java
 * Created by Helen on 11/20/2017.
 */
public class EncodeDecodeTinyURL {
    Map<Integer,String> map = new HashMap<>();
    String url = "http://www.tinyURL.com";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(),longUrl);
        return url + longUrl.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace(url,"")));
    }
}
