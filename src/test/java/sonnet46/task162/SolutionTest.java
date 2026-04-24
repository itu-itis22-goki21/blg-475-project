package sonnet46.task162;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void sampleCases() throws NoSuchAlgorithmException {
        Solution s = new Solution();
        assertEquals("3e25960a79dbc69b674cd4ec67a72c62", s.stringToMd5("Hello world").get());
        assertTrue(s.stringToMd5("").isEmpty());
        assertEquals("0ef78513b0cb8cef12743f5aeb35f888", s.stringToMd5("A B C").get());
        assertEquals("5f4dcc3b5aa765d61d8327deb882cf99", s.stringToMd5("password").get());
    }

    @Test
    void edgeCases() throws NoSuchAlgorithmException {
        Solution s = new Solution();
        // Empty string → Optional.empty()
        assertFalse(s.stringToMd5("").isPresent());
        // Single character — result is 32 hex chars
        Optional<String> result = s.stringToMd5("a");
        assertTrue(result.isPresent());
        assertEquals(32, result.get().length());
        // Deterministic — same input same output
        assertEquals(s.stringToMd5("test").get(), s.stringToMd5("test").get());
    }
}
