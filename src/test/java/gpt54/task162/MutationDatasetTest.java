package gpt54.task162;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(md5("Hello world"), s.stringToMd5("Hello world").orElseThrow()),
                () -> assertTrue(s.stringToMd5("").isEmpty()),
                () -> assertEquals(md5("A B C"), s.stringToMd5("A B C").orElseThrow()),
                () -> assertEquals(md5("password"), s.stringToMd5("password").orElseThrow()),
                () -> assertEquals(md5("  padded  "), s.stringToMd5("  padded  ").orElseThrow()),
                () -> assertEquals(md5("Istanbul"), s.stringToMd5("Istanbul").orElseThrow()),
                () -> assertEquals(md5("çilek"), s.stringToMd5("çilek").orElseThrow()),
                () -> assertEquals(md5("x".repeat(256)), s.stringToMd5("x".repeat(256)).orElseThrow()),
                () -> assertNotEquals(
                        s.stringToMd5("CaseSensitive").orElseThrow(),
                        s.stringToMd5("casesensitive").orElseThrow()
                ),
                () -> assertThrows(Throwable.class, () -> s.stringToMd5(null))
        );
    }

    private static String md5(String value) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(value.getBytes(StandardCharsets.UTF_8));
        StringBuilder builder = new StringBuilder();
        for (byte b : digest) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
