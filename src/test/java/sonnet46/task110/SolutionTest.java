package sonnet46.task110;

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
        assertEquals("YES", s.exchange(Arrays.asList(1, 2, 3, 4), Arrays.asList(1, 2, 3, 4)));
        assertEquals("NO", s.exchange(Arrays.asList(1, 2, 3, 4), Arrays.asList(1, 5, 3, 4)));
        assertEquals("YES", s.exchange(Arrays.asList(1, 2, 3, 4), Arrays.asList(2, 1, 4, 3)));
        assertEquals("YES", s.exchange(Arrays.asList(5, 7, 3), Arrays.asList(2, 6, 4)));
        assertEquals("NO", s.exchange(Arrays.asList(5, 7, 3), Arrays.asList(2, 6, 3)));
        assertEquals("YES", s.exchange(Arrays.asList(100, 200), Arrays.asList(200, 200)));
    }

    @Test
    void edgeCases() {
        Solution s = new Solution();
        // lst1 already all even — no exchange needed
        assertEquals("YES", s.exchange(Arrays.asList(2, 4, 6), Arrays.asList(1, 3, 5)));
        // lst1 all odd, lst2 has no evens
        assertEquals("NO", s.exchange(Arrays.asList(1, 3), Arrays.asList(5, 7)));
        // Exactly enough evens in lst2
        assertEquals("YES", s.exchange(Arrays.asList(1, 3), Arrays.asList(2, 4)));
        // One short
        assertEquals("NO", s.exchange(Arrays.asList(1, 3, 5), Arrays.asList(2, 4)));
    }
}
