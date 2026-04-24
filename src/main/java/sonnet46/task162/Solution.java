package sonnet46.task162;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Given a string "text", return its md5 hash equivalent string with length being 32.
     * If "text" is an empty string, return Optional.empty().
     *
     * >>> stringToMd5("Hello world") == "3e25960a79dbc69b674cd4ec67a72c62"
     */
    public Optional<String> stringToMd5(String text) throws NoSuchAlgorithmException {
        if (text.isEmpty()) {
            return Optional.empty();
        }
        byte[] digest = MessageDigest.getInstance("MD5").digest(text.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        String hex = new BigInteger(1, digest).toString(16);
        // Pad to 32 characters with leading zeros
        while (hex.length() < 32) {
            hex = "0" + hex;
        }
        return Optional.of(hex);
    }
}
