package sonnet46.task16;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void sampleCases() {
        Solution s = new Solution();
        assertEquals(0, s.countDistinctCharacters(""));
        assertEquals(5, s.countDistinctCharacters("abcde"));
        assertEquals(5, s.countDistinctCharacters("abcdecadeCADE"));
        assertEquals(1, s.countDistinctCharacters("aaaaAAAAaaaa"));
        assertEquals(5, s.countDistinctCharacters("Jerry jERRY JeRRRY"));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // Single char
        assertEquals(1, s.countDistinctCharacters("z"));
        // Case insensitive: xyzXYZ → 3
        assertEquals(3, s.countDistinctCharacters("xyzXYZ"));
        // Spaces count as distinct characters
        assertEquals(2, s.countDistinctCharacters("a a"));
        // All same lowercase
        assertEquals(1, s.countDistinctCharacters("aaaa"));
    }
}
