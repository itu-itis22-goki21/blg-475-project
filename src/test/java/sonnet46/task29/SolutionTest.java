package sonnet46.task29;

/* @Authors
 * Student Names: İhsan Gök, Ozan Ölmez, Atahan Çolak
 * Student IDs: 150210093, 150220045, 150210106
 */

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void sampleCases() {
        Solution s = new Solution();
        assertEquals(List.of(),
                s.filterByPrefix(new ArrayList<>(List.of()), "john"));
        assertEquals(Arrays.asList("xxx", "xxxAAA", "xxx"),
                s.filterByPrefix(new ArrayList<>(Arrays.asList("xxx", "asd", "xxy", "john doe", "xxxAAA", "xxx")), "xxx"));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // No elements match
        assertEquals(List.of(),
                s.filterByPrefix(new ArrayList<>(Arrays.asList("abc", "def", "ghi")), "z"));
        // Empty prefix — all elements match
        assertEquals(Arrays.asList("abc", "def"),
                s.filterByPrefix(new ArrayList<>(Arrays.asList("abc", "def")), ""));
        // All elements match
        assertEquals(Arrays.asList("apple", "apricot"),
                s.filterByPrefix(new ArrayList<>(Arrays.asList("apple", "apricot")), "ap"));
    }
}
