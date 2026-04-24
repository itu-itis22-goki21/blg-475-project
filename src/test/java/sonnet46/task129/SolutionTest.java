package sonnet46.task129;

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
        assertEquals(Arrays.asList(1, 2, 1),
                s.minPath(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)), 3));
        assertEquals(List.of(1),
                s.minPath(Arrays.asList(Arrays.asList(5, 9, 3), Arrays.asList(4, 1, 6), Arrays.asList(7, 8, 2)), 1));
        assertEquals(Arrays.asList(1, 2, 1, 2),
                s.minPath(Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8), Arrays.asList(9, 10, 11, 12), Arrays.asList(13, 14, 15, 16)), 4));
        assertEquals(Arrays.asList(1, 10, 1, 10, 1, 10, 1),
                s.minPath(Arrays.asList(Arrays.asList(6, 4, 13, 10), Arrays.asList(5, 7, 12, 1), Arrays.asList(3, 16, 11, 15), Arrays.asList(8, 14, 9, 2)), 7));
        assertEquals(Arrays.asList(1, 2, 1, 2, 1, 2, 1, 2, 1, 2),
                s.minPath(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4)), 10));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // k=1 always returns [1]
        assertEquals(List.of(1),
                s.minPath(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4)), 1));
        // k=2 returns [1, minNeighbor]
        assertEquals(Arrays.asList(1, 3),
                s.minPath(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 2)), 2));
        // 1 at top-left corner (only 2 neighbors instead of 4)
        assertEquals(Arrays.asList(1, 2, 1),
                s.minPath(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)), 3));
    }
}
